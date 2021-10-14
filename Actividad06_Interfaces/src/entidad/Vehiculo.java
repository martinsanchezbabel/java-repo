package entidad;

import interfaz.Movible;

public class Vehiculo implements Movible {

	private int id;
	private int caballos;
	private String nombre;

	public Vehiculo() {
		super();
	}

	public Vehiculo(int id, int caballos, String nombre) {
		super();
		this.id = id;
		this.caballos = caballos;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
