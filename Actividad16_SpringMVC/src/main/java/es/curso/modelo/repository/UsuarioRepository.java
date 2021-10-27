package es.curso.modelo.repository;

import java.util.List;

import es.curso.modelo.entidad.Usuario;


public interface UsuarioRepository {

	List<Usuario> getAllUsuarios();
	boolean isUsuarioRegistered(String username, String password);
}
