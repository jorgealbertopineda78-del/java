package Personaje;

public class Guerrero extends Personaje  {
    private int fuerza;
    private String armadura;

    public Guerrero(String nombre, int nivel, int puntoDeVida, String armadura, int fuerza) {
        super(nombre, nivel, puntoDeVida);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    public int getFuerza() {
        return fuerza;
    }

    public String getArmadura() {
        return armadura;
    }

    @Override 
    public void atacar() {
        System.out.println(getNombre() + "golpea con su espada causando " + getFuerza() + " puntos de daño.");
    }

    @Override 
    public void defender() {
        super.defender();
        System.out.println(getNombre() + " se protege con su armadura " + getArmadura());
    } 

    @Override 
    public int calcularDanio() {
        return fuerza * getNivel(); 
    }

    @Override 
    public String toString() {
        return super.toString() + 
                "\nFuerza: " + fuerza + 
                "\nArmadura: " + armadura;
    }
}