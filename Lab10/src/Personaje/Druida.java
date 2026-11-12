package Personaje;


public class Druida extends Personaje implements Hechicero, Sanador {
    private int mana;
    private int poderCuracion;
    private int inteligencia;
    private int fe;

    // Constructor corto usado en el Lab09: Druida("Sylva", 10, 300, 100)
    public Druida(String nombre, int nivel, int puntoDeVida, int mana) {
        this(nombre, nivel, puntoDeVida, mana, 10, 10, 10);
    }

    public Druida(String nombre, int nivel, int puntoDeVida, int mana, int poderCuracion, int inteligencia, int fe) {
        super(nombre, nivel, puntoDeVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.inteligencia = inteligencia;
        this.fe = fe;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getPoderDeCuracion() {
        return poderCuracion;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getFe() {
        return fe;
    }

    
    @Override
    public int calcularDanio() {
        return (int)(inteligencia * fe * nivel* 0.33);
    }

    @Override
    public void atacar() {
        System.out.println(this.getNombre() + " hace Ataque de almas");

    }

    public void atacar(Personaje victima) throws RpgException{
        if(!victima.getEstaVivo()){throw new PersonajeDerrotadoException(victima.getNombre());}
        if(mana < 10){throw new RecursoInsuficienteException("mana",mana);}
        this.atacar();
        mana -= 10;
        victima.recibirDanio(this.calcularDanio());
    }

    @Override
    public void lanzarHechizo(Personaje victima) {
        try {
            this.atacar(victima);
            System.out.println("con de ramas magicas");
            this.mana  = mana - 5;
            victima.recibirDanio(this.calcularDanio());
            
        } catch (PersonajeDerrotadoException e) {
            System.out.println(e);
        }catch(RecursoInsuficienteException e){
            System.out.println(e);
        } catch (RpgException e) {
            System.out.println(e);
        }
    }

    @Override
    public void curarAliado(Personaje aliadPersonaje) throws RpgException{
        if(aliadPersonaje == null){throw new PersonajeNuloException("curar");}
        if(!getEstaVivo()){throw  new AccionInvalidaException("curar", "no se puede curar aliado abatido.");}
        System.out.println(this.nombre + "curando a " + aliadPersonaje.nombre);
        aliadPersonaje.puntoDeVida = aliadPersonaje.puntoDeVida + poderCuracion;
    }

}