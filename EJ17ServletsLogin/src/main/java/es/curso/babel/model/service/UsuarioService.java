package es.curso.babel.model.service;

import java.util.List;

import es.curso.babel.model.entity.Usuario;

public interface UsuarioService {

	List<Usuario> getAllUsuarios();
	boolean isUsuarioRegistered(String username, String password);
}
