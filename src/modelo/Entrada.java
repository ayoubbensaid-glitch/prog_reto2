  package modelo;

public class Entrada {
	
	private String Entrada_ID;
	private Sesion sesion;
	private Compra compra;
	private int Entrada_Personas;
	private double Entrada_Precio;
	private double Entrada_Descuento;
	
	public Entrada(String Entrada_ID, Sesion sesion, Compra compra, int Entrada_Personas, double Entrada_Precio, double Entrada_Descuento)
	{
		this.Entrada_ID = Entrada_ID;
		this.sesion = sesion;
		this.compra = compra;
		this.Entrada_Personas = Entrada_Personas;
		this.Entrada_Precio = Entrada_Precio;
		this.Entrada_Descuento = Entrada_Descuento;
	}

	public Entrada()
	{
		Entrada_ID = "";
		sesion = null;
		compra = null;
		Entrada_Personas = 0;
		Entrada_Precio = 0;
		Entrada_Descuento = 0;
	}

	public String getEntrada_ID() {
		return Entrada_ID;
	}

	public void setEntrada_ID(String entrada_ID) {
		Entrada_ID = entrada_ID;
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
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

	public double getEntrada_Descuento() {
		return Entrada_Descuento;
	}

	public void setEntrada_Descuento(double entrada_Descuento) {
		Entrada_Descuento = entrada_Descuento;
	}

	@Override
	public String toString() {
		return "El identificador de la entrada es: " + Entrada_ID + " " + "El indetificador de la sesion es: "+ sesion + " " 
				+ "El indetificador de la compra es" + compra + " " + "La entrada por personas es: "+ Entrada_Personas + " " 
				+" El precio de la entrada es: "+ Entrada_Precio + " " + "El decuento de la entrada es: "+ Entrada_Descuento;
	}
	
}