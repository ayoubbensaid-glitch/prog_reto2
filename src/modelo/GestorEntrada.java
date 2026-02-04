package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorEntrada {

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
	
	
	public void insertarEntrada(Entrada entrada) {
	    PreparedStatement ps = null;
	    boolean conexionRealizada = iniciarConexion();
	    
	    if (conexionRealizada) {
	        try {
	            String sql = SQLQueries.INSERT_ENTRADA;
	            ps = conexion.prepareStatement(sql);
	            
	            ps.setString(1, entrada.getCompra().getCompra_ID());
	            ps.setString(2, entrada.getSesion().getSesion_ID());
	            ps.setInt(3, entrada.getEntrada_Personas());
	            ps.setDouble(4, entrada.getEntrada_Precio());
	            
	            ps.executeUpdate();
	            
	            System.out.println("✅ Entrada insertada correctamente.");
	            
	        } catch (SQLException sqle) {
	            System.out.println("Error con la base de datos: " + sqle.getMessage());
	        } finally {
	            try { if(ps != null) ps.close(); } catch (Exception e) {}
	            finalizarConexion();
	        }
	    }
	}


	
	public ArrayList<Entrada> buscarEntradasPorCompra(String Compra_ID)
	{
		
		ArrayList<Entrada> entradas = new ArrayList<Entrada>();
		Statement sentencia = null;
		ResultSet resultSet = null;
		boolean conexionRealizada = iniciarConexion();
		if(conexionRealizada)
		{
			try {
	            sentencia = conexion.createStatement();
				String sql = SQLQueries.SELECT_ENTRADAS_POR_COMPRA;
				resultSet = sentencia.executeQuery(sql);
				while(resultSet.next())
				{
					Entrada entrada = new Entrada();
					entrada.setEntrada_ID(resultSet.getString("Entrada_ID"));
					
					Compra compra = new Compra();
					compra.setCompra_ID(resultSet.getString("Compra_ID"));
					entrada.setCompra(compra);
					
					Sesion sesion = new Sesion();
					sesion.setSesion_ID(resultSet.getString("Sesion_ID"));
					entrada.setSesion(sesion);
					
					entrada.setEntrada_Personas(resultSet.getInt("Entrada_Personas"));
					entrada.setEntrada_Precio(resultSet.getDouble("Entrada_Precio"));					
					entradas.add(entrada);
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
		return entradas;
	}
}
