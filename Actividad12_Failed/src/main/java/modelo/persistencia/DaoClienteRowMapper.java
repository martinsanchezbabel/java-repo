package modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import modelo.entidad.Cliente;

@Component
public class DaoClienteRowMapper implements RowMapper<Cliente>{

	
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente c = new Cliente();
		c.setId(rs.getInt("ID"));
		c.setNombre(rs.getString("NOMBRE"));
		c.setEdad(rs.getInt("EDAD"));
		//c.setListaPedidos(rs.getArrayList("PEDIDOS"));
		return c;
	}
}
