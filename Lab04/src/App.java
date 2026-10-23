import personajes.Personaje;
import personajes.Warrior;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Crear un personaje
        Personaje personaje1 = new Personaje("Juan");
        personaje1.atacar();
        System.out.println(personaje1.defender());  
        Warrior warrior1 = new Warrior("Carlos", 20, 10);
        warrior1.atacar();  
        System.out.println(warrior1.defender());
        System.out.println("Tipo de arma: " + warrior1.getTipoArma());

        Warrior warrior2 = new Warrior("Pedro", 15, 8, "Espada");
        warrior2.atacar(); 
        System.out.println("Tipo de arma: " + warrior2.getTipoArma());
    

    }
}
