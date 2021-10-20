package modelo.entidad;

/**
 * Clase procesador
 * 
 * @author martin.sanchez
 *
 */
public class Procesador {
	/**
	 * Atributos
	 */
	private double precio;
	private double hz;
	private String marca;
	private TarjetaGrafica tarjetaGraficaProcesador;

	/**
	 * Constructores vacio y con paramteros
	 */
	public Procesador() {
		super();
	}

	public Procesador(double precio, double hz, String marca, TarjetaGrafica tarjetaGraficaProcesador) {
		super();
		this.precio = precio;
		this.hz = hz;
		this.marca = marca;
		this.tarjetaGraficaProcesador = tarjetaGraficaProcesador;
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

	public double getHz() {
		return hz;
	}

	public void setHz(double hz) {
		this.hz = hz;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public TarjetaGrafica gettarjetaGraficaProcesador() {
		return tarjetaGraficaProcesador;
	}

	public void settarjetaGraficaProcesador(TarjetaGrafica tarjetaGraficaProcesador) {
		this.tarjetaGraficaProcesador = tarjetaGraficaProcesador;
		setPrecio(getPrecio() + tarjetaGraficaProcesador.getPrecio());
	}

	@Override
	public String toString() {
		return "Procesador [precio=" + precio + ", hz=" + hz + ", marca=" + marca + ", tarjetaGraficaProcesador=" + tarjetaGraficaProcesador
				+ "]";
	}

}
