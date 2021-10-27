package es.curso.modelo.service.impl;

import java.util.List;

import es.curso.modelo.entidad.Usuario;
import es.curso.modelo.repository.UsuarioRepository;
import es.curso.modelo.repository.impl.UsuarioRepositoryImpl;
import es.curso.modelo.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository userRepo = new UsuarioRepositoryImpl();

	@Override
	public List<Usuario> getAllUsuarios() {
		return userRepo.getAllUsuarios();
	}

	@Override
	public boolean isUsuarioRegistered(String username, String password) {
		return userRepo.isUsuarioRegistered(username, password);
	}

}
