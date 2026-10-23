import personajes.Personaje;
import personajes.Warrior;

public class App {
    public static void main(String[] args) throws Exception {
        Personaje personaje = new Warrior("Guerrero Lobo", 3, 80, 8);

        personaje.atacar();
        personaje.calcularDanio();
        personaje.recibirDanio(20);

        System.out.println(personaje);

        // null pointer exception
        String s = null;
        //s.length();
        // NumberFormatException
        //int num = Integer.parseInt("abc");

        int[] arr = new int[5];
        arr[10] = 100; // ArrayIndexOutOfBoundsException
    }
}
