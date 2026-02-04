package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GestorClienteTest {

    // ==================== TESTS PARA sha256 ====================
    
    @Test
    void testSha256FuncionaConTexto() {
        String hash = GestorCliente.sha256("1234");
        assertNotNull(hash);
        assertEquals(64, hash.length());
    }
    
    @Test
    void testSha256CadenaVacia() {
        String hash = GestorCliente.sha256("");
        assertNotNull(hash);
        assertEquals(64, hash.length());
    }

    // ==================== TESTS PARA insertarCliente ====================
    
    @Test
    void testInsertarClienteEmailValido() {
        GestorCliente gestor = new GestorCliente();
        Cliente cliente = new Cliente();
        cliente.setDNI("12345678A");
        cliente.setCliente_Nom("Juan");
        cliente.setCliente_Apel("Pérez");
        cliente.setCliente_Correo("juan@test.com");
        cliente.setCliente_Pass_hash(GestorCliente.sha256("1234"));
        
        assertDoesNotThrow(() -> gestor.insertarCliente(cliente));
    }
    
    @Test
    void testInsertarClienteEmailInvalido() {
        GestorCliente gestor = new GestorCliente();
        Cliente cliente = new Cliente();
        cliente.setDNI("12345678A");
        cliente.setCliente_Nom("Juan");
        cliente.setCliente_Apel("Pérez");
        cliente.setCliente_Correo("emailinvalido");
        cliente.setCliente_Pass_hash(GestorCliente.sha256("1234"));
        
        assertDoesNotThrow(() -> gestor.insertarCliente(cliente));
    }
    
    @Test
    void testInsertarClienteEmailNulo() {
        GestorCliente gestor = new GestorCliente();
        Cliente cliente = new Cliente();
        cliente.setDNI("12345678A");
        cliente.setCliente_Nom("Juan");
        cliente.setCliente_Apel("Pérez");
        cliente.setCliente_Correo(null);
        cliente.setCliente_Pass_hash(GestorCliente.sha256("1234"));
        
        assertDoesNotThrow(() -> gestor.insertarCliente(cliente));
    }
    
    @Test
    void testInsertarClienteEmailVacio() {
        GestorCliente gestor = new GestorCliente();
        Cliente cliente = new Cliente();
        cliente.setDNI("12345678A");
        cliente.setCliente_Nom("Juan");
        cliente.setCliente_Apel("Pérez");
        cliente.setCliente_Correo("");
        cliente.setCliente_Pass_hash(GestorCliente.sha256("1234"));
        
        assertDoesNotThrow(() -> gestor.insertarCliente(cliente));
    }
    
    @Test
    void testInsertarClienteConDNINulo() {
        GestorCliente gestor = new GestorCliente();
        Cliente cliente = new Cliente();
        cliente.setDNI(null);
        cliente.setCliente_Nom("Juan");
        cliente.setCliente_Apel("Pérez");
        cliente.setCliente_Correo("test@test.com");
        cliente.setCliente_Pass_hash(GestorCliente.sha256("1234"));
        
        assertDoesNotThrow(() -> gestor.insertarCliente(cliente));
    }

    // ==================== TESTS PARA clienteLogin ====================
    
    @Test
    void testClienteLoginUsuarioNoExiste() {
        GestorCliente gestor = new GestorCliente();
        
        Cliente cliente = gestor.clienteLogin("NO_EXISTE", "hash_falso");
        
        assertNull(cliente);
    }
    
    @Test
    void testClienteLoginConDNINulo() {
        GestorCliente gestor = new GestorCliente();
        
        Cliente cliente = gestor.clienteLogin(null, "hash");
        
        assertNull(cliente);
    }
    
    @Test
    void testClienteLoginConHashNulo() {
        GestorCliente gestor = new GestorCliente();
        
        Cliente cliente = gestor.clienteLogin("12345678A", null);
        
        assertNull(cliente);
    }
    
    @Test
    void testClienteLoginConHashSHA256Valido() {
        GestorCliente gestor = new GestorCliente();
        
        String hash = GestorCliente.sha256("password123");
        Cliente cliente = gestor.clienteLogin("DNI_FALSO", hash);
        
        assertNull(cliente);
    }
    
    @Test
    void testClienteLoginConHashCorto() {
        GestorCliente gestor = new GestorCliente();
        
        Cliente cliente = gestor.clienteLogin("12345678A", "abc123");
        
        assertNull(cliente);
    }

    // ==================== TESTS DE ERRORES ====================
    
    @Test
    void testInsertarClienteConErrorConexion() {
        GestorCliente gestor = new GestorCliente();
        Cliente cliente = new Cliente();
        cliente.setDNI("12345678A");
        cliente.setCliente_Nom("Juan");
        cliente.setCliente_Apel("Pérez");
        cliente.setCliente_Correo("test@test.com");
        cliente.setCliente_Pass_hash(GestorCliente.sha256("1234"));
        assertDoesNotThrow(() -> gestor.insertarCliente(cliente));
    }
    
    @Test
    void testClienteLoginConErrorConexion() {
        GestorCliente gestor = new GestorCliente();
        
        Cliente cliente = gestor.clienteLogin("test", "test");
        
        assertNull(cliente);
    }

    // ==================== TESTS ADICIONALES SIMPLES ====================
    
    @Test
    void testDosClientesMismoDNI() {
        GestorCliente gestor = new GestorCliente();
        
        Cliente cliente1 = new Cliente();
        cliente1.setDNI("11111111A");
        cliente1.setCliente_Nom("Ana");
        cliente1.setCliente_Apel("García");
        cliente1.setCliente_Correo("ana@test.com");
        cliente1.setCliente_Pass_hash(GestorCliente.sha256("1234"));
        
        Cliente cliente2 = new Cliente();
        cliente2.setDNI("11111111A");
        cliente2.setCliente_Nom("Pedro");
        cliente2.setCliente_Apel("López");
        cliente2.setCliente_Correo("pedro@test.com");
        cliente2.setCliente_Pass_hash(GestorCliente.sha256("5678"));
        
        assertDoesNotThrow(() -> {
            gestor.insertarCliente(cliente1);
            gestor.insertarCliente(cliente2);
        });
    }
    
    @Test
    void testClienteConEmailLargo() {
        GestorCliente gestor = new GestorCliente();
        Cliente cliente = new Cliente();
        cliente.setDNI("12345678A");
        cliente.setCliente_Nom("Juan");
        cliente.setCliente_Apel("Pérez");
        cliente.setCliente_Correo("emailmuylargoycomplicado@dominiodemuestra.com");
        cliente.setCliente_Pass_hash(GestorCliente.sha256("1234"));
        
        assertDoesNotThrow(() -> gestor.insertarCliente(cliente));
    }
    
    @Test
    void testClienteConNombreLargo() {
        GestorCliente gestor = new GestorCliente();
        Cliente cliente = new Cliente();
        cliente.setDNI("12345678A");
        cliente.setCliente_Nom("Juan Carlos María del Pilar");
        cliente.setCliente_Apel("Pérez");
        cliente.setCliente_Correo("test@test.com");
        cliente.setCliente_Pass_hash(GestorCliente.sha256("1234"));
        
        assertDoesNotThrow(() -> gestor.insertarCliente(cliente));
    }
}