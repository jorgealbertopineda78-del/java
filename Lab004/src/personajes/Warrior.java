package personajes;

public class Warrior extends Personaje {
    private int fuerza;
    private int resistencia;
    private String tipoArma;

    public String getTipoArma() {
        return tipoArma;
    }

    public Warrior(String nombre, int nivel, int puntosVida, int fuerza, int resistencia) {
        super(nombre, nivel, puntosVida);
        this.fuerza = fuerza;
        this.resistencia = resistencia;
    }

    public Warrior(String nombre, int nivel, int puntosVida, String tipoArma) {
        super(nombre, nivel, puntosVida);
        this.fuerza = 10; // Valor predeterminado de fuerza
        this.resistencia = 5; // Valor predeterminado de resistencia
        this.tipoArma = tipoArma; // Inicializa el tipo de arma
    }


    public int getFuerza() {
        return fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    @Override
    public void atacar() {
        System.out.println("El guerrero " + getNombre() + " está atacando con fuerza " + fuerza + ".");
    }
    public void atacar(int fuerza, String tipoArma) {
        System.out.println("El guerrero " + getNombre() + " está atacando con fuerza " + fuerza +  " y con el arma " + tipoArma + ".");
    }

    @Override
    public String defender() {
        return "El guerrero " + getNombre() + " está defendiendo con resistencia " + resistencia + ".";
    }

}
