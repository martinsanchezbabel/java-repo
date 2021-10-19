package modelo.entidad;

public class Superheroe {

	private int id;
	private String nombre;
	private int poder;
	private String superpoder;

	public Superheroe() {
		super();
	}

	public Superheroe(int id, String nombre, int poder, String superpoder) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.poder = poder;
		this.superpoder = superpoder;
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

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public String getSuperpoder() {
		return superpoder;
	}

	public void setSuperpoder(String superpoder) {
		this.superpoder = superpoder;
	}

	@Override
	public String toString() {
		return "Superheroe [id=" + id + ", nombre=" + nombre + ", poder=" + poder + ", superpoder=" + superpoder + "]";
	}

}
