package personajes;

public class Personaje {
    private String nombre;

    public Personaje() {
    }

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre == null ? "" : nombre;
    }
}