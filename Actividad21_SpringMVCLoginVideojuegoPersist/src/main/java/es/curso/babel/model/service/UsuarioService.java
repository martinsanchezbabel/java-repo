package es.curso.babel.model.service;

import java.util.List;

import es.curso.babel.model.entity.Usuario;

public interface UsuarioService {

	Usuario isUsuarioRegistered(String username, String password);
	List<String> añadirUsuario(String username, String password);
	Usuario findByUsername(String username);
}
