package animales;

public class Perro extends Animal {

	private String raza;
	private boolean estaVacunado;

	public Perro(String nombre, int edad, double peso, String raza, boolean estaVacunado) {
		super(nombre, edad, peso);
		this.raza = raza;
		this.estaVacunado = estaVacunado;
        ladrar(nombre);
	}

	private void ladrar(String nombre) {
		System.out.println(nombre + " hace: ¡Guau!");
	}

	public void buscarPelota() {
		System.out.println( raza + " está buscando la pelota.");
	}
    @Override
    public void comer(String comida) {
		System.out.println( " NO está comiendo " + "comida Fina" + ".");
	}

	@Override
	public String toString() {
		return super.toString().replace("}", "") +
				", raza='" + raza + '\'' +
				", estaVacunado=" + estaVacunado +
				'}';
	}
}
