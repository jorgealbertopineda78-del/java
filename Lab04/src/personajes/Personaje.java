package personajes;
import skills.ICombatiente;

public class Personaje implements ICombatiente {
    private String nombre;
    private int nivel;
    private int puntoVida;
    private boolean estaVivo;
    

    public Personaje(String nombre) {
    this.nombre = nombre;
    this.nivel = 1;
    this.puntoVida = 100;
    this.estaVivo = true;
    }

    public String getNombre() {
    return nombre;
    }

    public int getNivel() {
    return nivel;
    }

    public int getPuntoVida() {
    return puntoVida;
    }

    public boolean isEstaVivo() {
    return estaVivo;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " está atacando con un ataque básico.");
    }

    @Override
    public String defender() {
        return nombre + " está defendiendo con un escudo básico.";
    }
}
