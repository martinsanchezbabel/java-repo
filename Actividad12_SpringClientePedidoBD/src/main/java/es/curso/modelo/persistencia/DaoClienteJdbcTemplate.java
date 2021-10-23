package es.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.entidades.Pedido;

@Repository
public class DaoClienteJdbcTemplate implements DaoCliente {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DaoClienteRowMapper clienteRowMapper;
	@Autowired
	private DaoPedidoRowMapper pedidoRowMapper;

	@Override
	public int insertarCliente(Cliente c) {
		String query = "insert into cliente (NOMBRE, EDAD) values (?, ?)";

		// Le pasamos la query y los valores de las "?" en orden1
		int id = jdbcTemplate.update(query, c.getNombre(), c.getEdad());
		return id;
	}

	@Override
	public int borrar(int id) {
		String query = "delete from cliente where id=?";
		return jdbcTemplate.update(query, id);
	}

	@Override
	public int modificarCliente(Cliente c, int id) {
		String query = "update cliente SET NOMBRE=?, EDAD=? where id=?";

		// Al final el update sive para modificar la BBDD
		int id2 = jdbcTemplate.update(query, c.getNombre(), c.getEdad(), id);

		return id2;
	}

	@Override
	public Cliente buscarID(int id) {
		String query = "select * from cliente where id=?";

		Cliente cliente = null;

		try {
			cliente = jdbcTemplate.queryForObject(query, clienteRowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			// Este tipo de excepciones ocurren cuando esperamos un objeto y nos devuelve
			// 0.
		}

		return cliente;
	}

	@Override
	public ArrayList<Cliente> buscarNombre(String nombre) {
		String query = "select * from cliente where nombre=?";

		return (ArrayList<Cliente>) jdbcTemplate.query(query, clienteRowMapper, nombre);
	}

	@Override
	public int insertarPedidoCliente(Pedido p, int id) {
		String query = "insert into pedido (IMPORTE, FECHA, IDCLIENTE) values (?, ?, ?)";

		// Le pasamos la query y los valores de las "?" en orden
		int id1 = jdbcTemplate.update(query, p.getImporte(), p.getFecha(), id);

		return id1;
	}

	@Override
	public ArrayList<Pedido> listarPedidoCliente(int id) {
		String query = "select * from pedido where idCliente=?";

		return (ArrayList<Pedido>) jdbcTemplate.query(query, pedidoRowMapper, id);
	}

}
