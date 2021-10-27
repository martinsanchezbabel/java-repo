package es.curso.modelo.service;

import java.util.List;

import es.curso.modelo.entidad.Usuario;

public interface UsuarioService {

	List<Usuario> getAllUsuarios();
	boolean isUsuarioRegistered(String username, String password);
}
