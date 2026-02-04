package controlador;

import java.sql.Date;
import java.util.ArrayList;

import modelo.GestorSesion;
import modelo.Sesion;

public class ControladorSesion {

	public ArrayList<Sesion> buscarFechasSesionPorPeli(String Peli_ID) {
	    GestorSesion gestorSesion = new GestorSesion();
	    return gestorSesion.buscarFechasSesionPorPeli(Peli_ID);
	}

	public ArrayList<Sesion> buscarSesionPorFechaEspecifica(String Peli_ID, Date Sesion_Fech) {
	    GestorSesion gestorSesion = new GestorSesion();
	    return gestorSesion.buscarSesionPorFechaEspecifica(Peli_ID, Sesion_Fech);
	}

}
