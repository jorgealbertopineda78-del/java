package personajes;
import RPGException;
public class Warrior extends Personaje {
    private int fuerza;

    public Warrior(String nombre, int nivel, int puntosVida, int fuerza) {
        super(nombre, nivel, puntosVida);
        this.fuerza = fuerza;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con su espada.");
        throw  new RPGException("Error: " + nombre + " no puede atacar debido a un error en el sistema.");
    }

    @Override
    public int calcularDanio() {
        int danio = fuerza * nivel;
        System.out.println(nombre + " causa " + danio + " puntos de daño.");
        return danio;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " no puede lanzar hechizos porque es un guerrero.");
    }

    @Override
    public int getMana() {
        System.out.println(nombre + " tiene 0 puntos de mana.");
        return 0;
    }

    @Override
    public void curarAliado(Personaje aliado) {
        System.out.println(nombre + " no puede curar aliados porque es un guerrero.");
    }

    @Override
    public int getPoderCuracion() {
        System.out.println(nombre + " tiene 0 puntos de poder de curacion.");
        return 0;
    }

}
