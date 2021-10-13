
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _05_Modificar {

	public static void main(String[] args) {		
		String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
		String user = "root";
		String pass = "";
			
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			
			String sql = "update coches set MARCA=?, MODELO=?, NUMKM=? WHERE ID=?";
			
			String marca = "Audi";
			String modelo = "A3";
			int numKm = 120000;
			int id = 2;
			
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);
			
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setString(1, marca);
			sentencia.setString(2, modelo);
			sentencia.setInt(3, numKm);
			sentencia.setInt(4, id);
			
			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con exito");
			System.out.println("Registros afectados: "+afectados);
		} catch (SQLException e) {
			System.out.println("Error al añadir nuevo cliente");
			System.out.println(e.getMessage());
		}		
	}
}
