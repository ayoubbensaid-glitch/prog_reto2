package controlador;

import modelo.Compra;
import modelo.GestorCompra;
import java.util.List;

public class ControladorCompra {
    
    public void insertarCompra(Compra compra) {
        GestorCompra gestorCompra = new GestorCompra();
        gestorCompra.insertarCompra(compra);
    }

    public Compra buscarUltimaCompra() {
        GestorCompra gestorCompra = new GestorCompra();
        return gestorCompra.buscarUltimaCompra();
    }
    
    
    public Compra buscarCompraPorID(String Compra_ID) {
        GestorCompra gestorCompra = new GestorCompra();
        return gestorCompra.buscarCompraPorID(Compra_ID);
    }

    public List<Compra> buscarComprasCliente(String DNI) {
        GestorCompra gestorCompra = new GestorCompra();
        return gestorCompra.buscarComprasCliente(DNI);
    }
}
