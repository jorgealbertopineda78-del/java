package Personaje;

public class Arquero extends Personaje{
    private String tipoDeArco;
    private int precision;
    private int numeroDeFlechas;

    public Arquero(String nombre, int nivel, int puntoDeVida, String tipoDeArco, int precision, int numeroDeFlechas) {
        super(nombre, nivel, puntoDeVida);
        this.tipoDeArco = tipoDeArco;
        this.precision = precision;
        this.numeroDeFlechas = numeroDeFlechas;
    }

    public String getTipoDeArco() {
        return tipoDeArco;
    }

    public int getPrecision() {
        return precision;
    }

    public int getNumeroDeFlechas() {
        return numeroDeFlechas;
    }

    @Override 
    public void atacar() throws RpgException{

    if (!this.estaVivo) {
        throw new PersonajeDerrotadoException(getNombre());
    }

    if (numeroDeFlechas <= 0) {
        throw new RecursoInsuficienteException("flechas", numeroDeFlechas);
    }

    numeroDeFlechas--;
    System.out.println("[" + getNombre() + "] dispara una flecha. " +
                       "Flechas restantes: " + numeroDeFlechas);
    }

    @Override 
    public void defender() {
        super.defender();
        System.out.println(getNombre() + " esquiva el ataque. ");
    }  

    @Override 
    public int calcularDanio(){
        return (getNumeroDeFlechas() != 0) ? getPrecision() * getNivel() : 0;
    }
 
    @Override 
    public String toString() {
        return super.toString() + 
                "\nYipo de Arco: " + tipoDeArco + 
                "\nNumero de Flechas: " + numeroDeFlechas +
                "\n Presicion: " + precision;
    }  
}