package modelo;

import java.sql.Date;
import java.sql.Time;

public class Ticket {
	   private String Compra_ID;
	    private Date Compra_Fech;
	    private Time Compra_Hora;
	    private double Compra_Descuento;
	    private String Entrada_ID;
	    private int Entrada_Personas;
	    private double Entrada_Precio;
	    private double Entrada_Precio_Final;
	    private String Peli_Titulo;
	    private Date Sesion_Fech;
	    private Time Sesion_Hora_Ini;
	    private Time Sesion_Hora_Fin;	    
	    private String Sala_Nombre;	    
	    private String DNI;
	    private String Cliente_Nom;
	    private String Cliente_Apel;
	    private String Cliente_Correo;
	    
	    public Ticket(String Compra_ID, Date Compra_Fech, Time Compra_Hora, double Compra_Descuento,
	                  String Entrada_ID, int Entrada_Personas, double Entrada_Precio,
	                  double Entrada_Precio_Final, String Peli_Titulo, Date Sesion_Fech, Time Sesion_Hora_Ini,
	                  Time Sesion_Hora_Fin, String Sala_Nombre, String DNI, String Cliente_Nom, String Cliente_Apel,
	                  String Cliente_Correo) {
	        this.Compra_ID = Compra_ID;
	        this.Compra_Fech = Compra_Fech;
	        this.Compra_Hora = Compra_Hora;
	        this.Compra_Descuento = Compra_Descuento;
	        this.Entrada_ID = Entrada_ID;
	        this.Entrada_Personas = Entrada_Personas;
	        this.Entrada_Precio = Entrada_Precio;
	        this.Entrada_Precio_Final = Entrada_Precio_Final;
	        this.Peli_Titulo = Peli_Titulo;
	        this.Sesion_Fech = Sesion_Fech;
	        this.Sesion_Hora_Ini = Sesion_Hora_Ini;
	        this.Sesion_Hora_Fin = Sesion_Hora_Fin;
	        this.Sala_Nombre = Sala_Nombre;
	        this.DNI = DNI;
	        this.Cliente_Nom = Cliente_Nom;
	        this.Cliente_Apel = Cliente_Apel;
	        this.Cliente_Correo = Cliente_Correo;
	    }

	    public Ticket() {
	        Compra_ID = "";
	        Compra_Fech = null;
	        Compra_Hora = null;
	        Compra_Descuento = 0;
	        Entrada_ID = "";
	        Entrada_Personas = 0;
	        Entrada_Precio = 0;
	        Entrada_Precio_Final = 0;
	        Peli_Titulo = "";
	        Sesion_Fech = null;
	        Sesion_Hora_Ini = null;
	        Sesion_Hora_Fin = null;
	        Sala_Nombre = "";
	        DNI = "";
	        Cliente_Nom = "";
	        Cliente_Apel = "";
	        Cliente_Correo = "";
	    }

		public String getCompra_ID() {
			return Compra_ID;
		}

		public void setCompra_ID(String compra_ID) {
			Compra_ID = compra_ID;
		}

		public Date getCompra_Fech() {
			return Compra_Fech;
		}

		public void setCompra_Fech(Date compra_Fech) {
			Compra_Fech = compra_Fech;
		}

		public Time getCompra_Hora() {
			return Compra_Hora;
		}

		public void setCompra_Hora(Time compra_Hora) {
			Compra_Hora = compra_Hora;
		}

		public double getCompra_Descuento() {
			return Compra_Descuento;
		}

		public void setCompra_Descuento(double compra_Descuento) {
			Compra_Descuento = compra_Descuento;
		}

		public String getEntrada_ID() {
			return Entrada_ID;
		}

		public void setEntrada_ID(String entrada_ID) {
			Entrada_ID = entrada_ID;
		}

		public int getEntrada_Personas() {
			return Entrada_Personas;
		}

		public void setEntrada_Personas(int entrada_Personas) {
			Entrada_Personas = entrada_Personas;
		}

		public double getEntrada_Precio() {
			return Entrada_Precio;
		}

		public void setEntrada_Precio(double entrada_Precio) {
			Entrada_Precio = entrada_Precio;
		}

		public double getEntrada_Precio_Final() {
			return Entrada_Precio_Final;
		}

		public void setEntrada_Precio_Final(double entrada_Precio_Final) {
			Entrada_Precio_Final = entrada_Precio_Final;
		}

		public String getPeli_Titulo() {
			return Peli_Titulo;
		}

		public void setPeli_Titulo(String peli_Titulo) {
			Peli_Titulo = peli_Titulo;
		}

		public Date getSesion_Fech() {
			return Sesion_Fech;
		}

		public void setSesion_Fech(Date sesion_Fech) {
			Sesion_Fech = sesion_Fech;
		}

		public Time getSesion_Hora_Ini() {
			return Sesion_Hora_Ini;
		}

		public void setSesion_Hora_Ini(Time sesion_Hora_Ini) {
			Sesion_Hora_Ini = sesion_Hora_Ini;
		}

		public Time getSesion_Hora_Fin() {
			return Sesion_Hora_Fin;
		}

		public void setSesion_Hora_Fin(Time sesion_Hora_Fin) {
			Sesion_Hora_Fin = sesion_Hora_Fin;
		}

		public String getSala_Nombre() {
			return Sala_Nombre;
		}

		public void setSala_Nombre(String sala_Nombre) {
			Sala_Nombre = sala_Nombre;
		}

		public String getDNI() {
			return DNI;
		}

		public void setDNI(String dNI) {
			DNI = dNI;
		}

		public String getCliente_Nom() {
			return Cliente_Nom;
		}

		public void setCliente_Nom(String cliente_Nom) {
			Cliente_Nom = cliente_Nom;
		}

		public String getCliente_Apel() {
			return Cliente_Apel;
		}

		public void setCliente_Apel(String cliente_Apel) {
			Cliente_Apel = cliente_Apel;
		}

		public String getClienteCompleto()
		{
		    return Cliente_Nom + " " + Cliente_Apel;
		}
		public void setClienteCompleto(String cliente_nom, String cliente_apel)
		{
			Cliente_Nom = cliente_nom;
			Cliente_Apel = cliente_apel;
		}
		public String getCliente_Correo() {
			return Cliente_Correo;
		}

		public void setCliente_Correo(String cliente_correo) {
			Cliente_Correo = cliente_correo;
		}
	    
		 @Override
		    public String toString() {
		        return "========== TICKET ==========\n" +
		               "Compra ID: " + Compra_ID + "\n" +
		               "Fecha/Hora compra: " + Compra_Fech + " " + Compra_Hora + "\n" +
		               "Cliente: " + getClienteCompleto() + " (DNI: " + DNI + ", Correo: " + Cliente_Correo + ")\n" +
		               "Película: " + Peli_Titulo + "\n" +
		               "Sala: " + Sala_Nombre + "\n" +
		               "Sesión: " + Sesion_Fech + " " + Sesion_Hora_Ini + " - " + Sesion_Hora_Fin + "\n" +
		               "Personas: " + Entrada_Personas + "\n" +
		               "Precio unitario: " + Entrada_Precio + " €\n" +
		               "Precio final entrada: " + Entrada_Precio_Final + " €\n" +
		               "Descuento compra: " + Compra_Descuento + "%\n" +
		               "=============================\n";
		    }

}