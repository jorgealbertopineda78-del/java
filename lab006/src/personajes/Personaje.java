package personajes;

import skills.Hechicero;
import skills.Sanador;

public abstract class Personaje  implements Hechicero, Sanador {
	protected String nombre;
	protected int nivel;
	protected int puntosVida;
	protected boolean estaVivo;

	public Personaje(String nombre, int nivel, int puntosVida) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.puntosVida = puntosVida;
		this.estaVivo = puntosVida > 0;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public boolean isEstaVivo() {
		return estaVivo;
	}

	public void recibirDanio(int danio) {
		if (danio <= 0 || !estaVivo) {
			return;
		}

		puntosVida = Math.max(0, puntosVida - danio);
		estaVivo = puntosVida > 0;
	}

	@Override
	public String toString() {
		return "Personaje{" +
				"nombre='" + nombre + '\'' +
				", nivel=" + nivel +
				", puntosVida=" + puntosVida +
				", estaVivo=" + estaVivo +
				'}';
	}

	public abstract void atacar();

	public abstract int calcularDanio();

}
