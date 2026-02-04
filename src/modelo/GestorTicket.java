package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorTicket {
	
private Connection conexion;
	
	private boolean iniciarConexion()
	{
		boolean conexionRealizada = false;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			conexionRealizada = true;
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println ("No se ha encontrado la clase: " + cnfe.getMessage());
		}
		catch (SQLException sqle){
			System.out.println ("Error al establecer la conexión: " + sqle.getMessage());
		}
		return conexionRealizada;
	}
	
	private void finalizarConexion()
	{
		try {
			conexion.close();
		}
		catch(Exception e) {
			System.out.println ("Error al cerrar la conexion");
		}
	}
	
	public ArrayList<Ticket> obtenerTicketsPorCompra(String Compra_ID) {
	    ArrayList<Ticket> tickets = new ArrayList<>();

	    PreparedStatement sentencia = null;
	    ResultSet resultSet = null;
	    boolean conexionRealizada = iniciarConexion();
	    if (conexionRealizada) {
	        try {
	            String sql = SQLQueries.SELECT_TICKET_COMPLETO;
	            sentencia = conexion.prepareStatement(sql);
	            sentencia.setString(1, Compra_ID);
	            resultSet = sentencia.executeQuery();

	            while(resultSet.next()) {
	                Ticket ticket = new Ticket();
	                ticket.setCompra_ID(resultSet.getString("Compra_ID"));
	                ticket.setCompra_Fech(resultSet.getDate("Compra_Fech"));
	                ticket.setCompra_Hora(resultSet.getTime("Compra_Hora"));
	                ticket.setCompra_Descuento(resultSet.getDouble("descuento_compra"));
	                ticket.setEntrada_ID(resultSet.getString("Entrada_ID"));
	                ticket.setEntrada_Personas(resultSet.getInt("Entrada_Personas"));
	                ticket.setEntrada_Precio(resultSet.getDouble("Entrada_Precio"));
	                ticket.setEntrada_Precio_Final(resultSet.getDouble("Entrada_Precio_Final"));
	                ticket.setPeli_Titulo(resultSet.getString("Peli_Titulo"));
	                ticket.setSesion_Fech(resultSet.getDate("Sesion_Fech"));
	                ticket.setSesion_Hora_Ini(resultSet.getTime("Sesion_Hora_Ini"));
	                ticket.setSesion_Hora_Fin(resultSet.getTime("Sesion_Hora_Fin"));
	                ticket.setSala_Nombre(resultSet.getString("Sala_Nombre"));
	                ticket.setDNI(resultSet.getString("DNI"));
	                ticket.setCliente_Nom(resultSet.getString("Cliente_Nom"));
	                ticket.setCliente_Apel(resultSet.getString("Cliente_Apel"));
	                ticket.setCliente_Correo(resultSet.getString("Cliente_Correo"));
	                tickets.add(ticket);
	            }

	        } catch (SQLException sqle) {
				System.out.println ("Error con la base de datos: " + sqle.getMessage());
			}
			catch (Exception e) {
				System.out.println ("Error genérico: " + e.getMessage());
			}
			try {
				resultSet.close();
			}
			catch(Exception e) {
				System.out.println ("Error al cerrar el resultSet");
			}
			try {
				sentencia.close();
			}
			catch(Exception e) {
					System.out.println ("Error al cerrar la sentencia");
			}
			finalizarConexion();
		}
	    return tickets;
	}

	
	
	public double calcularPrecioTotal(ArrayList<Ticket> tickets) {
	    if (tickets == null || tickets.isEmpty()) {
	        return 0;
	    }
	    
	    double total = 0;
	    double descuentoCompra = tickets.get(0).getCompra_Descuento();
	    
	    if (descuentoCompra < 0) descuentoCompra = 0;
	    if (descuentoCompra > 100) descuentoCompra = 100;
	    
	    for (Ticket t : tickets) {
	        double precio = t.getEntrada_Precio_Final();
	        if (precio < 0) precio = 0;
	        total += precio;
	    }
	    
	    total = total * (1 - descuentoCompra / 100);
	    return total;
	}
	
	public void generarFactura(ArrayList<Ticket> tickets, String carpetaDestino) {
	    if (tickets == null || tickets.isEmpty())
	    	{
	    		return;
	    	};

	    File carpeta = new File(carpetaDestino);
	    if (!carpeta.exists()) {
	        boolean creada = carpeta.mkdirs();
	        if (creada) {
	            System.out.println("Carpeta creada: " + carpetaDestino);
	        } else {
	            System.out.println("No se pudo crear la carpeta: " + carpetaDestino);
	        }
	    }

	    String archivoTicket = carpetaDestino + File.separator + "ticket_compra_" 
	                          + tickets.get(0).getCompra_ID() + ".txt";

	    try (FileWriter writer = new FileWriter(archivoTicket)) {
	        for (Ticket t : tickets) {
	            writer.write(t.toString());
	            writer.write("\n");
	        }

	        double total = calcularPrecioTotal(tickets);
	        writer.write("Precio total de la compra: " + total + " €\n");
	        writer.write("====================================\n");

	        writer.flush();
	        System.out.println("Factura guardada correctamente en: " + archivoTicket);

	    } catch (IOException e) {
	        System.out.println("Error al generar la factura: " + e.getMessage());
	    }
	}
}
