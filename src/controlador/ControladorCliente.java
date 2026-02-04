package controlador;


import modelo.Cliente;
import modelo.GestorCliente;

public class ControladorCliente {
	
	public void insertarCliente(Cliente cliente)
	{
		GestorCliente gestorCliente = new GestorCliente();
		gestorCliente.insertarCliente(cliente);
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
