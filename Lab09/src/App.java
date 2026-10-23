import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import personajes.Personaje;
import utilerias.PeristenciaGremio;

public class App {
    public static void main(String[] args) throws IOException {
        PeristenciaGremio persistencia = new PeristenciaGremio();

        ArrayList<Personaje> roster = new ArrayList<>();
        roster.add(new Personaje("Aria"));
        roster.add(new Personaje("Borin"));
        persistencia.guardarRoster(roster);

        HashMap<String, Integer> inventario = new HashMap<>();
        inventario.put("Pocion", 5);
        inventario.put("Espada", 2);
        persistencia.guardarInventario(inventario);

        persistencia.agregarEntradaBitacora("Se guardaron los datos de prueba del gremio.");

        System.out.println("Roster cargado: " + persistencia.cargarRoster());
        System.out.println("Inventario cargado: " + persistencia.cargarInventario());
        System.out.println("Bitacora:");
        persistencia.mostrarBitacora();
    }
}
