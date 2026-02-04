package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorPelis {
	
	
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
	
	public ArrayList<Pelis> seleccionarPelisOrdenadas()
	{
		ArrayList<Pelis> lista = new ArrayList<Pelis>();
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		boolean conexionRealizada = iniciarConexion();
		
		if (conexionRealizada)
		{
			try {
				String sql = SQLQueries.SELECT_PELIS_ORDENADAS;
				sentencia = conexion.prepareStatement(sql);
				resultSet = sentencia.executeQuery();
				while (resultSet.next())
				{
					Pelis peli = new Pelis();
					peli.setPeli_ID(resultSet.getString("Peli_ID"));
					peli.setPeli_Titulo(resultSet.getString("Peli_Titulo"));
					peli.setPeli_Duracion(resultSet.getInt("Peli_Duracion"));
					peli.setPeli_Genero(resultSet.getString("Peli_Genero"));
					peli.setPeli_Precio(resultSet.getDouble("Peli_Precio"));
					lista.add(peli);
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
		return lista;
	}
	
	public ArrayList<String> seleccionarFechasPelicula(String Peli_ID) {
        ArrayList<String> fechas = new ArrayList<>();
        PreparedStatement sentencia = null;
        ResultSet resultSet = null;
        
        if (iniciarConexion()) {
            try {
                String sql = SQLQueries.SELECT_FECHAS_PELICULA;
                sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, Peli_ID);
                resultSet = sentencia.executeQuery();
                
                while (resultSet.next()) {
                    fechas.add(resultSet.getString("Fecha"));
                }
            } catch (Exception e) {
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
        return fechas;
    }
    
	
	 public ArrayList<Sesion> seleccionarSesionesPorFecha(String peliId, String fecha) {
	        ArrayList<Sesion> sesiones = new ArrayList<>();
	        PreparedStatement sentencia = null;
	        ResultSet resultSet = null;
	        
	        if (iniciarConexion()) {
	            try {
	                String sql = SQLQueries.SELECT_SESIONES_POR_FECHA;
	                sentencia = conexion.prepareStatement(sql);
	                sentencia.setString(1, peliId);
	                sentencia.setString(2, fecha);
	                resultSet = sentencia.executeQuery();
	                
	                while (resultSet.next()) {
	                    Sesion sesion = new Sesion();
	                    sesion.setSesion_ID(resultSet.getString("Sesion_ID"));
	                    sesion.setSesion_Hora_Ini(resultSet.getTime("Sesion_Hora_Ini"));
	                    sesion.setSesion_Hora_Fin(resultSet.getTime("Hora_Fin"));
	                    sesion.setSesion_Precio(resultSet.getDouble("Sesion_Precio"));
	                    Sala sala = new Sala();
	                    sala.setSala_Nombre(resultSet.getString("Sala_Nombre"));
	                    sesiones.add(sesion);
	                }
	            } catch (Exception e) {
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
	        return sesiones;
	    }
	
}