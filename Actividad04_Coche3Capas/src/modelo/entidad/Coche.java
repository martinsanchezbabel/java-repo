package modelo.entidad;

public class Coche {

	private String matricula;
	private String marca;
	private String modelo;
	private int numKm;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumKm() {
		return numKm;
	}

	public void setNumKm(int numKm) {
		this.numKm = numKm;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", numKm=" + numKm + "]";
	}

}