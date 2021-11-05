package es.curso.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

@Entity
@Table(name="coches")
public class Coche {

	@Id
	private String matricula;
	private String marca;
	private String modelo;
	private int numeroKm;
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
	public int getNumeroKm() {
		return numeroKm;
	}
	public void setNumeroKm(int numeroKm) {
		this.numeroKm = numeroKm;
	}
	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", numeroKm=" + numeroKm
				+ "]";
	}

}
