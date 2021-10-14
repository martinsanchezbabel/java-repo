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
	private ArrayList<Ram> ramList = new ArrayList<Ram>();
	private ArrayList<TarjetaGrafica> graficaList = new ArrayList<TarjetaGrafica>();
	private ArrayList<Periferico> perifList = new ArrayList<Periferico>();

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

	public Ordenador(double precio, String marca, ArrayList<Ram> ramList, ArrayList<TarjetaGrafica> graficaList,
			ArrayList<Periferico> perifList, Procesador procesador, PlacaBase placaBase) {
		super();
		this.precio = precio;
		this.marca = marca;
		this.ramList = ramList;
		this.graficaList = graficaList;
		this.perifList = perifList;
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

		ArrayList<Ram> ramList = getRamList();
		ArrayList<TarjetaGrafica> graficaList = getGraficaList();
		ArrayList<Periferico> perifList = getPerifList();
		double ramListPrecio = 0;
		double graficaListPrecio = 0;
		double perifListPrecio = 0;

		for (int i = 0; i < ramList.size(); i++) {
			ramListPrecio += ramList.get(i).getPrecio();
		}

		for (int i = 0; i < graficaList.size(); i++) {
			graficaListPrecio += graficaList.get(i).getPrecio();
		}

		for (int i = 0; i < perifList.size(); i++) {
			perifListPrecio += perifList.get(i).getPrecio();
		}

		precioTotal = graficaListPrecio + ramListPrecio + perifListPrecio + getProcesador().getPrecio()
				+ getPlacaBase().getPrecio();

		return precioTotal;
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

	public ArrayList<Ram> getRamList() {
		return ramList;
	}

	public void setRamList(ArrayList<Ram> ramList) {
		this.ramList = ramList;
	}

	public ArrayList<TarjetaGrafica> getGraficaList() {
		return graficaList;
	}

	public void setGraficaList(ArrayList<TarjetaGrafica> graficaList) {
		this.graficaList = graficaList;
	}

	public ArrayList<Periferico> getPerifList() {
		return perifList;
	}

	public void setPerifList(ArrayList<Periferico> perifList) {
		this.perifList = perifList;
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
		return "Ordenador [precio=" + precio + ", marca=" + marca + ",\n \n ramList=" + ramList + ",\n \n graficaList="
				+ graficaList + ", \n \n perifList=" + perifList + ", \n \n procesador=" + procesador
				+ ",\n \n placaBase=" + placaBase + "]";
	}

}
