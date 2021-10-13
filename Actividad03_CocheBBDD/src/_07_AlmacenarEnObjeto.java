
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Coche;

public class _07_AlmacenarEnObjeto {
	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";

		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHES");
			ResultSet rs = sentencia.executeQuery();
			
			List<Coche> listadoPersonas = new ArrayList<Coche>();
			while (rs.next()) {
				Coche c = new Coche();
				c.setId(rs.getInt("ID"));
				c.setMarca(rs.getString("MARCA"));
				c.setModelo(rs.getString("MODELO"));
				c.setNumKm(rs.getInt("NUMKM"));
				
				listadoPersonas.add(c);
			}

			System.out.println(listadoPersonas);
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}
	}
}