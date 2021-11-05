package es.curso.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.model.entity.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {
}
