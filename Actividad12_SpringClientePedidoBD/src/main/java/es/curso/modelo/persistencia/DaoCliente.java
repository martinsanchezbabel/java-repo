package es.curso.modelo.persistencia;

import java.util.ArrayList;

import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.entidades.Pedido;

public interface DaoCliente {
	
	int insertarCliente(Cliente c);

	int modificarCliente(Cliente c, int id);

	int borrar(int id);

	Cliente buscarID(int id);

	ArrayList<Cliente> buscarNombre(String nombre);

	int insertarPedidoCliente(Pedido p, int id);

	ArrayList<Pedido> listarPedidoCliente(int id);
	
	ArrayList<Cliente> listarCliente();
}
