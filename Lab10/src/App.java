import Personaje.*;

public class App {

     // Con 1000 la condición de carrera casi nunca se nota en equipos rápidos;
    // con 100000 por hilo se ve de forma consistente.
    private static final int ITERACIONES = 100000;
    public static void main(String[] args) {
     
        System.out.println("=== Gran Torneo del Gremio ===\n");
 
        // Bloque 1 — Torneo con 3 combates simultáneos
        TablaResultados tabla = new TablaResultados();
 
        Personaje s1 = new Druida("Sylva", 10, 300, 100);
        Personaje m1 = new Nigromante("Malachar", 8, 150, 120);
        Personaje l1 = new Arquero("Legolas", 6, 200, "Arco", 10, 95);
        Personaje t1 = new Guerrero("Thorin", 9, 400, "Hacha", 80);
        Personaje b1 = new Druida("Brego", 7, 250, 80);
        Personaje k1 = new Nigromante("Kael", 5, 180, 90);
 
        CombateConcurrente c1 = new CombateConcurrente("Campo-1", s1, m1, tabla);
        CombateConcurrente c2 = new CombateConcurrente("Campo-2", l1, t1, tabla);
        CombateConcurrente c3 = new CombateConcurrente("Campo-3", b1, k1, tabla);
 
        Thread h1 = new Thread(c1);
        Thread h2 = new Thread(c2);
        Thread h3 = new Thread(c3);
 
        h1.start();
        h2.start();
        h3.start();
 
        // Bloque 2 — Monitor del torneo (hilo independiente)
        MonitorTorneo monitor = new MonitorTorneo("Torneo Principal", 3);
        monitor.start();
 
        // Bloque 3 — Esperar a que todos terminen con join()
        try {
            h1.join();
            h2.join();
            h3.join();
            monitor.join();
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida.");
        }
 
        System.out.println("\nTodos los combates han terminado.");
        tabla.mostrarResultados();
 
        // Bloque 4 — Demostración de race condition
        ContadorCompartido contador = new ContadorCompartido();
        Thread[] hilos = new Thread[5];
 
        try {
            // Sin synchronized — resultado incorrecto
            for (int i = 0; i < 5; i++) {
                hilos[i] = new Thread(() -> {
                    for (int j = 0; j < ITERACIONES; j++) contador.incrementar();
                });
                hilos[i].start();
            }
            for (Thread t : hilos) t.join();
            System.out.println("\nSin sync  — esperado: " + (5 * ITERACIONES) + " | real: " +
                               contador.getContador());
 
            // Con synchronized — resultado correcto
            contador.resetear();
            for (int i = 0; i < 5; i++) {
                hilos[i] = new Thread(() -> {
                    for (int j = 0; j < ITERACIONES; j++) contador.incrementarSeguro();
                });
                hilos[i].start();
            }
            for (Thread t : hilos) t.join();
            System.out.println("Con sync  — esperado: " + (5 * ITERACIONES) + " | real: " +
                               contador.getContador());
 
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida.");
        }
    }
}
