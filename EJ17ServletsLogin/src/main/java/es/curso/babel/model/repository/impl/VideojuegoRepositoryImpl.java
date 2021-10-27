package es.curso.babel.model.repository.impl;

import java.util.LinkedList;
import java.util.List;

import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.repository.VideojuegoRepository;

public class VideojuegoRepositoryImpl implements VideojuegoRepository {
	
	private final List<Videojuego> inMemoryVideojuegos = new LinkedList<Videojuego>();

	public VideojuegoRepositoryImpl() {
		Videojuego videojuego1 = new Videojuego();
		videojuego1.setId(1);
		videojuego1.setNombre("Dark Souls");
		videojuego1.setCompania("From Software");
		videojuego1.setNota(9.5);
		videojuego1.setAuthor("Hidetaka Miyazaki");
		videojuego1.setImagen("imagen1.jpg");
		
		Videojuego videojuego2 = new Videojuego();
		videojuego2.setId(2);
		videojuego2.setNombre("Dark Souls 2");
		videojuego2.setCompania("From Software");
		videojuego2.setNota(7.5);
		videojuego2.setAuthor("Hidetaka Miyazaki");
		videojuego2.setImagen("imagen2.jpg");
		
		Videojuego videojuego3 = new Videojuego();
		videojuego3.setId(3);
		videojuego3.setNombre("Dark Souls 3");
		videojuego3.setCompania("From Software");
		videojuego3.setNota(9);
		videojuego3.setAuthor("Hidetaka Miyazaki");
		videojuego3.setImagen("imagen3.jpg");
		
		Videojuego videojuego4 = new Videojuego();
		videojuego4.setId(4);
		videojuego4.setNombre("Sekiro");
		videojuego4.setCompania("From Software");
		videojuego4.setNota(9.5);
		videojuego4.setAuthor("Hidetaka Miyazaki");
		videojuego4.setImagen("imagen4.jpg");
		
		inMemoryVideojuegos.add(videojuego1);
		inMemoryVideojuegos.add(videojuego2);
		inMemoryVideojuegos.add(videojuego3);
		inMemoryVideojuegos.add(videojuego4);
	}
	
	@Override
	public List<Videojuego> getAllVideojuegos() {
		return inMemoryVideojuegos;
	}

	@Override
	public Videojuego findVideojuegoById(int id) {
		
		for (Videojuego v: inMemoryVideojuegos) {
			if (v.getId() == id) {
				return v;
			}
		}
		
		return null;
	}
	

}
