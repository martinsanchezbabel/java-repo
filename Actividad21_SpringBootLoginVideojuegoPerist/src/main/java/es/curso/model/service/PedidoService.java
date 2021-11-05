package es.curso.model.service;

import java.util.List;

import es.curso.model.entity.Pedido;

public interface PedidoService {

	List<Pedido> findByUsuarioId(int id);

	void añadirPedido(Pedido pedido);

	double calcularTotal(Pedido pedido);
}
