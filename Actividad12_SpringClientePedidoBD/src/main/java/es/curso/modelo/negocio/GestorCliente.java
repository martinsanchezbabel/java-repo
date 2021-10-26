package es.curso.modelo.negocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.entidades.Pedido;
import es.curso.modelo.persistencia.DaoCliente;

@Service
public class GestorCliente {

	@Autowired
	DaoCliente daoCliente;

	/**
	 * 
	 * @param p la pelicula que daremos de alta
	 * @return el id en caso de que se haya dado de alta, -1 en caso de que el
	 *         titulo sea vacio
	 */
	public int insertarCliente(Cliente c) {
		if (!"".equals(c.getNombre()) || !"".equals(c.getEdad())) {
			System.out.println("Se ha dado de alta al cliente " + c.getNombre() + " de " + c.getEdad() + " años.");
			return daoCliente.insertarCliente(c);
		}
		return -1;
	}

	public int modificarCliente(Cliente c, int id) {
		if (!"".equals(c.getNombre()) || !"".equals(c.getEdad())) {
			System.out.println("El cliente con ID " + id + " ahora tiene los siguientes datos NOMBRE: " + c.getNombre()
					+ " EDAD:" + c.getEdad());
			return daoCliente.modificarCliente(c, id);
		}
		return -1;
	}

	public int borrar(int id) {
		if (daoCliente.buscarID(id) == null) {
			System.out.println("No existen clientes con el ID: " + id);
		} else {
			System.out.println("Cliente con ID " + id + " borrado.");
		}
		return daoCliente.borrar(id);
	}

	public Cliente buscarID(int id) {
		if (daoCliente.buscarID(id) == null) {
			System.out.println("No existen clientes con el ID: " + id);
		} else {
			System.out.println("Cliente con ID " + id + " encontrado: \n" + daoCliente.buscarID(id));
		}
		return daoCliente.buscarID(id);
	}

	public ArrayList<Cliente> buscarNombre(String nombre) {
		if (daoCliente.buscarNombre(nombre).size() == 0) {
			System.out.println("No existen clientes con el nombre: " + nombre);
		} else {
			System.out.println("Cliente con nombre " + nombre + " encontrado: \n" + daoCliente.buscarNombre(nombre));
		}
		return daoCliente.buscarNombre(nombre);
	}

	public ArrayList<Cliente> listarCliente() {
		return daoCliente.listarCliente();
	}
}
