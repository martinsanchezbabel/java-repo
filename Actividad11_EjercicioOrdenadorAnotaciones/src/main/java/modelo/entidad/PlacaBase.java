package modelo.entidad;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Clase placaBase
 * 
 * @author martin.sanchez
 *
 */
@Component(value = "placaBaseBean")
public class PlacaBase {
	/**
	 * Atributos
	 */
	@Value("#{util.generateRandomNumber(100,200)}")
	private double precio;
	@Value("#{util.getRandomMarca()}")
	private String marca;
	@Value("Segundo")
	private String modelo;

	/**
	 * Constructores vacio y con paramteros
	 */
	public PlacaBase() {
		super();
	}

	public PlacaBase(double precio, String marca, String modelo) {
		super();
		this.precio = precio;
		this.marca = marca;
		this.modelo = modelo;
	}

	/**
	 * Getters y setters
	 */
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
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

	@Override
	public String toString() {
		return "PlacaBase [precio=" + precio + ", marca=" + marca + ", modelo=" + modelo + "]";
	}

}
