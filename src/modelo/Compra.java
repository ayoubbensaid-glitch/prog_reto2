package modelo;

import java.sql.Time;
import java.sql.Date;

public class Compra {

	private String Compra_ID;
	private Cliente cliente;
	private Date Compra_Fech;
	private Time Compra_Hora;
	private double Compra_Descuento;
	
	public Compra( String Compra_ID, Cliente cliente, Date Compra_Fech, Time Compra_Hora, double Compra_Descuento)
	{
		this.Compra_ID = Compra_ID;
		this.cliente = cliente;
		this.Compra_Fech = Compra_Fech;
		this.Compra_Hora = Compra_Hora;
		this.Compra_Descuento = Compra_Descuento;
	}
	
	public Compra()
	{
		Compra_ID = "";
		cliente= null;
		Compra_Fech = null;
		Compra_Hora = null;
		Compra_Descuento = 0;
	}

	
	public String getCompra_ID() {
		return Compra_ID;
	}

	public void setCompra_ID(String compra_ID) {
		Compra_ID = compra_ID;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	@Override
	public String toString() {
		return "El identificador de la compra es: " + Compra_ID + " " + "El dni del cliente es: " + cliente + " " 
				+ "La fecha de la compra es:  " + Compra_Fech + " " + " La hora de la compra es: " + Compra_Hora + " "
				+ "El descuento de la compra es: " + Compra_Descuento;
	}
	
	
}