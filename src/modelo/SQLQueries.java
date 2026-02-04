package modelo;

public class SQLQueries {
	
	  /* ======== CONSTANTES GENERALES ======== */
    public static final String SEPARATOR = "', '";
    public static final String END_BLOCK = "')";

    /* ======== CLIENTE ======== */

 // 1. Login (para Login correcto/incorrecto)
 public static final String SELECT_CLIENTE_LOGIN = 
     "SELECT * FROM Cliente WHERE DNI = ? AND Cliente_Pass_hash = ?";

 // 2. Insertar (para darse de alta)
 public static final String INSERT_CLIENTE = 
     "INSERT INTO Cliente (DNI, Cliente_Nom, Cliente_Apel, Cliente_Correo, Cliente_Pass_hash) " +
     "VALUES (?, ?, ?, ?, ?)";

 /* ======== PELIS ======== */

//1. PARA: "mostrar una relación de películas, comenzando por la más cercana en fecha y hora de emisión"
public static final String SELECT_PELIS_ORDENADAS = 
  "SELECT DISTINCT p.* " +
  "FROM Pelis p " +
  "INNER JOIN Sesion s ON p.Peli_ID = s.Peli_ID " +
  "WHERE s.Sesion_Fech >= NOW() " +
  "ORDER BY ( " +
  "    SELECT MIN(s2.Sesion_Fech) " +
  "    FROM Sesion s2 " +
  "    WHERE s2.Peli_ID = p.Peli_ID " +
  "    AND s2.Sesion_Fech >= NOW() " +
  ") ASC";

//2. PARA: "se mostrarán las fechas en las que se puede ver esa película (las sesiones)"
public static final String SELECT_FECHAS_PELICULA = 
  "SELECT DISTINCT DATE(s.Sesion_Fech) as Fecha " +
  "FROM Sesion s " +
  "WHERE s.Peli_ID = ? " +
  "AND s.Sesion_Fech >= NOW() " +
  "ORDER BY s.Sesion_Fech ASC";

//3. PARA: "se mostrarán sus horarios, la sala y su precio"
public static final String SELECT_SESIONES_POR_FECHA = 
  "SELECT s.Sesion_ID, " +
  "       TIME(s.Sesion_Fech) as Hora_Inicio, " +
  "       ADDTIME(TIME(s.Sesion_Fech), SEC_TO_TIME(s.Peli_Duracion * 60)) as Hora_Fin, " +
  "       s.Sesion_Precio, " +
  "       sa.Sala_Nombre " +
  "FROM Sesion s " +
  "JOIN Pelis p ON s.Peli_ID = p.Peli_ID " +
  "JOIN Sala sa ON s.Sala_ID = sa.Sala_ID " +
  "WHERE s.Peli_ID = ? " +
  "AND DATE(s.Sesion_Fech) = ? " +
  "AND s.Sesion_Fech >= NOW() " +
  "ORDER BY s.Sesion_Fech ASC";

	/* ======== SALAS ======== */
	
	//Obtener todas las salas
	public static final String SELECT_SALAS = "SELECT * FROM Sala";
	
	//Sala por ID
	public static final String SELECT_SALA_ID = "SELECT * FROM Sala WHERE Sala_ID = ?";
	
	
	/* ======== SESIÓN ========= */
	
	
	// FECHAS DISPONIBLES PARA UNA PELÍCULA (solo sesiones futuras)
	public static final String SELECT_FECHAS_POR_PELI = 
	    "SELECT DISTINCT DATE(s.Sesion_Fech) AS Fecha " +
	    "FROM Sesion s " +
	    "WHERE s.Peli_ID = ? " +
	    "AND TIMESTAMP(s.Sesion_Fech, s.Sesion_Hora_Ini) >= NOW() " +
	    "ORDER BY Fecha ASC";
	
	
	// SESIONES DISPONIBLES PARA UNA PELÍCULA EN UNA FECHA ESPECÍFICA
	public static final String SELECT_SESIONES_POR_PELI_FECHA =
		    "SELECT s.Sesion_ID, " +
		    "       s.Sala_ID, " +
		    "       s.Peli_ID, " +
		    "       s.Sesion_Fech, " +
		    "       s.Sesion_Tipo, " +
		    "       s.Sesion_Hora_Ini, " +
		    "       s.Sesion_Hora_Fin, " +
		    "       s.Sesion_Precio, " +
		    "       p.Peli_Titulo, " +
		    "       sa.Sala_Nombre " +
		    "FROM Sesion s " +
		    "JOIN Pelis p ON s.Peli_ID = p.Peli_ID " +
		    "JOIN Sala sa ON s.Sala_ID = sa.Sala_ID " +
		    "WHERE s.Peli_ID = ? " +
		    "AND DATE(s.Sesion_Fech) = ? " +
		    "ORDER BY s.Sesion_Hora_Ini ASC";

	/* ======== COMPRA ========= */
	
	public static final String INSERT_COMPRA = 
		    "INSERT INTO Compra (DNI, Compra_Fech, Compra_Hora, Compra_Descuento) "
		    + "VALUES (?, ?, ?, ?)";
			
	// Obtener la última compra completa
	public static final String SELECT_ULTIMA_COMPRA = 
	    "SELECT *"
	    + "FROM Compra"
	    + "ORDER BY Compra_ID DESC"
	    + "LIMIT 1";

		//Obtener una compra por ID (para el ticket)
		public static final String SELECT_COMPRA_POR_ID = 
		    "SELECT *"
		    + "FROM Compra"
		    + "WHERE Compra_ID = ?";

		//Obtener compras de un cliente
		public static final String SELECT_COMPRAS_CLIENTE = 
		    "SELECT *"
		    + "FROM Compra"
		    + "WHERE DNI = ?"
		    + "ORDER BY Compra_Fech DESC, Compra_Hora DESC";
	
	/* ======== ENTRADA ========= */

		// 1. Insertar una entrada
		public static final String INSERT_ENTRADA = 
		    "INSERT INTO Entrada (Compra_ID, Sesion_ID, Entrada_Personas, Entrada_Precio) " +
		    "VALUES (?, ?, ?, ?)";

		// 2. Obtener todas las entradas de una compra (para resumen/ticket)
		public static final String SELECT_ENTRADAS_POR_COMPRA = 
		    "SELECT * FROM Entrada WHERE Compra_ID = ? ORDER BY Entrada_ID";
	
	
	/* ======== TICKET ========= */

	// CONSULTA COMPLETA PARA TICKET/RESUMEN
		public static final String SELECT_TICKET_COMPLETO =
			    "SELECT " +
			    "  c.Compra_ID, c.Compra_Fech, c.Compra_Hora, c.Compra_Descuento AS descuento_compra, " +
			    "  cl.DNI, cl.Cliente_Nom, cl.Cliente_Apel, cl.Cliente_Correo, " +
			    "  e.Entrada_ID, e.Entrada_Personas, e.Entrada_Precio, " +
			    "  (e.Entrada_Precio * e.Entrada_Personas * (1 - c.Compra_Descuento/100)) AS Entrada_Precio_Final, " +
			    "  p.Peli_Titulo, " +
			    "  s.Sesion_Fech, s.Sesion_Hora_Ini, s.Sesion_Hora_Fin, " +
			    "  sa.Sala_Nombre " +
			    "FROM Compra c " +
			    "JOIN Cliente cl ON c.DNI = cl.DNI " +
			    "JOIN Entrada e ON c.Compra_ID = e.Compra_ID " +
			    "JOIN Sesion s ON e.Sesion_ID = s.Sesion_ID " +
			    "JOIN Sala sa ON s.Sala_ID = sa.Sala_ID " +
			    "JOIN Pelis p ON s.Peli_ID = p.Peli_ID " +
			    "WHERE c.Compra_ID = ? " +
			    "ORDER BY s.Sesion_Fech, s.Sesion_Hora_Ini";



}