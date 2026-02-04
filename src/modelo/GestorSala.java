package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorSala {
	
private Connection conexion;
	
	//La inicializacion de la conexion de nuestrab db
	private boolean iniciarConexion () {
		boolean conexionRealizada = false;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			conexionRealizada = true;
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println ("No se ha encontrado la clase correspondiente: " + cnfe.getMessage());
		}
		catch (SQLException sqle){
			System.out.println ("Error al establecer la conexión: " + sqle.getMessage());
		}
		return conexionRealizada;
	}
	
	
	//Finalizar o cerrar la conexion de db
	private void finalizarConexion() {
		try {
			conexion.close();
		}
		catch(Exception e) {
			System.out.println ("Error al cerrar la conexion");
		}
	}
	
	//Funcion util para la busqueda de Las salas por el identificador (Sala_ID)
	public Sala buscarSalaPorID(String Sala_ID)
	{
		Sala sala = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		boolean conexionRealizada = iniciarConexion();
		if (conexionRealizada)
		{
			try {
				String sql = SQLQueries.SELECT_SALA_ID;
				sentencia = conexion.prepareStatement(sql);
				sentencia.setString(1, Sala_ID);
				resultSet = sentencia.executeQuery();
				while (resultSet.next())
				{
					sala= new Sala();
					sala.setSala_ID(resultSet.getString("Sala_ID"));
					sala.setSala_Nombre(resultSet.getString("Sala_Nombre"));
					
				}
			}
			catch (SQLException sqle) {
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
		return sala;
			
	}
	
	//Funcion usada para selecionar todas las salas con toda la informacion
	public ArrayList<Sala> buscarSalas()
	{
		ArrayList<Sala> salas = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		boolean conexionRealizada = iniciarConexion();
		
		if (conexionRealizada)
		{
			try {
				String sql = SQLQueries.SELECT_SALAS;
				sentencia = conexion.prepareStatement(sql);
				resultSet = sentencia.executeQuery();
				salas = new ArrayList<Sala>();
				while(resultSet.next())
				{
					Sala sala = new Sala();
					sala.setSala_ID(resultSet.getString("Sala_ID"));
					sala.setSala_Nombre(resultSet.getString("Sala_Nombre"));
					salas.add(sala);
				}
				
			} 
			catch (SQLException sqle) {
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
		return salas;
			
	}
}