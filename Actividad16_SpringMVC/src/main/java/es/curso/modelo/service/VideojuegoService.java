package es.curso.modelo.service;

import java.util.List;

import es.curso.modelo.entidad.Videojuego;


public interface VideojuegoService {

	List<Videojuego> getAllVideojuegos();
	Videojuego findVideojuegoById(int id);
}
