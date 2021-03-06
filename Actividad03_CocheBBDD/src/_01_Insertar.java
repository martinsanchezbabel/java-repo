import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Clase destinada a insertar datos sobre un coche nuevo en la BD
public class _01_Insertar {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";

		Connection con = null;
		try {
			// Tratamos de conectar con la BD
			con = DriverManager.getConnection(cadenaConexion, user, pass);
			// Establecemos los parametros del coche nuevo
			String marca = "Volkswagen";
			String modelo = "Polo";
			int numKm = 500000;

			// Realizamos la query para la introduccion de los datos creados anteriormente
			String sql = "INSERT INTO COCHES " + "(MARCA, MODELO, NUMKM) " + "VALUES ('" + marca + "', '" + modelo
					+ "', '" + numKm + "');";
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);

			Statement sentencia;
			sentencia = con.createStatement();
			int filasAfectadas = sentencia.executeUpdate(sql);

			System.out.println("Sentencia SQL ejecutada con Exito");
			System.out.println("Registros afectados: " + filasAfectadas);
		} catch (SQLException e) {
			System.out.println("Error al a?adir un nuevo coche");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();// Tratamos de cerrar a conexion con la BD
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

	}

}