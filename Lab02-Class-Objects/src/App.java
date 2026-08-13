import animales.*;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Animal an = new Animal("Perro", 5, 20.5);

        an.comer();
        an.dormir();

        Perro p = new Perro("Firulais", 3, 15.0, "Labrador");
        p.comer();
        p.dormir(); 
        
    }
}
