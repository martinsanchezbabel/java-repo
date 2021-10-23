package modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.entidad.Pedido;

public class DaoPedidoRowMapper {

	public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pedido p = new Pedido();
		p.setId(rs.getInt("ID"));
		p.setImporte(rs.getDouble("IMPORTE"));
		p.setFecha(rs.getDate("FECHA"));
		//c.setListaPedidos(rs.getArrayList("PEDIDOS"));
		return p;
	}
}
