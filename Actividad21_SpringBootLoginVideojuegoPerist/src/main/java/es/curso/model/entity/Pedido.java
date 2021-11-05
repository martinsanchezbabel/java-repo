package es.curso.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_username_usuario", referencedColumnName = "username")
	private Usuario usuario;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Videojuego> videojuegos = new ArrayList<Videojuego>();

	private Date fecha;

	private double totalPedido;

	public Pedido() {
		super();
	}

	public Pedido(Integer id, Usuario usuario, List<Videojuego> videojuegos, Date fecha, double totalPedido) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.videojuegos = videojuegos;
		this.fecha = fecha;
		this.totalPedido = totalPedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public List<Videojuego> getVideojuegos() {
		return videojuegos;
	}

	public void setVideojuegos(List<Videojuego> videojuegos) {
		this.videojuegos = videojuegos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double calcularTotal() {
		double total = 0;
		for (Videojuego v : this.videojuegos) {
			total += v.getPrice();
		}
		return total;
	}
}
