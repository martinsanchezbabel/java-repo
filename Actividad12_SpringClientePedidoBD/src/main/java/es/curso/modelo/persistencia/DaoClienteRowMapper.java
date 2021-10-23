package es.curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.entidades.Pelicula;

/**
 * Esta clase se encarga de conviertir automatimente los registros devueltos
 * por JdbcTemplate a objetos
 */
@Component
public class DaoClienteRowMapper implements RowMapper<Cliente>{

	
	//Spring le pasara automaticamente el ResultSet, y la fila del ResultSet
	//con la que esta trabajando
	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente c = new Cliente();
		c.setNombre(rs.getString("NOMBRE"));
		c.setEdad(rs.getInt("EDAD"));
		//c.setListaPedidos(rs.getArrayList("PEDIDOS"));
		return c;
	}

}
