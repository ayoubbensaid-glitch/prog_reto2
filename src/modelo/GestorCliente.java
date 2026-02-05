package modelo;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class GestorCliente {

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
	
	public Cliente clienteLogin(String DNI, String Cliente_Pass_hash)
	{
		Cliente cliente = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		boolean conexionRealizada = iniciarConexion();
		if (conexionRealizada)
		{
			try {
				String sql = SQLQueries.SELECT_CLIENTE_LOGIN;
				sentencia = conexion.prepareStatement(sql);
				sentencia.setString(1, DNI);
				sentencia.setString(2, Cliente_Pass_hash);
				resultSet = sentencia.executeQuery();
				if(resultSet.next())
				{
					cliente = new Cliente();
					cliente.setDNI(resultSet.getString("DNI"));
					cliente.setCliente_Nom(resultSet.getString("Cliente_Nom"));
					cliente.setCliente_Apel(resultSet.getString("Cliente_Apel"));
					cliente.setCliente_Correo(resultSet.getString("Cliente_Correo"));
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
		return cliente;
	}
	
	public boolean insertarCliente(Cliente cliente) {

	    if (!validarEmailRegex(cliente.getCliente_Correo())) {
	        System.out.println("❌ Error: Email inválido. Debe contener @ y .com");
	        return false;
	    }

	    PreparedStatement sentencia = null;
	    if (iniciarConexion()) {
	        try {
	            String sql = SQLQueries.INSERT_CLIENTE;
	            sentencia = conexion.prepareStatement(sql);
	            sentencia.setString(1, cliente.getDNI());
	            sentencia.setString(2, cliente.getCliente_Nom());
	            sentencia.setString(3, cliente.getCliente_Apel());
	            sentencia.setString(4, cliente.getCliente_Correo());
	            sentencia.setString(5, cliente.getCliente_Pass_hash());

	            sentencia.executeUpdate();
	            return true;

	        } catch (SQLException e) {
	            if (e.getMessage().contains("Duplicate entry")) {
	                System.out.println("⚠ El cliente ya se encuentra registrado");
	            } else {
	                System.out.println("⚠ Error con la base de datos: " + e.getMessage());
	            }
	            return false;
	        } finally {
	            try {
	                if (sentencia != null) sentencia.close();
	            } catch (SQLException e) {
	                System.out.println("⚠ Error al cerrar la sentencia");
	            }
	            finalizarConexion();
	        }
	    }
	    return false;
	}



	 public static String sha256(String Cliente_Pass_hash) {
	        try {
	            MessageDigest mensaje = MessageDigest.getInstance("SHA-256");
	            byte[] hashBytes = mensaje.digest(Cliente_Pass_hash.getBytes());
	            StringBuilder builder = new StringBuilder();
	            for (byte b : hashBytes) {
	            	builder.append(String.format("%02x", b));
	            }
	            return builder.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("Error al hashear la contraseña", e);
	        }
	    }
	
	 private boolean validarEmailRegex(String email) {
		    if (email == null || email.trim().isEmpty()) {
		        return false;
		    }
		    
		    String regex = "^[A-Za-z0-9+_.-]+@(.+)\\.com$";
		    return Pattern.matches(regex, email);
		}

}