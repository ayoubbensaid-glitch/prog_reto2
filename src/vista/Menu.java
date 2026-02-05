package vista;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import controlador.*;
import modelo.*;

public class Menu {

    private Scanner teclado = new Scanner(System.in);
    private ControladorCliente controladorCliente = new ControladorCliente();
    private ControladorEntrada controladorEntrada = new ControladorEntrada();
    private ControladorCompra controladorCompra = new ControladorCompra();
    private ControladorPelis controladorPelis = new ControladorPelis();
    private ControladorSesion controladorSesion = new ControladorSesion();
    private ControladorTicket controladorTicket = new ControladorTicket();

    private Cliente clienteLogueado = null;
    private ArrayList<Entrada> carritoEntradas = new ArrayList<>();

    private int leerEnteroSeguro(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Debes introducir un número válido.");
            }
        }
    }

    public void verMenu() {
        int opcion;
        do {
            System.out.println("\n============== Bienvenido a CineMax Bilbao ==============");
            System.out.println("1. Ver películas disponibles");
            System.out.println("2. Finalizar compra y mostrar resumen");
            System.out.println("3. Salir");

            opcion = leerEnteroSeguro("Introduce una opción: ");

            switch (opcion) {
                case 1: verPelis(); break;
                case 2: finalizarCompra(); break;
                case 3: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("❌ Opción inválida.");
            }

        } while (opcion != 3);

        teclado.close();
        System.out.println("Gracias por usar CineMax Bilbao. ¡Hasta pronto!");
    }

    private void verPelis() {

        ArrayList<Pelis> peliculas = controladorPelis.seleccionarPelisOrdenadas();

        if (peliculas.isEmpty()) {
            System.out.println("🚫 No hay películas disponibles.");
            return;
        }

        System.out.println("\n🎬 PELÍCULAS DISPONIBLES");

        for (int i = 0; i < peliculas.size(); i++) {
            Pelis p = peliculas.get(i);
            System.out.printf("%2d. %-30s | %.2f€\n",
                    i + 1, p.getPeli_Titulo(), p.getPeli_Precio());
        }

        System.out.println("0. Volver");

        while (true) {

            int opcion = leerEnteroSeguro("Selecciona una película: ");

            if (opcion == 0) return;

            if (opcion >= 1 && opcion <= peliculas.size()) {
                seleccionarFechaYSesion(peliculas.get(opcion - 1));
                return;
            }

            System.out.println("❌ Opción inválida.");
        }
    }

    private void seleccionarFechaYSesion(Pelis peli) {

        ArrayList<Sesion> fechas = controladorSesion.buscarFechasSesionPorPeli(peli.getPeli_ID());

        if (fechas.isEmpty()) {
            System.out.println("🚫 No hay fechas disponibles.");
            return;
        }

        System.out.println("\n📅 Fechas disponibles:");

        for (int i = 0; i < fechas.size(); i++) {
            System.out.println((i + 1) + ". " + fechas.get(i).getSesion_Fech());
        }

        System.out.println("0. Volver");

        while (true) {

            int opcion = leerEnteroSeguro("Selecciona una fecha: ");

            if (opcion == 0) return;

            if (opcion >= 1 && opcion <= fechas.size()) {
                mostrarSesionesPorFecha(peli, fechas.get(opcion - 1).getSesion_Fech());
                return;
            }

            System.out.println("❌ Opción inválida.");
        }
    }

    private void mostrarSesionesPorFecha(Pelis peli, Date fecha) {

        ArrayList<Sesion> sesiones =
                controladorSesion.buscarSesionPorFechaEspecifica(peli.getPeli_ID(), fecha);

        if (sesiones.isEmpty()) {
            System.out.println("🚫 No hay sesiones disponibles.");
            return;
        }

        System.out.println("\n🎬 SESIONES DISPONIBLES:");

        for (int i = 0; i < sesiones.size(); i++) {
            Sesion s = sesiones.get(i);
            System.out.printf("%2d. Sala: %s | %s - %s | %.2f€\n",
                    i + 1,
                    s.getSala().getSala_Nombre(),
                    s.getSesion_Hora_Ini().toString().substring(0,5),
                    s.getSesion_Hora_Fin().toString().substring(0,5),
                    s.getSesion_Precio());
        }

        System.out.println("0. Volver");

        while (true) {

            int opcion = leerEnteroSeguro("Selecciona una sesión: ");

            if (opcion == 0) return;

            if (opcion >= 1 && opcion <= sesiones.size()) {
                agregarSesionACarrito(sesiones.get(opcion - 1));
                return;
            }

            System.out.println("❌ Opción inválida.");
        }
    }

    private void agregarSesionACarrito(Sesion sesion) {

        int cantidad = leerEnteroSeguro("Cantidad de entradas: ");

        if (cantidad <= 0) {
            System.out.println("❌ La cantidad debe ser mayor que 0.");
            return;
        }

        Entrada entrada = new Entrada();
        entrada.setSesion(sesion);
        entrada.setEntrada_Personas(cantidad);
        entrada.setEntrada_Precio(sesion.getSesion_Precio());

        carritoEntradas.add(entrada);

        System.out.println("✅ Entradas agregadas al carrito.");
    }

    private void finalizarCompra() {

        if (carritoEntradas.isEmpty()) {
            System.out.println("🚫 No tienes entradas en el carrito.");
            return;
        }

        autenticarCliente();

        Compra compra = new Compra();
        compra.setCliente(clienteLogueado);
        compra.setCompra_Fech(new Date(System.currentTimeMillis()));
        compra.setCompra_Hora(new java.sql.Time(System.currentTimeMillis()));

        HashSet<String> peliculasDistintas = new HashSet<>();

        for (Entrada e : carritoEntradas) {
            peliculasDistintas.add(e.getSesion().getPeli().getPeli_Titulo());
        }

        double descuento = 0.0;

        if (peliculasDistintas.size() == 2) descuento = 0.20;
        else if (peliculasDistintas.size() >= 3) descuento = 0.30;

        compra.setCompra_Descuento(descuento);

        controladorCompra.insertarCompra(compra);

        int numeroEntrada = 1;
        for (Entrada e : carritoEntradas) {
            e.setCompra(compra);
            controladorEntrada.insertarEntrada(e, numeroEntrada);
            numeroEntrada++;
        }

        controladorTicket.guardarTicket(compra.getCompra_ID());

        carritoEntradas.clear();

        System.out.println("✅ Compra finalizada correctamente.");
    }

    private void autenticarCliente() {

        while (clienteLogueado == null) {

            System.out.println("\n1. Iniciar sesión");
            System.out.println("2. Registrarse");

            int opcion = leerEnteroSeguro("Elige una opción: ");

            if (opcion == 1) loginCliente();
            else if (opcion == 2) registrarCliente();
            else System.out.println("❌ Opción inválida.");
        }
    }

    private void loginCliente() {

        System.out.print("DNI: ");
        String dni = teclado.nextLine();

        System.out.print("Contraseña: ");
        String pass = teclado.nextLine();

        Cliente c = controladorCliente.clienteLogin(dni, GestorCliente.sha256(pass));

        if (c != null) {
            clienteLogueado = c;
            System.out.println("✅ Login exitoso.");
        } else {
            System.out.println("❌ Login fallido.");
        }
    }
    private boolean registrarCliente() {

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("DNI: ");
        String dni = teclado.nextLine();

        String email;
        do {
            System.out.print("Email: ");
            email = teclado.nextLine();
            if (!controladorCliente.validarEmail(email)) {
                System.out.println("❌ Email inválido. Debe contener @ y .com");
            }
        } while (!controladorCliente.validarEmail(email));

        String password;
        do {
            System.out.print("Contraseña (mín 6 caracteres): ");
            password = teclado.nextLine();
            if (password.length() < 6) {
                System.out.println("❌ La contraseña debe tener al menos 6 caracteres");
            }
        } while (password.length() < 6);

        Cliente nuevo = new Cliente();
        nuevo.setCliente_Nom(nombre);
        nuevo.setCliente_Apel(apellido);
        nuevo.setDNI(dni);
        nuevo.setCliente_Correo(email);
        nuevo.setCliente_Pass_hash(GestorCliente.sha256(password));

        if (controladorCliente.insertarCliente(nuevo)) {
            clienteLogueado = nuevo;
            System.out.println("✅ Cliente registrado correctamente.");
            return true;
        } else {
            return false;
        }
    }

}
