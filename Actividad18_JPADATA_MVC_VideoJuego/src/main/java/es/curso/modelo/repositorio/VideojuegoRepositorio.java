package es.curso.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.modelo.entidad.Videojuego;

public interface VideojuegoRepositorio extends JpaRepository<Videojuego, Integer> {

}
