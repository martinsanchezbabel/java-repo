
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Clase destinada a insertar datos sobre un coche nuevo en la BD
public class _02_InsertarPreparedStatement {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";
		// Tratamos de conectar con la BD
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)) {

			String sql = "INSERT INTO COCHES (MARCA, MODELO, NUMKM) VALUES (?, ?, ?)";
			// Establecemos los parametros del coche nuevo
			String marca = "Volkswagen";
			String modelo = "Golf";
			int numKm = 212000;

			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);

			PreparedStatement sentencia;
			sentencia = con.prepareStatement(sql);// Realizamos la query con prepared para la introduccion de los datos
													// creados anteriormente

			sentencia.setString(1, marca);
			sentencia.setString(2, modelo);//
			sentencia.setInt(3, numKm);

			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con exito");
			System.out.println("Registros afectados: " + afectados);

		} catch (SQLException e) {
			System.out.println("Error al añadir un nuevo coche");
			System.out.println(e.getMessage());
		}
	}

}