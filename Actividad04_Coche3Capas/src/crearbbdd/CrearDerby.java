package crearbbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Esta clase SOLO la debemos ejecutar en caso de que queramos usar una bbdd
//derby embebida y no la tengamos. 
public class CrearDerby {

	private Connection conexion;

	public static void main(String[] args) {
		CrearDerby cd = new CrearDerby();
		cd.crearBBDD();
	}
	
	public boolean abrirConexion(){
		try {
			conexion = DriverManager.getConnection("jdbc:derby:bbdd;create=true");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean crearBBDD() {
		if(!abrirConexion()){
			return false;
		}
		boolean estaCreada = true;
		
		try {
			//Con esto creamos una bbdd enbebida dentro del proyecto 
			Statement state = conexion.createStatement();
			state.execute("create table coches(id INT NOT NULL "
					+ "GENERATED ALWAYS AS IDENTITY (Start with 1, Increment by 1), " 
					+ "matricula varchar(20) NOT NULL, "
					+ "marca varchar(20) NOT NULL, " 
					+ "modelo varchar(20) NOT NULL, " 
					+ "numKm int NOT NULL,"
                    + "CONSTRAINT primary_key PRIMARY KEY (matricula)"
                    + ")");
			
		} catch (SQLException e) {
			System.out.println("alta -> Error al crear: ");
			estaCreada = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return estaCreada;
	}
}
