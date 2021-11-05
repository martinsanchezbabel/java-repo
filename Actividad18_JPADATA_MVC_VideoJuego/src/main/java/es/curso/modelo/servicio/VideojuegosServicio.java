package es.curso.modelo.servicio;

import java.util.List;

import es.curso.modelo.entidad.Videojuego;

public interface VideojuegosServicio {

	List<Videojuego> getAllVideojuegos();

	Videojuego findVideojuegoById(int id);

	List<String> addVideojuego(Videojuego videojuego);

	void eliminarVideojuego(int id);
}
