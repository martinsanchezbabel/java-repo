package es.curso.model.service;

import java.util.List;

import es.curso.model.entity.Usuario;

public interface UsuarioService {

	Usuario isUsuarioRegistered(String username, String password);

	List<String> añadirUsuario(String username, String password);

	Usuario findByUsername(String username);
}
