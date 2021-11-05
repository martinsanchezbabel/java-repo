package es.curso.babel.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos_videojuegos")
public class PedidoVideojuego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne // (cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_id_pedido", referencedColumnName = "id")
	private Pedido pedido;

	@ManyToOne // (cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_id_videojuego", referencedColumnName = "id")
	private Videojuego videojuego;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

}
