package es.curso.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.model.entity.Videojuego;
import es.curso.model.repository.VideojuegoRepository;
import es.curso.model.service.VideojuegoService;

@Service
public class VideojuegoServiceImpl implements VideojuegoService {

	@Autowired
	private VideojuegoRepository videoRepo;

	@Override
	public List<Videojuego> getAllVideojuegos() {
		return videoRepo.findAll();
	}

	@Override
	public Videojuego findVideojuegoById(int id) {
		return videoRepo.findById(id).orElse(null);
	}

	@Override
	public List<Videojuego> findVideojuegoByNombre(String nombre) {
		return videoRepo.findByNombre(nombre);
	}

	@Override
	public List<Videojuego> findVideojuegoByCompania(String compania) {
		return videoRepo.findByCompania(compania);
	}

	@Override
	@Transactional
	public Videojuego añadirVideojuego(Videojuego videojuego) {
		return videoRepo.save(videojuego);
	}

	@Override
	@Transactional
	public void eliminarVideojuego(int id) {
		videoRepo.deleteById(id);
	}

}
