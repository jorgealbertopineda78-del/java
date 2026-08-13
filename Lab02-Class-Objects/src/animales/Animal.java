package animales;

public class Animal {
	private String nombre;
	private int edad;
	private double peso;

	public Animal(String nombre, int edad, double peso) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	public void comer() {
		System.out.println(nombre + " está comiendo.");
	}

	public void dormir() {
		System.out.println(nombre + " está durmiendo.");
	}

	@Override
	public String toString() {
		return "Animal{nombre='" + nombre + "', edad=" + edad + ", peso=" + peso + "}";
	}

}
