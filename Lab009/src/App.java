import personajes.Personaje;
import utilerias.PersistenciaGremio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws IOException {
        ArrayList<Personaje> roster = new ArrayList<>();
        roster.add(new Personaje("Aria"));
        roster.add(new Personaje("Borin"));
        PersistenciaGremio.guardarRoster(roster);

        HashMap<String, Integer> inventario = new HashMap<>();
        inventario.put("Pocion", 5);
        inventario.put("Espada", 2);
        PersistenciaGremio.guardarInventario(inventario);

        PersistenciaGremio.agregarEntradaBitacora("Prueba de escritura de archivos completada.");

        System.out.println("Roster guardado: " + PersistenciaGremio.cargarRoster());
        System.out.println("Inventario guardado: " + PersistenciaGremio.cargarInventario());
        System.out.println("Bitacora:");
        PersistenciaGremio.mostrarBitacora();
    }
}
