package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
//import modelo.persistencia.PersonaDaoDerby;
import modelo.persistencia.CocheDaoMySql;
import modelo.persistencia.interfaces.CocheDao;

//Aqu� irian todas las reglas de negocio de nuestra aplicacion, se aplicarian
//antes de llamar a la BBDD. Por ejemplo si la persona tiene que tener al
//menos un nombre con 3 caracteres 

public class GestorCoche {

	// Aqui podemos jugar con cambiar el dao que queremos usar
	// podemos usar PersonaDaoDerby o PersonaDaoMySql
	// Gracias a las interfaces solo tenemos que cambiar el objeto
	CocheDao cocheDao = new CocheDaoMySql();

	/**
	 * Metodo para dar de alta un coche
	 * 
	 * @param c
	 * @return true si el coche se dio de alta false si no
	 */
	public boolean alta(Coche c) {
		// aplicamos la regla de negocio
		if (c.getMatricula().length() == 7 && !c.getMarca().isEmpty() && !c.getModelo().isEmpty()
				&& !c.getMatricula().isEmpty()) {
			boolean alta = cocheDao.alta(c);
			return alta;
		}
		return false;
	}

	/**
	 * Metodo para dar de baja un coche
	 * 
	 * @param matricula
	 * @return true si el coche se dio de baja false si no
	 */
	public boolean baja(String matricula) {
		boolean baja = cocheDao.baja(matricula);
		return baja;
	}

	/**
	 * Metodo para modificar los datos de un coche
	 * 
	 * @param c
	 * @return
	 */
	public boolean modificar(Coche c) {
		// aplicamos la regla de negocio
		if (c.getMatricula().length() == 7 && !c.getMarca().isEmpty() && !c.getModelo().isEmpty()
				&& !c.getMatricula().isEmpty()) {
			boolean modificada = cocheDao.modificar(c);
			return modificada;
		}
		return false;
	}

	/**
	 * Metodo para obtener los datos de un coche
	 * 
	 * @param matricula
	 * @return
	 */
	public Coche obtener(String matricula) {
		Coche coche = cocheDao.obtener(matricula);
		return coche;
	}

	/**
	 * Metodo para obtener los datos de todos los coches
	 * 
	 * @return una lista con los datos de todos los coches
	 */
	public List<Coche> listar() {
		List<Coche> listaCoches = cocheDao.listar();
		return listaCoches;
	}

}
