package es.curso.babel.model.service.impl;

import java.util.List;

import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.repository.VideojuegoRepository;
import es.curso.babel.model.repository.impl.VideojuegoRepositoryImpl;
import es.curso.babel.model.service.VideojuegoService;

public class VideojuegoServiceImpl implements VideojuegoService {
	
	private VideojuegoRepository videoRepo = new VideojuegoRepositoryImpl();

	@Override
	public List<Videojuego> getAllVideojuegos() {
		return videoRepo.getAllVideojuegos();
	}

	@Override
	public Videojuego findVideojuegoById(int id) {
		return videoRepo.findVideojuegoById(id);
	}

}
