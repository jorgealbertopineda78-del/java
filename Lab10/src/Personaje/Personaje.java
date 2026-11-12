package Personaje;

public abstract class Personaje {
    protected  String nombre;
    protected  int nivel;
    protected  int puntoDeVida;
    protected  boolean estaVivo = true;
    


    public Personaje(String nombre, int nivel, int puntoDeVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntoDeVida = puntoDeVida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntoDeVida() {
        return puntoDeVida;
    }

    public boolean getEstaVivo() {
        return estaVivo;
    }

    public void recibirDanio(int danio) throws AccionInvalidaException {
    if (danio < 0) {
        throw new AccionInvalidaException(
            "recibirDanio",
            "El daño no puede ser negativo: " + danio
        );
    }
    puntoDeVida -= danio;
    if (puntoDeVida <= 0) {
        puntoDeVida = 0;
        estaVivo = false;
    }
    System.out.println(nombre + " recibe " + danio +
                       " de daño. Vida: " + puntoDeVida);
    if (!estaVivo) {
        System.out.println(nombre + " ha sido derrotado.");
    }
}

    public abstract int calcularDanio();

    public abstract void atacar() throws RpgException;

    public void defender(){System.out.println(nombre + " se defiende del ataque.");}

    @Override 
    public String toString(){
        return "=====" + getClass().getSimpleName() + "=====" + 
                "\nNombre: " + nombre + 
                "\nNivel: " + nivel + 
                "\nPuntos de Vida: " + puntoDeVida;
    }

    public void mostrarEstado(){
        System.out.println("Estado de " + this.nombre + 
                            " | Puntos de Vida: "+ this.puntoDeVida);
    }  

    public void mostrarEstado(boolean detallado){
        if(detallado){
            System.out.println("Estado de " + this.nombre + 
                                " | Puntos de Vida: "+ this.puntoDeVida +
                                " | Nivel: "+ this.nivel);
        }
    } 
     
    public void mostrarEstado(String prefijo){
        System.out.println(prefijo + "Estado de " + this.nombre + 
                                    " | Puntos de Vida: "+ this.puntoDeVida);    
    }   
}