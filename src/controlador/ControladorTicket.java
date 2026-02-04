package controlador;

import java.util.ArrayList;

import modelo.GestorTicket;
import modelo.Ticket;

public class ControladorTicket {
	
	
  public void guardarTicket(String Compra_ID) {
			
			 GestorTicket gestorTicket = new GestorTicket();
			    ArrayList<Ticket> tickets = gestorTicket.obtenerTicketsPorCompra(Compra_ID);

			    if (tickets != null && !tickets.isEmpty()) {
			        String carpetaDestino = "tickets";
			        gestorTicket.generarFactura(tickets, carpetaDestino);
			    }
	  }
	  
	  
	  public double obtenerPrecioTotal(ArrayList<Ticket> tickets)
	    {
	    	 GestorTicket gestorTicket = new GestorTicket();
	    	 return gestorTicket.calcularPrecioTotal(tickets);
	    }
	  
	  public void generarTicket(ArrayList<Ticket> tickets, String carpetaDestino)
	  {
	    	 GestorTicket gestorTicket = new GestorTicket();
	    	 gestorTicket.generarFactura(tickets, carpetaDestino);


	  }
}
