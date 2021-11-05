package es.curso.babel.model.service;

import java.util.List;

import es.curso.babel.model.entity.Pedido;

public interface PedidoService {

	List<Pedido> getAllPedidos();

	Pedido findPedidoById(int id);

	void añadirPedido(Pedido pedido);

	void eliminarPedido(int id);
}
