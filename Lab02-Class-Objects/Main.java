public class Main {
    public static void main(String[] args) {
        System.out.println("=== Clinica Veterinaria ===\n");

        // Instanciacion de objetos
        Perro perro = new Perro("Max", 3, 12.5, "Labrador", true);
        Gato gato = new Gato("Misi", 2, 3.8, "Gris", true);
        Canario canario = new Canario("Pico", 1, 0.03, "Amarillo", true);

        // Prueba de Perro
        System.out.println("-- Perro --");
        System.out.println(perro);
        perro.comer();
        perro.ladrar();
        perro.buscarPelota();
        System.out.println();

        // Prueba de Gato
        System.out.println("-- Gato --");
        System.out.println(gato);
        gato.dormir();
        gato.maullar();
        gato.ronronear();
        System.out.println();

        // Prueba de Canario
        System.out.println("-- Canario --");
        System.out.println(canario);
        canario.comer();
        canario.cantar();
        canario.volar();
    }
}