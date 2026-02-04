package modelo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class GestorTicketTest {

    private GestorTicket gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorTicket();
    }

    private Ticket crearTicket(double Peli_Precio, double Compra_Descuento) {
        Ticket t = new Ticket();
        t.setEntrada_Precio_Final(Peli_Precio);
        t.setCompra_Descuento(Compra_Descuento);
        t.setCompra_ID("TEST001");
        return t;
    }

    // ==================== TESTS PARA calcularPrecioTotal ====================

    @Test
    void testListaVacia() {
        assertEquals(0, gestor.calcularPrecioTotal(new ArrayList<>()), 0.001);
    }

    @Test
    void testTicketsNull() {
        assertEquals(0, gestor.calcularPrecioTotal(null), 0.001);
    }

    @Test
    void testUnTicketSinDescuento() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(crearTicket(10, 0));
        assertEquals(10, gestor.calcularPrecioTotal(tickets), 0.001);
    }

    @Test
    void testVariosTicketsSinDescuento() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(crearTicket(10, 0));
        tickets.add(crearTicket(20, 0));
        tickets.add(crearTicket(5, 0));
        assertEquals(35, gestor.calcularPrecioTotal(tickets), 0.001);
    }

    @Test
    void testVariosTicketsConDescuento() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(crearTicket(10, 10));
        tickets.add(crearTicket(20, 10));
        tickets.add(crearTicket(5, 10));
        assertEquals(31.5, gestor.calcularPrecioTotal(tickets), 0.001);
    }

    @Test
    void testDescuento100Porciento() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(crearTicket(50, 100));
        assertEquals(0, gestor.calcularPrecioTotal(tickets), 0.001);
    }

    @Test
    void testDescuentoNegativoSeConvierteACero() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(crearTicket(50, -10));
        assertEquals(50, gestor.calcularPrecioTotal(tickets), 0.001);
    }

    @Test
    void testDescuentoMayor100SeConvierteA100() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(crearTicket(100, 150));
        assertEquals(0, gestor.calcularPrecioTotal(tickets), 0.001);
    }

    @Test
    void testPrecioNegativoSeConvierteACero() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(crearTicket(-20, 10));
        assertEquals(0, gestor.calcularPrecioTotal(tickets), 0.001);
    }

    @Test
    void testPrecioCeroConDescuento() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(crearTicket(0, 20));
        assertEquals(0, gestor.calcularPrecioTotal(tickets), 0.001);
    }

    @Test
    void testDescuentoDecimal() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(crearTicket(100, 12.5));
        assertEquals(87.5, gestor.calcularPrecioTotal(tickets), 0.001);
    }

    @Test
    void testVariosTicketsConPreciosYDescuentosVariados() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(crearTicket(15.50, 5));
        tickets.add(crearTicket(20, 5));
        tickets.add(crearTicket(8.99, 5));
        assertEquals(42.266, gestor.calcularPrecioTotal(tickets), 0.001);
    }

    // ==================== TESTS PARA generarFactura ====================

    @Test
    void testGenerarFacturaConTicketsNull(@TempDir Path tempDir) {
        assertDoesNotThrow(() -> gestor.generarFactura(null, tempDir.toString()));
        
        File[] archivos = tempDir.toFile().listFiles();
        assertTrue(archivos == null || archivos.length == 0);
    }

    @Test
    void testGenerarFacturaConTicketsVacio(@TempDir Path tempDir) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        gestor.generarFactura(tickets, tempDir.toString());
        
        File[] archivos = tempDir.toFile().listFiles();
        assertTrue(archivos == null || archivos.length == 0);
    }

    @Test
    void testGenerarFacturaConCarpetaNoExistente(@TempDir Path tempDir) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket = crearTicket(10, 0);
        ticket.setCompra_ID("COMPRA123");
        tickets.add(ticket);
        
        String carpetaNueva = tempDir.toString() + File.separator + "facturas";
        gestor.generarFactura(tickets, carpetaNueva);
        
        File archivoEsperado = new File(carpetaNueva, "ticket_compra_COMPRA123.txt");
        assertTrue(archivoEsperado.exists(), "El archivo debería haberse creado");
        assertTrue(archivoEsperado.length() > 0, "El archivo no debería estar vacío");
    }

    @Test
    void testGenerarFacturaConCarpetaExistente(@TempDir Path tempDir) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket = crearTicket(25.50, 15);
        ticket.setCompra_ID("TEST456");
        tickets.add(ticket);
        
        gestor.generarFactura(tickets, tempDir.toString());
        
        File archivoEsperado = new File(tempDir.toString(), "ticket_compra_TEST456.txt");
        assertTrue(archivoEsperado.exists());
    }

    @Test
    void testGenerarFacturaConVariosTickets(@TempDir Path tempDir) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        
        Ticket t1 = crearTicket(12, 10);
        t1.setCompra_ID("MULTI001");
        t1.setPeli_Titulo("Película 1");
        
        Ticket t2 = crearTicket(15, 10);
        t2.setCompra_ID("MULTI001");
        t2.setPeli_Titulo("Película 2");
        
        tickets.add(t1);
        tickets.add(t2);
        
        gestor.generarFactura(tickets, tempDir.toString());
        
        File archivo = new File(tempDir.toString(), "ticket_compra_MULTI001.txt");
        assertTrue(archivo.exists());
        
    }

    @Test
    void testGenerarFacturaConTicketPrecioNegativo(@TempDir Path tempDir) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket = crearTicket(-10, 20);
        ticket.setCompra_ID("NEG001");
        tickets.add(ticket);
        
        gestor.generarFactura(tickets, tempDir.toString());
        
        File archivo = new File(tempDir.toString(), "ticket_compra_NEG001.txt");
        assertTrue(archivo.exists());
        
    }

    // ==================== TESTS PARA obtenerTicketsPorCompra ====================

    @Test
    void testObtenerTicketsPorCompraConIDNulo() {
        ArrayList<Ticket> resultado = gestor.obtenerTicketsPorCompra(null);
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }

    @Test
    void testObtenerTicketsPorCompraConIDVacio() {
        ArrayList<Ticket> resultado = gestor.obtenerTicketsPorCompra("");
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }

    @Test
    void testObtenerTicketsPorCompraConIDNoExistente() {
        ArrayList<Ticket> resultado = gestor.obtenerTicketsPorCompra("NO_EXISTE_123");
        assertNotNull(resultado);
    }

    // ==================== TESTS DE INTEGRACIÓN/EDGE CASES ====================

    @Test
    void testTicketSinIDParaGenerarFactura(@TempDir Path tempDir) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket = crearTicket(10, 0);
        ticket.setCompra_ID(null);
        tickets.add(ticket);
        
        gestor.generarFactura(tickets, tempDir.toString());
        
        File archivo = new File(tempDir.toString(), "ticket_compra_null.txt");
        assertTrue(archivo.exists());
    }

    @Test
    void testCalculoConDescuentoCeroYTotalCero() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(crearTicket(0, 0));
        tickets.add(crearTicket(0, 0));
        assertEquals(0, gestor.calcularPrecioTotal(tickets), 0.001);
    }

    @Test
    void testOrdenNoAfectaCalculo() {
        ArrayList<Ticket> tickets1 = new ArrayList<>();
        tickets1.add(crearTicket(10, 20));
        tickets1.add(crearTicket(20, 20));
        
        ArrayList<Ticket> tickets2 = new ArrayList<>();
        tickets2.add(crearTicket(20, 20));
        tickets2.add(crearTicket(10, 20));
        
        double total1 = gestor.calcularPrecioTotal(tickets1);
        double total2 = gestor.calcularPrecioTotal(tickets2);
        
        assertEquals(total1, total2, 0.001);
        assertEquals(24, total1, 0.001);
    }
}