import animales.Perro;
import animales.Animal;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Animal an = new Animal("Toby", 3, 12.5);
        System.out.println(an.toString());
        an.comer("croquetas");
        an.dormir();

        Perro p = new Perro("Max", 2, 10.0, "Labrador", true);
        System.out.println(p.toString());
        p.comer("hueso");
        p.dormir();
        p.buscarPelota();

    }
}
