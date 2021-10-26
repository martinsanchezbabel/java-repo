package es.curso.modelo.negocio;

import java.util.List;

import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.persistencia.DaoVideoJuego;

public class GestorVideojuego {

	private DaoVideoJuego videojuegoDao;

	public List<Videojuego> listar() {
		videojuegoDao = new DaoVideoJuego();
		return videojuegoDao.listar();
	}

	public Videojuego obtener(int id) {
		videojuegoDao = new DaoVideoJuego();
		return videojuegoDao.obtener(id);
	}
}
