package controlador;

import java.util.ArrayList;
import modelo.GestorPelis;
import modelo.Pelis;
import modelo.Sesion;

public class ControladorPelis {
    
    private GestorPelis gestorPelis = new GestorPelis();
    
    public ArrayList<Pelis> seleccionarPelisOrdenadas() {
        try {
            return gestorPelis.seleccionarPelisOrdenadas();
        } catch (Exception e) {
            System.out.println("Error en controlador al obtener películas: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public ArrayList<String> seleccionarFechasPelicula(String peliId) {
        if (peliId == null || peliId.trim().isEmpty()) {
            System.out.println("Error: ID de película requerido");
            return new ArrayList<>();
        }
        
        try {
            return gestorPelis.seleccionarFechasPelicula(peliId);
        } catch (Exception e) {
            System.out.println("Error en controlador al obtener fechas: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public ArrayList<Sesion> seleccionarSesionesPorFecha(String peliId, String fecha) {
        if (peliId == null || peliId.trim().isEmpty()) {
            System.out.println("Error: ID de película requerido");
            return new ArrayList<>();
        }
        
        if (fecha == null || fecha.trim().isEmpty()) {
            System.out.println("Error: Fecha requerida");
            return new ArrayList<>();
        }
        
        try {
            return gestorPelis.seleccionarSesionesPorFecha(peliId, fecha);
        } catch (Exception e) {
            System.out.println("Error en controlador al obtener sesiones: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}