package personajes;

public class Warrior extends Personaje {
    private int fuerza;
    private int resistencia;
    private String tipoArma;

    public String getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(String tipoArma) {
        this.tipoArma = tipoArma;
    }

    public Warrior(String nombre, int fuerza, int resistencia) {
        super(nombre);
        this.fuerza = fuerza;
        this.resistencia = resistencia;
    }

    public Warrior(String nombre, int fuerza, int resistencia, String tipoArma) {
        super(nombre);
        this.fuerza = 10; // Valor predeterminado de fuerza
        this.resistencia = 5; // Valor predeterminado de resistencia
        this.tipoArma = tipoArma;

    }


    public int getFuerza() {
        return fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " está atacando con una espada.");
    }

    public void atacar(String tipoArma) {
        System.out.println(getNombre() + " está atacando con una " + tipoArma + ".");
    }
    @Override
    public String defender() {
        return getNombre() + " está defendiendo con un escudo.";
    }

}
