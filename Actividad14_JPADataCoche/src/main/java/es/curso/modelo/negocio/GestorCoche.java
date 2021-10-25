package es.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.modelo.persistencia.CocheDaoJPA;
import es.curso.modelo.entidad.Coche;
//import modelo.persistencia.PersonaDaoDerby;
//Aqu� irian todas las reglas de negocio de nuestra aplicacion, se aplicarian
//antes de llamar a la BBDD. Por ejemplo si la persona tiene que tener al
//menos un nombre con 3 caracteres 

@Service
public class GestorCoche {

	// Aqui podemos jugar con cambiar el dao que queremos usar
	// podemos usar PersonaDaoDerby o PersonaDaoMySql
	// Gracias a las interfaces solo tenemos que cambiar el objeto
	@Autowired
	private CocheDaoJPA cocheDao;

	/**
	 * Metodo para dar de alta un coche
	 * 
	 * @param c
	 * @return true si el coche se dio de alta false si no
	 */
	@Transactional
	public String insertar(Coche c) {
		// aplicamos la regla de negocio
		String alta = "El coche no cumple los requisitos MATRICULA DE 7 CARACTERES Y TODOS LOS CAMPOS RELLENOS";
		if (c.getMatricula().length() == 7 && !c.getMarca().isEmpty() && !c.getModelo().isEmpty()
				&& !c.getMatricula().isEmpty()) {
			alta = cocheDao.insertar(c);
			return alta;
		}
		return alta;
	}

	/**
	 * Metodo para dar de baja un coche
	 * 
	 * @param matricula
	 */
	@Transactional
	public void borrar(String matricula) {
		String baja = cocheDao.borrar(matricula);
	}

	/**
	 * Metodo para modificar los datos de un coche
	 * 
	 * @param c
	 * @return
	 */
	@Transactional
	public Coche modificar(Coche c) {
		// aplicamos la regla de negocio
		Coche modificada = null;
		if (c.getMatricula().length() == 7 && !c.getMarca().isEmpty() && !c.getModelo().isEmpty()
				&& !c.getMatricula().isEmpty()) {
			modificada = cocheDao.modificar(c);
			return modificada;
		}
		return modificada;
	}

	/**
	 * Metodo para obtener los datos de un coche
	 * 
	 * @param matricula
	 * @return
	 */
	public Coche buscar(String matricula) {
		Coche coche = cocheDao.buscar(matricula);
		return coche;
	}

	/**
	 * Metodo para obtener los datos de todos los coches
	 * 
	 * @return una lista con los datos de todos los coches
	 */
	public List<Coche> listar() {
		return cocheDao.listar();
	}

}
