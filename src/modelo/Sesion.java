package modelo;

import java.sql.Date;
import java.sql.Time;
public class Sesion {
	
	private String Sesion_ID;
	private Sala sala;
	private Pelis peli;
	private Time Sesion_Hora_Ini;
	private Time Sesion_Hora_Fin;
	private Date Sesion_Fech;
	private double Sesion_Precio;
	private String Sesion_Tipo;
	
	public Sesion( String Sesion_ID, Sala sala, Pelis peli, Time Sesion_Hora_Ini, Time Sesion_Hora_Fin, Date Sesion_Fech, double Sesion_Precio, String Sesion_Tipo)
	{
		this.Sesion_ID = Sesion_ID;
		this.sala = sala;
		this.peli = peli;
		this.Sesion_Hora_Ini = Sesion_Hora_Ini;
		this.Sesion_Hora_Fin = Sesion_Hora_Fin;
		this.Sesion_Fech = Sesion_Fech;
		this.Sesion_Precio = Sesion_Precio;
		this.Sesion_Tipo = Sesion_Tipo;
		
	}
	public Sesion()
	{
		Sesion_ID = "";
		sala = null;
		peli = null;
		Sesion_Hora_Ini = Time.valueOf("18:00:00");
		Sesion_Hora_Fin = Time.valueOf("20:00:00"); 
		Sesion_Fech = null;
		Sesion_Precio = 0;
		Sesion_Tipo = "";
	}

	public String getSesion_ID() {
		return Sesion_ID;
	}
	public void setSesion_ID(String sesion_ID) {
		Sesion_ID = sesion_ID;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Pelis getPeli() {
		return peli;
	}
	public void setPeli(Pelis peli) {
		this.peli = peli;
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
	public Date getSesion_Fech() {
		return Sesion_Fech;
	}
	public void setSesion_Fech(Date sesion_Fech) {
		Sesion_Fech = sesion_Fech;
	}
	public double getSesion_Precio() {
		return Sesion_Precio;
	}
	public void setSesion_Precio(double sesion_Precio) {
		Sesion_Precio = sesion_Precio;
	}
	public String getSesion_Tipo() {
		return Sesion_Tipo;
	}
	public void setSesion_Tipo(String sesion_Tipo) {
		Sesion_Tipo = sesion_Tipo;
	}
	@Override
	public String toString() {
		return "El identificador de la sesion es: "+ Sesion_ID + " " + "El identificador de la sala es: " + " " + sala + 
				"El identificador de la pelicula es: " + peli + " " + "La hora inicial de la sesion es: " + Sesion_Hora_Ini + " " + 
				"La hora final de la sesion es: " + Sesion_Hora_Fin + " " + "La fecha de la sesion es: " + Sesion_Fech + " "+ 
				"El precio de la sesion es: " + Sesion_Precio + " " + "El tipo de la sesioon es: " + Sesion_Tipo;
	}
	
	
	
}