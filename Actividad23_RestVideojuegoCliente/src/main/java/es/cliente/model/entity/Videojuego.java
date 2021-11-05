package es.cliente.model.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Videojuego {

	private int id;

	private String nombre;

	private String compania;

	private double nota;

	private String author;

	private int price;

	public Videojuego() {
		super();
	}

	public Videojuego(int id, String nombre, String compania, double nota, String author, int price) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.compania = compania;
		this.nota = nota;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", compania=" + compania + ", nota=" + nota + ", author="
				+ author + ", price=" + price + "]";
	}

}
