package controlador;


import modelo.Cliente;
import modelo.GestorCliente;

public class ControladorCliente {

  
    public boolean insertarCliente(Cliente cliente) {
        GestorCliente gestorCliente = new GestorCliente();
        try {
            return gestorCliente.insertarCliente(cliente);
        } catch (Exception e) {
            System.out.println("⚠ Error al insertar el cliente: " + e.getMessage());
            return false;
        }
    }

    public Cliente clienteLogin(String DNI, String Cliente_Pass_hash) {
        GestorCliente gestorCliente = new GestorCliente();
        return gestorCliente.clienteLogin(DNI, Cliente_Pass_hash);
    }

    public boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        String regex = "^[A-Za-z0-9+_.-]+@(.+)\\.com$";
        return email.matches(regex);
    }
}
