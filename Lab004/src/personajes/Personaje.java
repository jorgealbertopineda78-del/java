package personajes;

import skills.ICombatiente;

public class Personaje implements ICombatiente {
    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;
    


    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;   
        this.estaVivo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }
    public int getPuntosVida() {
        return puntosVida;
    }
        
    public boolean isEstaVivo() {
        return estaVivo;
    }

    @Override
    public void atacar() {
        System.out.println("El personaje " + nombre + " está atacando con nivel " + nivel + ".");
    }

    @Override
    public String defender() {
        return "El personaje " + nombre + " está defendiendo con nivel " + nivel + ".";
    }  
    
    public String toString() {
        return "Nombre: " + nombre + ", Nivel: " + nivel + ", Puntos de Vida: " + puntosVida + ", Está Vivo: " + estaVivo;
    }
}
