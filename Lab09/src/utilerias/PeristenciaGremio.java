package utilerias;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import personajes.Personaje;

public class PeristenciaGremio {
    private static final String CARPETA = "/Users/jislas/tecnoch/lab09";
    private static final Path DIRECTORIO = Paths.get(CARPETA);
    private static final Path ARCHIVO_ROSTER = DIRECTORIO.resolve("roster.txt");
    private static final Path ARCHIVO_INVENTARIO = DIRECTORIO.resolve("inventario.properties");
    private static final Path ARCHIVO_BITACORA = DIRECTORIO.resolve("bitacora.txt");

    public void guardarRoster(ArrayList<Personaje> roster) throws IOException {
        crearCarpetaSiNoExiste();
        ArrayList<String> nombres = new ArrayList<>();
        for (Personaje personaje : roster) {
            nombres.add(personaje.toString());
        }
        Files.write(ARCHIVO_ROSTER, nombres, StandardCharsets.UTF_8);
    }

    public ArrayList<String> cargarRoster() throws IOException {
        crearCarpetaSiNoExiste();
        if (Files.notExists(ARCHIVO_ROSTER)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Files.readAllLines(ARCHIVO_ROSTER, StandardCharsets.UTF_8));
    }

    public void guardarInventario(HashMap<String, Integer> inventario) throws IOException {
        crearCarpetaSiNoExiste();
        Properties propiedades = new Properties();
        for (String item : inventario.keySet()) {
            propiedades.setProperty(item, String.valueOf(inventario.get(item)));
        }
        try (Writer writer = Files.newBufferedWriter(ARCHIVO_INVENTARIO, StandardCharsets.UTF_8)) {
            propiedades.store(writer, null);
        }
    }

    public HashMap<String, Integer> cargarInventario() throws IOException {
        crearCarpetaSiNoExiste();
        HashMap<String, Integer> inventario = new HashMap<>();
        if (Files.notExists(ARCHIVO_INVENTARIO)) {
            return inventario;
        }
        Properties propiedades = new Properties();
        try (Reader reader = Files.newBufferedReader(ARCHIVO_INVENTARIO, StandardCharsets.UTF_8)) {
            propiedades.load(reader);
        }
        for (String item : propiedades.stringPropertyNames()) {
            inventario.put(item, Integer.valueOf(propiedades.getProperty(item)));
        }
        return inventario;
    }

    public void agregarEntradaBitacora(String entrada) throws IOException {
        crearCarpetaSiNoExiste();
        Files.write(
                ARCHIVO_BITACORA,
                (entrada + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public void mostrarBitacora() throws IOException {
        crearCarpetaSiNoExiste();
        if (Files.exists(ARCHIVO_BITACORA)) {
            for (String entrada : Files.readAllLines(ARCHIVO_BITACORA, StandardCharsets.UTF_8)) {
                System.out.println(entrada);
            }
        }
    }

    private void crearCarpetaSiNoExiste() throws IOException {
        Files.createDirectories(DIRECTORIO);
    }
}