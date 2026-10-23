package utilerias;

import personajes.Personaje;

import java.io.BufferedWriter;
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
import java.util.List;
import java.util.Map;
import java.util.Properties;
//"c:\/users\/jorge\/mydir" \
public class PersistenciaGremio {
    private static final String CARPETA = "/Users/jislas/tecnoch/lab09";
    private static final String ARCHIVO_ROSTER = "roster1.txt";
    private static final String ARCHIVO_INVENTARIO = "inventario1.properties";
    private static final String ARCHIVO_BITACORA = "bitacora1.txt";

    private PersistenciaGremio() {
    }

    public static void guardarRoster(ArrayList<Personaje> personajes) throws IOException {
        crearCarpetaSiNoExiste();
        List<String> roster = new ArrayList<>();
        for (Personaje personaje : personajes) {
            roster.add(personaje.getNombre());
        }
        Files.write(rutaArchivo(ARCHIVO_ROSTER), roster, StandardCharsets.UTF_8);
    }

    public static ArrayList<String> cargarRoster() throws IOException {
        crearCarpetaSiNoExiste();
        Path archivo = rutaArchivo(ARCHIVO_ROSTER);
        if (!Files.exists(archivo)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Files.readAllLines(archivo, StandardCharsets.UTF_8));
    }

    public static void guardarInventario(HashMap<String, Integer> inventario) throws IOException {
        crearCarpetaSiNoExiste();
        Properties propiedades = new Properties();
        for (Map.Entry<String, Integer> entrada : inventario.entrySet()) {
            propiedades.setProperty(entrada.getKey(), String.valueOf(entrada.getValue()));
        }
        try (Writer escritor = Files.newBufferedWriter(
                rutaArchivo(ARCHIVO_INVENTARIO), StandardCharsets.UTF_8)) {
            propiedades.store(escritor, null);
        }
    }

    public static HashMap<String, Integer> cargarInventario() throws IOException {
        crearCarpetaSiNoExiste();
        HashMap<String, Integer> inventario = new HashMap<>();
        Path archivo = rutaArchivo(ARCHIVO_INVENTARIO);
        if (!Files.exists(archivo)) {
            return inventario;
        }

        Properties propiedades = new Properties();
        try (Reader lector = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
            propiedades.load(lector);
        }
        for (String clave : propiedades.stringPropertyNames()) {
            try {
                inventario.put(clave, Integer.parseInt(propiedades.getProperty(clave)));
            } catch (NumberFormatException excepcion) {
                throw new IOException("Cantidad inválida para el artículo: " + clave, excepcion);
            }
        }
        return inventario;
    }

    public static void agregarEntradaBitacora(String entrada) throws IOException {
        crearCarpetaSiNoExiste();
        Path archivo = rutaArchivo(ARCHIVO_BITACORA);
        try (BufferedWriter escritor = Files.newBufferedWriter(
                archivo,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            escritor.write(entrada);
            escritor.newLine();
        }
    }

    public static void mostrarBitacora() throws IOException {
        crearCarpetaSiNoExiste();
        Path archivo = rutaArchivo(ARCHIVO_BITACORA);
        if (!Files.exists(archivo)) {
            return;
        }
        for (String entrada : Files.readAllLines(archivo, StandardCharsets.UTF_8)) {
            System.out.println(entrada);
        }
    }

    private static void crearCarpetaSiNoExiste() throws IOException {
        Files.createDirectories(Paths.get(CARPETA));
    }

    private static Path rutaArchivo(String nombreArchivo) {
        return Paths.get(CARPETA, nombreArchivo);
    }
}