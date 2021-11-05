package es.curso.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.model.entity.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {

	public List<Videojuego> findByNombre(String nombre);

	public List<Videojuego> findByCompania(String compania);
}
