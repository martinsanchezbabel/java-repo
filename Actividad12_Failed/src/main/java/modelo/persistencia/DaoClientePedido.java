package modelo.persistencia;

import java.util.ArrayList;

import modelo.entidad.Cliente;
import modelo.entidad.Pedido;

public interface DaoClientePedido {
	int insertarCliente(Cliente c);

	int modificarCliente(Cliente c);

	int borrar(int id);

	Cliente buscarID(int id);

	Cliente buscarNombre(String nombre);

	int insertarPedidoCliente(Pedido p, int id);

	ArrayList<Pedido> listarPedidoCliente(int id);
}
