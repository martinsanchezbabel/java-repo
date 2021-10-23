package modelo.entidad;
import java.util.ArrayList;

/**
 * Clase ordenador
 * 
 * @author martin.sanchez
 *
 */

public class Ordenador {

	/**
	 * Atributos
	 */
	private double precio;
	private String marca;

	/**
	 * ArrayList para almacenar las distintas Ram, TarjetaGrafica y Periferico
	 */
	private ArrayList<Ram> ramListOrdenador = new ArrayList<Ram>();
	private ArrayList<TarjetaGrafica> graficaListOrdenador = new ArrayList<TarjetaGrafica>();
	private ArrayList<Periferico> perifListOrdenador = new ArrayList<Periferico>();

	/**
	 * Instancia de objetos Procesador y PlacaBase
	 */
	private Procesador procesador;
	private PlacaBase placaBase;

	/**
	 * Constructores vacio y con parametros
	 */
	public Ordenador() {
		super();
	}

	public Ordenador(double precio, String marca, ArrayList<Ram> ramListOrdenador, ArrayList<TarjetaGrafica> graficaListOrdenador,
			ArrayList<Periferico> perifListOrdenador, Procesador procesador, PlacaBase placaBase) {
		super();
		this.precio = precio;
		this.marca = marca;
		this.ramListOrdenador = ramListOrdenador;
		this.graficaListOrdenador = graficaListOrdenador;
		this.perifListOrdenador = perifListOrdenador;
		this.procesador = procesador;
		this.placaBase = placaBase;
	}

	/**
	 * Metodo que calcula el precio de todos los componentes (incluido el de los
	 * componentes que incluyen otros componentes)
	 * 
	 * @return precioTotal, un double que almacena el precio de TODOS los
	 *         componentes
	 */
	public double calcularPrecioComponentes() {
		double precioTotal = 0;

		ArrayList<Ram> ramListOrdenador = getRamListOrdenador();
		ArrayList<TarjetaGrafica> graficaListOrdenador = getGraficaListOrdenador();
		ArrayList<Periferico> perifListOrdenador = getPerifListOrdenador();
		double ramListPrecio = 0;
		double graficaListPrecio = 0;
		double perifListPrecio = 0;

		for (int i = 0; i < ramListOrdenador.size(); i++) {
			ramListPrecio += ramListOrdenador.get(i).getPrecio();
		}

		for (int i = 0; i < graficaListOrdenador.size(); i++) {
			graficaListPrecio += graficaListOrdenador.get(i).getPrecio();
		}

		for (int i = 0; i < perifListOrdenador.size(); i++) {
			perifListPrecio += perifListOrdenador.get(i).getPrecio();
		}

		precioTotal = graficaListPrecio + ramListPrecio + perifListPrecio + getProcesador().getPrecio()
				+ getPlacaBase().getPrecio();

		return precioTotal;
	}
	
	public void inicializador() {
		this.precio = calcularPrecioComponentes();
	}

	/**
	 * 
	 * Getters y Setters
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

	public ArrayList<Ram> getRamListOrdenador() {
		return ramListOrdenador;
	}

	public void setRamListOrdenador(ArrayList<Ram> ramListOrdenador) {
		this.ramListOrdenador = ramListOrdenador;
	}

	public ArrayList<TarjetaGrafica> getGraficaListOrdenador() {
		return graficaListOrdenador;
	}

	public void setGraficaListOrdenador(ArrayList<TarjetaGrafica> graficaListOrdenador) {
		this.graficaListOrdenador = graficaListOrdenador;
	}

	public ArrayList<Periferico> getPerifListOrdenador() {
		return perifListOrdenador;
	}

	public void setPerifListOrdenador(ArrayList<Periferico> perifListOrdenador) {
		this.perifListOrdenador = perifListOrdenador;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public PlacaBase getPlacaBase() {
		return placaBase;
	}

	public void setPlacaBase(PlacaBase placaBase) {
		this.placaBase = placaBase;
	}

	/**
	 * Metodo toString
	 */
	@Override
	public String toString() {
		return "Ordenador [precio=" + precio + ", marca=" + marca + ",\n \n ramList=" + ramListOrdenador + ",\n \n graficaList="
				+ graficaListOrdenador + ", \n \n perifList=" + perifListOrdenador + ", \n \n procesador=" + procesador
				+ ",\n \n placaBase=" + placaBase + "]";
	}

}
