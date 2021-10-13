package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.interfaces.CocheDao;

public class CocheDaoDerby implements CocheDao{

	private Connection conexion;
	
	//Bloque estatico, los bloques estaticos son ejecutados
	//por java JUSTO ANTES de ejecutar el metodo main()
	//java busca todos los metodos staticos que haya en el programa
	//y los ejecuta
	static{
		try {
			//Esta sentencia carga del jar que hemos importado
			//una clase que se llama Driver que esta en el paqueta
			//com.mysql.jdbc. Esta clase se carga previamente en
			//java para m�s adelante ser llamada
			//Si fuera NO embedded, seria "org.apache.derby.jdbc.Driver"
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			System.out.println("Driver cargado");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver NO cargado");
			e.printStackTrace();
		}
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
	
	
	
	
	@Override
	public boolean alta(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into coches (MATRICULA,MARCA,MODELO,NUMKM) "
				+ " values(?,?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setInt(4, c.getNumKm());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				alta = false;
			else
				alta = true;
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + c);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}

	@Override
	public boolean baja(String matricula) {
		if(!abrirConexion()){
			return false;
		}
		
		boolean borrado = false;
		String query = "delete from coches where matricula = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ps.setString(1, matricula);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
			else
				borrado = true;
		} catch (SQLException e) {
			System.out.println("baja -> No se ha podido dar de baja"
					+ " la matricula " + matricula);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado; 
	}

	@Override
	public boolean modificar(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean modificado = true;
		String query = "update coches set MARCA=?, MODELO=?, "
				+ "NUMKM=? WHERE MATRICULA=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setInt(3, c.getNumKm());
			ps.setString(4, c.getMatricula());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				modificado = false;
			else
				modificado = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("modificar -> error al modificar el "
					+ " coche " + c);
			modificado = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return modificado;
	}

	@Override
	public Coche obtener(String matricula) {
		if(!abrirConexion()){
			return null;
		}		
		Coche coche = null;
		
		String query = "select matricula, marca, modelo, numKm from coches"
				+ "where matricula = '?'";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, matricula);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				coche = new Coche();
				coche.setMatricula(rs.getString(1));
				coche.setMarca(rs.getString(2));
				coche.setModelo(rs.getString(3));
				coche.setNumKm(rs.getInt(4));
				
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el "
					+ "coche con matricula " + matricula);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return coche;
	}

	@Override
	public List<Coche> listar() {
		if(!abrirConexion()){
			return null;
		}		
		List<Coche> listaCoches = new ArrayList<>();
		
		String query = "select MATRICULA,MARCA,MODELO,NUMKM from coches";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Coche coche = new Coche();
				coche.setMatricula(rs.getString(1));
				coche.setMarca(rs.getString(2));
				coche.setModelo(rs.getString(3));
				coche.setNumKm(rs.getInt(4));
				
				listaCoches.add(coche);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las "
					+ "personas");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return listaCoches;
	}

	
}
