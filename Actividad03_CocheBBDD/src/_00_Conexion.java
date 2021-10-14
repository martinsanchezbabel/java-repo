
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Clase destinada a establecer una conexion con una BD existente
public class _00_Conexion {

	public static void main(String[] args) {
		//Establecemos una direccion de BD, un usuario y una contrasenia
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = ""; 
		Connection con = null;
		try {
			//Tratamos de conectarnos con la BD gracias a los parametros establecidos anteriormente
			con = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexion con la BD");
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("Se ha establecido la conexion con la Base de datos");
		
		try {
			con.close();//Tratamos de cerrar la conexion con la BD
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexion con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha cerrado la base de datos");

	}

}
