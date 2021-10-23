package modelo.persistencia;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import modelo.entidad.Cliente;
import modelo.entidad.Pedido;

@Repository
public class DaoClienteJDBCTemplate implements DaoClientePedido {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DaoClienteRowMapper clienteRowMapper;
	
	public int insertarCliente(Cliente c) {
		String query = "insert into cliente (NOMBRE, EDAD) values (?, ?)";

		// Le pasamos la query y los valores de las "?" en orden
		System.out.println(c.getNombre() + c.getEdad());
		int id = jdbcTemplate.update(query, c.getNombre(), c.getEdad());
		return id;
	} 

	public int modificarCliente(Cliente c) {
		String query = "update cliente SET NOMBRE=?, EDAD=? where id=?";

		// Al final el update sive para modificar la BBDD
		int id = jdbcTemplate.update(query, c.getNombre(), c.getEdad());

		return id;
	}

	public int borrar(int id) {
		String query = "delete from cliente where id=?";
		return jdbcTemplate.update(query, id);
	}

	public Cliente buscarID(int id) {
		String query = "select * from cliente where id=?";

		Cliente cliente = null;

		try {
			cliente = jdbcTemplate.queryForObject(query, clienteRowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			// Este tipo de excepciones ocurren cuando esperamos un objeto y nos devuelve
			// 0.
			System.out.println("EmptyResultDataAccessException: " + e.getMessage());
		}

		return cliente;
	}

	public Cliente buscarNombre(String nombre) {
		String query = "select * from cliente where nombre=?";

		Cliente cliente = null;

		try {
			cliente = jdbcTemplate.queryForObject(query, clienteRowMapper, nombre);
		} catch (EmptyResultDataAccessException e) {
			// Este tipo de excepciones ocurren cuando esperamos un objeto y nos devuelve
			// 0.
			System.out.println("EmptyResultDataAccessException: " + e.getMessage());
		}

		return cliente;
	}

	public int insertarPedidoCliente(Pedido p, int id) {
		String query = "insert into pedido (IMPORTE, FECHA, ID_CLIENTE) values (?, ?, ?)";

		// Le pasamos la query y los valores de las "?" en orden
		int id1 = jdbcTemplate.update(query, p.getImporte(), p.getFecha(), id);

		return id1;
	}

	public ArrayList<Pedido> listarPedidoCliente(int id) {
		// TODO Auto-generated method stub
		return null;
	}

/**
	public ArrayList<Pedido> listarPedidoCliente(int id) {
		String query = "select id, nombre, edad,  from cliente where id = ?";
		//Como son varios elementos ejecutamos el metodo "query"
		//return jdbcTemplate.query(query, clienteRowMapper);
	}
	*/
	
	/**
	public ArrayList<Pedido> listarPedidoCliente(int id) {
		String query = "select importe, fecha FROM pedidos WHERE idCliente = ?";


		return jdbcTemplate.query(query, pedidoRowMapper);
	}
	*/
}
