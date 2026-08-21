import aereo.Avion;
import vehiculos.Vehiculo;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Vehiculo vehiculo = new Vehiculo("Toyota", "Corolla", 2020, 180.0);
        vehiculo.describir();
        Avion avion = new Avion("Boeing", "737", 2010, 850.0, 2);
        
    }
}
