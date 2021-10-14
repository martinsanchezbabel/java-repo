
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Clase destinada a borrar un coche de la BD mediante el ID 
public class _06_Borrar {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";

		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);) {

			String sql = "DELETE FROM COCHES WHERE ID=?";

			int id = 2;

			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);

			PreparedStatement sentencia = con.prepareStatement(sql);
			sentencia.setInt(1, id);

			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con exito");
			System.out.println("Registros afectados: " + afectados);
		} catch (SQLException e) {
			System.out.println("Error al borrar el cliente");
			System.out.println(e.getMessage());
		}
	}
}