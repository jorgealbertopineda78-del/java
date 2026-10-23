import personajes.Personaje;
import personajes.Warrior;

import java.util.ArrayList;

import personajes.Mago;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Personaje p1 = new Personaje("Juan", 5, 100);
        System.out.println(p1.toString());  
         Personaje g2 = new Warrior("Miguel", 8, 150, 15, 10);
        System.out.println(g2.toString());
        //System.out.println(g2.getTipoArma());
        g2.atacar();

        Personaje g1 = new Warrior("Guerrero Dragon", 10, 200, "Espada");
        System.out.println(g1.toString()); 
        // System.out.println(g1.getTipoArma());
        //g1.atacar(20, "Espada");
       
        Personaje m1 = new Mago("Merlin", 12, 80, 30, 100);
        System.out.println(m1.toString());

        Personaje[] personajes = { g1, g2, m1, p1 };
        Personaje[] personajes2 = new Personaje[4];

        for (int i = 0; i < personajes.length; i++) {
            System.out.println(personajes[i].toString());
        }   
        
        for (Personaje personaje : personajes) {
            personaje.atacar();
            System.out.println(personaje.defender());
        }
        
        ArrayList<Personaje> listaPersonajes = new ArrayList<>();
        listaPersonajes.add(g1); 
        listaPersonajes.add(g2);
        listaPersonajes.add(m1);        
          
        
        ArrayList al = new ArrayList();
        al.add(g1);
        al.add(g2);
        al.add(m1);
        al.add(p1);

        for (Personaje obj : al) {
            if (obj instanceof Personaje) {
                Personaje personaje = (Personaje) obj;
                System.out.println(personaje.toString());
            }
        }

    }
}
