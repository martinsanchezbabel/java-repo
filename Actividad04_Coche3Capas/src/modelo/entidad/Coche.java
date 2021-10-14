package modelo.entidad;

//Entidad Coche utilizada para la creacion de objetos con el fin de ser almacenada en una BBDD
public class Coche {

	// Atributos propios de la clase
	private String matricula;
	private String marca;
	private String modelo;
	private int numKm;

	// Constructor vacio
	public Coche() {
		super();
	}

	// Constructor con todos los atributos
	public Coche(String matricula, String marca, String modelo, int numKm) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.numKm = numKm;
	}

	// Getters y setters
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