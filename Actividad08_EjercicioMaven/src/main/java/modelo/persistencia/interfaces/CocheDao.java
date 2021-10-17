package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coche;

//Interface creada para que todos los objetos que la implementen sean obligados a usar los metodos declarados
public interface CocheDao {
	boolean alta(Coche p);

	boolean baja(String matricula);

	boolean modificar(Coche p);

	Coche obtener(String matricula);

	List<Coche> listarPDF();
}
