package es.curso.modelo.repository;

import java.util.List;

import es.curso.modelo.entidad.Videojuego;


public interface VideojuegoRepository {

	List<Videojuego> getAllVideojuegos();
	Videojuego findVideojuegoById(int id);
}
