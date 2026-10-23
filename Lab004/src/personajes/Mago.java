package personajes;

public class Mago extends Personaje {
	private int poderMagico;
	private int mana;

	public Mago(String nombre, int nivel, int puntosVida, int poderMagico, int mana) {
		super(nombre, nivel, puntosVida);
		this.poderMagico = poderMagico;
		this.mana = mana;
	}

	public int getPoderMagico() {
		return poderMagico;
	}

	public int getMana() {
		return mana;
	}

	public void lanzarHechizo(String hechizo) {
		System.out.println("El mago " + getNombre() + " lanza el hechizo " + hechizo
				+ " con poder magico " + poderMagico + ".");
	}

	public void recuperarMana(int cantidad) {
		if (cantidad > 0) {
			mana += cantidad;
		}
	}

	@Override
	public void atacar() {
		System.out.println("El mago " + getNombre() + " ataca con poder magico " + poderMagico + ".");
	}

	@Override
	public String defender() {
		return "El mago " + getNombre() + " se defiende usando magia.";
	}

}
