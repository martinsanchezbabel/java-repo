import java.util.ArrayList;

public class Ordenador {

	private double precio;
	private String marca;

	private ArrayList<Ram> ramList = new ArrayList<Ram>();
	private ArrayList<TarjetaGrafica> graficaList = new ArrayList<TarjetaGrafica>();
	private ArrayList<Periferico> perifList = new ArrayList<Periferico>();

	private Procesador procesador;
	private PlacaBase placaBase;

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
		
		precioTotal = graficaListPrecio + ramListPrecio + perifListPrecio + getProcesador().getPrecio() + getPlacaBase().getPrecio();
		
		return precioTotal;
	}

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

	@Override
	public String toString() {
		return "Ordenador [precio=" + precio + ", marca=" + marca + ",\n \n ramList=" + ramList + ",\n \n graficaList="
				+ graficaList + ", \n \n perifList=" + perifList + ", \n \n procesador=" + procesador + ",\n \n placaBase=" + placaBase
				+ "]";
	}

}
