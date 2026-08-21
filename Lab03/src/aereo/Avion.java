package aereo;

import componentes.IVolar;
import vehiculos.Vehiculo;

public class Avion extends Vehiculo implements IVolar {
    private int numMotores;

    public Avion(String marca, String modelo, int anio, double velocidadMax, int numMotores) {
        super(marca, modelo, anio, velocidadMax);
        this.numMotores = numMotores;
    }

    public int getNumMotores() {
        return numMotores;
    }

    public void setNumMotores(int numMotores) {
        this.numMotores = numMotores;
    }

    @Override
    public void describir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Avion{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", anio=" + getAnio() +
                ", velocidadMax=" + getVelocidadMax() +
                ", numMotores=" + numMotores +
                '}';
    }

    @Override
    public String volar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'volar'");
    }

}
