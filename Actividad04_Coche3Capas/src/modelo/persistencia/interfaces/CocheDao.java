package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coche;

public interface CocheDao {
	boolean alta(Coche p);
	boolean baja(String matricula);
	boolean modificar(Coche p);
	Coche obtener(String matricula);
	List<Coche> listar();
}
