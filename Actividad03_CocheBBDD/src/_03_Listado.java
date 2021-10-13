
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_Listado {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";
		
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHES");
			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("ID"));
				System.out.print(" - "); 
				System.out.print(rs.getString("MARCA"));
				System.out.print(" - "); 
				System.out.print(rs.getString("MODELO"));
				System.out.print(" - "); 
				System.out.print(rs.getInt("NUMKM"));
				System.out.println(); 
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}		
	}
}