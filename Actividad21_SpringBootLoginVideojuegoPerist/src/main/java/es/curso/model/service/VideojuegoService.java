package es.curso.model.service;

import java.util.List;

import es.curso.model.entity.Videojuego;

public interface VideojuegoService {

	List<Videojuego> getAllVideojuegos();

	Videojuego findVideojuegoById(int id);

	void añadirVideojuego(Videojuego videojuego);

	void eliminarVideojuego(int id);
}
