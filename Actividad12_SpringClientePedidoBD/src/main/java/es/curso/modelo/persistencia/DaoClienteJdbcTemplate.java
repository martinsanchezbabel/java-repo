package es.curso.modelo.persistencia;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Cliente;

@Repository
public class DaoClienteJdbcTemplate implements DaoCliente {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DaoClienteRowMapper clienteRowMapper;

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
	public ArrayList<Cliente> listarCliente() {
		String query = "select * from cliente";

		return (ArrayList<Cliente>) jdbcTemplate.query(query, clienteRowMapper);
	}

	public void crearTablaCliente() {
		jdbcTemplate.execute("CREATE TABLE clientes (" + "id int NOT NULL AUTO_INCREMENT,"
				+ "nombre varchar(25) NOT NULL," + "PRIMARY KEY (id)" + "); ");
	}
}
