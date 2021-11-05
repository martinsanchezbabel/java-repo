package es.curso.modelo.servicio.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.repositorio.VideojuegoRepositorio;
import es.curso.modelo.servicio.VideojuegosServicio;

@Service
public class VideojuegoServicioImpl implements VideojuegosServicio {

	@Autowired
	private VideojuegoRepositorio videoRepo;

	@Override
	public List<Videojuego> getAllVideojuegos() {
		return videoRepo.findAll();
	}

	@Override
	public Videojuego findVideojuegoById(int id) {
		return videoRepo.findById(id).orElse(null);
	}

	@Override
	public List<String> addVideojuego(Videojuego videojuego) {
		List<String> messages = new LinkedList<>();
		if (videojuego == null)
			messages.add("El videojuego no puede ser nulo");
		if (videojuego.getAuthor() == "")
			messages.add("El videojuego debe tener author");
		if (videojuego.getCompania() == "")
			messages.add("El videojuego debe tener compania");
		if (videojuego.getNombre() == "")
			messages.add("El videojuego debe tener un nombre");
		if (videojuego.getNota() < 0 || videojuego.getNota() > 10)
			messages.add("La nota del videojuego" + " debe estar entre 1-10");
		if (messages.size() == 0) {
			videoRepo.save(videojuego);
			messages.add("Alta correcta");
		}

		return messages;
	}

	@Override
	public void eliminarVideojuego(int id) {
		videoRepo.deleteById(id);
	}

}
