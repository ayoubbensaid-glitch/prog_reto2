package modelo;

import java.util.ArrayList;

public class Sala {
	
	private String Sala_ID;
	private String Sala_Nombre;
	private ArrayList<Sesion> sesiones;
	
	
	public Sala(String Sala_ID, String Sala_Nombre)
	{
		this.Sala_ID = Sala_ID;
		this.Sala_Nombre= Sala_Nombre;
		this.sesiones = new ArrayList<>();
		
	}
	
	public Sala()
	{
		Sala_ID = "";
		Sala_Nombre= "";
		this.sesiones = new ArrayList<>();
	}

	
	public String getSala_ID() {
		return Sala_ID;
	}

	public void setSala_ID(String sala_ID) {
		Sala_ID = sala_ID;
	}

	public String getSala_Nombre() {
		return Sala_Nombre;
	}

	public void setSala_Nombre(String sala_Nombre) {
		Sala_Nombre = sala_Nombre;
	}
	public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(ArrayList<Sesion> sesiones) {
        this.sesiones = sesiones;
    }
    
    public void addSesion(Sesion sesion) {
        this.sesiones.add(sesion);
    }

	@Override
	public String toString() {
		return "El Identificador de la sala es: "+ Sala_ID + " " +" El nombre de la sala es: " + Sala_Nombre +
				"Total de sesiones" + sesiones.size();
	} 
	
	

}