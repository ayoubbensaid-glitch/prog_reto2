package modelo;

public class Pelis {
	private String Peli_ID;
	private String Peli_Titulo;
	private int Peli_Duracion;
	private String Peli_Genero;
	private double Peli_Precio;
	
	
	public Pelis(String Peli_ID, String Peli_Titulo, int Peli_Duracion, String Peli_Genero, double Peli_Precio)
	{
		this.Peli_ID = Peli_ID;
		this.Peli_Titulo = Peli_Titulo;
		this.Peli_Duracion = Peli_Duracion;
		this.Peli_Genero = Peli_Genero;
		this.Peli_Precio = Peli_Precio;
	}
	
	public Pelis()
	{
		Peli_ID = "";
		Peli_Titulo = "";
		Peli_Duracion = 0;
		Peli_Genero = "";
		Peli_Precio = 0;
	}

	public String getPeli_ID() {
		return Peli_ID;
	}

	public void setPeli_ID(String peli_ID) {
		Peli_ID = peli_ID;
	}

	public String getPeli_Titulo() {
		return Peli_Titulo;
	}

	public void setPeli_Titulo(String peli_Titulo) {
		Peli_Titulo = peli_Titulo;
	}

	public int getPeli_Duracion() {
		return Peli_Duracion;
	}

	public void setPeli_Duracion(int peli_Duracion) {
		Peli_Duracion = peli_Duracion;
	}

	public String getPeli_Genero() {
		return Peli_Genero;
	}

	public void setPeli_Genero(String peli_Genero) {
		Peli_Genero = peli_Genero;
	}

	public double getPeli_Precio() {
		return Peli_Precio;
	}

	public void setPeli_Precio(double peli_Precio) {
		Peli_Precio = peli_Precio;
	}

	@Override
	public String toString() {
		return "El identificador de la peli es: " + Peli_ID + " " + "El titulo de la peli es: "+ Peli_Titulo + " " + "La duracion de la peli es: " + Peli_Duracion
				+ " " + "El genero de la peli es: "+ Peli_Genero + " " + "El precio de la peli es: " + Peli_Precio;
	}
	
	
}
