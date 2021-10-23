package es.curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import es.curso.modelo.entidades.Pedido;

/**
 * Esta clase se encarga de conviertir automatimente los registros devueltos por
 * JdbcTemplate a objetos
 */
@Component
public class DaoPedidoRowMapper implements RowMapper<Pedido> {

	// Spring le pasara automaticamente el ResultSet, y la fila del ResultSet
	// con la que esta trabajando
	@Override
	public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pedido p = new Pedido();
		p.setImporte(rs.getDouble("IMPORTE"));
		p.setFecha(rs.getDate("FECHA"));
		// c.setListaPedidos(rs.getArrayList("PEDIDOS"));
		return p;
	}

}
