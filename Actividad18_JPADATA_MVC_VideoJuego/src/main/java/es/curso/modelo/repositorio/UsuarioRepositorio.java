package es.curso.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.modelo.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

}
