package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class GestorCompra {

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
	
	
	public void insertarCompra(Compra compra) {
	    PreparedStatement sentencia = null;
	    boolean conexionRealizada = iniciarConexion();
	    
	    if (conexionRealizada) {
	        try {
	            String sql = SQLQueries.INSERT_COMPRA;
	            sentencia = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);	            
	            sentencia.setString(1, compra.getCliente().getDNI());
	            sentencia.setDate(2, compra.getCompra_Fech());
	            sentencia.setTime(3, compra.getCompra_Hora());
	            sentencia.setDouble(4, compra.getCompra_Descuento());
	            
	            sentencia.executeUpdate();
	            
	            ResultSet resultSet = sentencia.getGeneratedKeys();
	            if (resultSet.next()) {
	                compra.setCompra_ID(String.valueOf(resultSet.getString(1)));
	            }
	            resultSet.close();
	            
	            System.out.println("✅ Compra insertada correctamente con ID: " + compra.getCompra_ID());
	            
	        } catch (SQLException sqle) {
	            System.out.println("Error con la base de datos: " + sqle.getMessage());
	        }
	        try { 
	        	sentencia.close(); 
	        	}
	        catch (Exception e) {
	        	System.out.println ("Error al cerrar la sentencia");
	        	}
	        finalizarConexion();
	        }
	    }


	public Compra buscarUltimaCompra()
	{
	    Compra compra = null;
	    PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		boolean conexionRealizada = iniciarConexion();
		if (conexionRealizada)
		{
			try {
				String sql = SQLQueries.SELECT_ULTIMA_COMPRA;
				sentencia = conexion.prepareStatement(sql);
				resultSet = sentencia.executeQuery();	
				
				if (resultSet.next()) {
		            compra = new Compra();
		            compra.setCompra_ID(resultSet.getString("Compra_ID"));
		            compra.setCompra_Fech(resultSet.getDate("Compra_Fech"));
		            compra.setCompra_Hora(resultSet.getTime("Compra_Hora"));
		            compra.setCompra_Descuento(resultSet.getDouble("Compra_Descuento"));
		            
		            
		            Cliente cliente = new Cliente();
		            cliente.setDNI(resultSet.getString("Cliente_DNI"));
		            compra.setCliente(cliente);
		        }
				
			}catch (SQLException sqle) {
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
		return compra;
	}

	public Compra buscarCompraPorID(String Compra_ID) {
       Compra compra = null;
       PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		boolean conexionRealizada = iniciarConexion();
		if (conexionRealizada) {
			try {
				String sql = SQLQueries.SELECT_COMPRA_POR_ID;
				sentencia = conexion.prepareStatement(sql);
				sentencia.setString(1, Compra_ID);
				resultSet = sentencia.executeQuery();	
				
				if(resultSet.next()) {
					  compra = new Compra();
	                    compra.setCompra_ID(resultSet.getString("Compra_ID"));
	                    compra.setCompra_Fech(resultSet.getDate("Compra_Fech"));
	                    compra.setCompra_Hora(resultSet.getTime("Compra_Hora"));
	                    compra.setCompra_Descuento(resultSet.getDouble("Compra_Descuento"));

	                    Cliente cliente = new Cliente();
	                    cliente.setDNI(resultSet.getString("DNI"));
	                    compra.setCliente(cliente);
				}
			}catch (SQLException sqle) {
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
		return compra;
    }

	public ArrayList<Compra> buscarComprasCliente(String DNI)
	{
	    ArrayList<Compra> compras = new ArrayList<>();
	       PreparedStatement sentencia = null;
	       ResultSet resultSet = null;
			boolean conexionRealizada = iniciarConexion();
			if (conexionRealizada)
			{
				try {
					String sql = SQLQueries.SELECT_COMPRAS_CLIENTE;
					sentencia = conexion.prepareStatement(sql);
					sentencia.setString(1, DNI);
					resultSet = sentencia.executeQuery();	
					
					while(resultSet.next())
					{
		                Compra compra = new Compra();
		                compra.setCompra_ID(resultSet.getString("Compra_ID"));
		                compra.setCompra_Fech(resultSet.getDate("Compra_Fech"));
		                compra.setCompra_Hora(resultSet.getTime("Compra_Hora"));
		                compra.setCompra_Descuento(resultSet.getDouble("Compra_Descuento"));

		                Cliente cliente = new Cliente();
		                cliente.setDNI(resultSet.getString("DNI"));
		                compra.setCliente(cliente);

		                compras.add(compra);
					}
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
				return compras;
	}
}
