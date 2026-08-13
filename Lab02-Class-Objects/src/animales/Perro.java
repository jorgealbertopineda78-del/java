package animales;

public  class Perro extends Animal {
    private String raza;

    public Perro(String nombre, int edad, double peso, String raza) {
        super(nombre, edad, peso);
        this.raza = raza;
        ladrar(nombre);
    }
    private void ladrar(String nombre) {
        System.out.println(nombre + " está ladrando.");
    }

    @Override
    public void dormir() {
		System.out.println( this.raza + " Perro NO está durmiendo.");
	}

    //@Override
   // public String toString() {
   //     return "Perro{nombre='" + getNombre() + "', edad=" + getEdad() + ", peso=" + getPeso() + ", raza='" + raza + "'}";
   // }

}
