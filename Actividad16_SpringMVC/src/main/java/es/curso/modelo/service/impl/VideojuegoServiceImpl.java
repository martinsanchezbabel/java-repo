package es.curso.modelo.service.impl;

import java.util.List;

import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.repository.VideojuegoRepository;
import es.curso.modelo.repository.impl.VideojuegoRepositoryImpl;
import es.curso.modelo.service.VideojuegoService;

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
