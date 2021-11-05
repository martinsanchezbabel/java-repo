package es.curso.babel.model.service;

import es.curso.babel.model.entity.PedidoVideojuego;
import es.curso.babel.model.entity.Videojuego;

public interface PedidoVideojuegoService {

	Videojuego findVideojuegoPedidoById(int idPedido);

	void añadirPedidoVideojuego(PedidoVideojuego pedidoVideojuego);

	void eliminarPedidoVideojuego(int id);
}
