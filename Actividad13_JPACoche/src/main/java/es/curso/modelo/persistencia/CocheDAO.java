package es.curso.modelo.persistencia;

import java.util.List;

import es.curso.modelo.entidad.Coche;

public interface CocheDAO {
	
	String insertar(Coche c);	
	Coche modificar(Coche c);	
	String borrar(String matricula);	
	Coche buscar(String matricula);	
	List<Coche> listar();
}
