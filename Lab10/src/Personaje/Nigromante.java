package Personaje;

public class Nigromante extends Personaje implements Hechicero {
    private int mana; 
    private int almasAbsorbidas;
    private int poderOscuro;

    // Constructor corto usado en el Lab10: Nigromante("Malachar", 8, 150, 120)
    public Nigromante(String nombre, int nivel, int puntoDeVida, int mana) {
        this(nombre, nivel, puntoDeVida, mana, 50, 1);
    }

    public Nigromante(String nombre, int nivel, int puntoDeVida, int mana, int almasAbsorbidas, int poderOscuro) {
        super(nombre, nivel, puntoDeVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
        this.poderOscuro = poderOscuro;
    }

    @Override 
    public int getMana() {
        return mana;
    }
    
    public int getAlmasAbsorbidas(){
        return almasAbsorbidas;

    }

    public int getPoderOscuro(){
        return poderOscuro;
    }

    @Override
    public int  calcularDanio() {
        return (int)(mana*poderOscuro*0.8*nivel);
    }

    

    @Override
    public void atacar() {
        System.out.println(this.getNombre() + " hace " );
        System.out.print("Ataque de almas, ");
    }

    public void atacar(Personaje victima) throws RpgException{
        if(this.mana < 10){throw new RecursoInsuficienteException("mana", this.mana);}
        if(this.almasAbsorbidas < 10){throw new RecursoInsuficienteException("almas", this.almasAbsorbidas);}
        if(!victima.estaVivo){throw new PersonajeDerrotadoException(victima.getNombre());}
        atacar();
        mana -= 10;
        almasAbsorbidas -= 10;
        victima.recibirDanio(this.calcularDanio());
    }

    @Override
    public void defender() {
        super.defender();
        System.out.print(" con magia oscura. ");
    }

    @Override
    public void lanzarHechizo(Personaje victimPersonaje) {
        try {
            atacar(victimPersonaje);
            System.out.print(" de maldicion oscura");
            almasAbsorbidas -=5;
            victimPersonaje.recibirDanio(calcularDanio());
        
        }catch(RecursoInsuficienteException e){System.out.println(e); 
        }catch(RpgException e){System.out.println(e);}    
    }
}