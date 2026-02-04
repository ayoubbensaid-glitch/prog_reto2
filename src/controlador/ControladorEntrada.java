package controlador;

import java.util.ArrayList;

import modelo.Entrada;
import modelo.GestorEntrada;
public class ControladorEntrada {
	
	public void  insertarEntrada(Entrada entrada)
	{
		GestorEntrada gestorEntrada = new GestorEntrada();
		gestorEntrada.insertarEntrada(entrada);
	}

	public ArrayList<Entrada> buscarEntradasPorCompra(String Compra_ID)
	{
		ArrayList<Entrada> entrada = null;
		GestorEntrada gestorEntrada = new GestorEntrada();
		entrada = gestorEntrada.buscarEntradasPorCompra(Compra_ID);
		return entrada;
	}
}
