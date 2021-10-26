package es.curso.modelo.entidad;

public class Videojuego {

	private int id;
	private String nombre;
	private String compania;
	private double notaMedia;

	public Videojuego() {
		super();
	}

	public Videojuego(int id, String nombre, String compania, double notaMedia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.compania = compania;
		this.notaMedia = notaMedia;
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

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", compania=" + compania + ", notaMedia=" + notaMedia
				+ "]";
	}

}
