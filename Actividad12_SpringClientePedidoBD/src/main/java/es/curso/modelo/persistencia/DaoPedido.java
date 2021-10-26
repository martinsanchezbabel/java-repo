package es.curso.modelo.persistencia;

import java.util.ArrayList;

import es.curso.modelo.entidades.Pedido;

public interface DaoPedido {

	int insertarPedidoCliente(Pedido p, int id);

	ArrayList<Pedido> listarPedidoCliente(int id);
}
