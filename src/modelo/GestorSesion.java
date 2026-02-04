package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorSesion {
	
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
	
	public ArrayList<Sesion> buscarFechasSesionPorPeli(String Peli_ID)
	{
		ArrayList<Sesion> sesiones = new ArrayList<Sesion>();
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		boolean conexionRealizada = iniciarConexion();
		
		if (conexionRealizada)
		{
			try {
				String sql = SQLQueries.SELECT_FECHAS_POR_PELI;
				sentencia = conexion.prepareStatement(sql);
				sentencia.setString(1, Peli_ID);
				resultSet = sentencia.executeQuery();
				while (resultSet.next())
				{
					Sesion sesion = new Sesion();
					sesion.setSesion_Fech(resultSet.getDate("Fecha"));
					sesiones.add(sesion);
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
		return sesiones;
	}
	
	public ArrayList<Sesion> buscarSesionPorFechaEspecifica(String Peli_ID, Date Sesion_Fech)
	{
		ArrayList<Sesion> sesion = new ArrayList<Sesion>();
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		boolean conexionRealizada = iniciarConexion();
		
		if (conexionRealizada)
		{
			try {
				String sql = SQLQueries.SELECT_SESIONES_POR_PELI_FECHA;
				sentencia = conexion.prepareStatement(sql);
				sentencia.setString(1, Peli_ID);
				sentencia.setDate(2, Sesion_Fech);
				resultSet = sentencia.executeQuery();
				while(resultSet.next())
				{
					Sesion sesiones = new Sesion();
					sesiones.setSesion_ID(resultSet.getString("Sesion_ID"));
					
					Sala sala = new Sala();
					sala.setSala_ID(resultSet.getString("Sala_ID"));
                    sala.setSala_Nombre(resultSet.getString("Sala_Nombre"));
                    sesiones.setSala(sala);
					
					Pelis peli = new Pelis();
					 peli.setPeli_ID(resultSet.getString("Peli_ID"));
	                 peli.setPeli_Titulo(resultSet.getString("Peli_Titulo"));
	                 sesiones.setPeli(peli);
					
					sesiones.setSesion_Hora_Ini(resultSet.getTime("Sesion_Hora_Ini"));
					sesiones.setSesion_Hora_Fin(resultSet.getTime("Sesion_Hora_Fin"));
					sesiones.setSesion_Fech(resultSet.getDate("Sesion_Fech"));
					sesiones.setSesion_Precio(resultSet.getDouble("Sesion_Precio"));
					sesiones.setSesion_Tipo(resultSet.getString("Sesion_Tipo"));
					sesion.add(sesiones);
					
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
		return sesion;
	}
}