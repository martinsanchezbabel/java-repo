package es.curso.modelo.persistencia;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Pedido;

@Repository
public class DaoPedidoJdbcTemplate implements DaoPedido {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DaoPedidoRowMapper pedidoRowMapper;

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
