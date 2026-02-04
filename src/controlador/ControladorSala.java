package controlador;

import java.util.ArrayList;

import modelo.GestorSala;
import modelo.Sala;

public class ControladorSala {
	
	public Sala buscarSalaPorID(String Sala_ID)
	{
		GestorSala gestorSala = new GestorSala();
		return gestorSala.buscarSalaPorID(Sala_ID);
	}
	
	public ArrayList<Sala> buscarSalas()
	{
		ArrayList<Sala> sala = null;
		GestorSala gestorSala = new GestorSala();
		sala = gestorSala.buscarSalas();
		return sala;
	}

}
