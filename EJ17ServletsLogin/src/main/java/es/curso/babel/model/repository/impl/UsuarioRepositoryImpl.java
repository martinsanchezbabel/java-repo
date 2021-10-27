package es.curso.babel.model.repository.impl;

import java.util.LinkedList;
import java.util.List;

import es.curso.babel.model.entity.Usuario;
import es.curso.babel.model.repository.UsuarioRepository;

public class UsuarioRepositoryImpl implements UsuarioRepository {
	
	private final List<Usuario> inMemoryUsuarios = new LinkedList<Usuario>();


	public UsuarioRepositoryImpl() {
		Usuario usuario1 = new Usuario();
		usuario1.setUsername("roger");
		usuario1.setPassword("1234qwerty");
		
		Usuario usuario2 = new Usuario();
		usuario2.setUsername("angel");
		usuario2.setPassword("1233qwerty");
		
		inMemoryUsuarios.add(usuario1);
		inMemoryUsuarios.add(usuario2);
	}

	@Override
	public boolean isUsuarioRegistered(String username, String password) {
		
		for (Usuario u: inMemoryUsuarios) {
			if (username.equals(u.getUsername()) &&
					password.equals(u.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return inMemoryUsuarios;
	}

}
