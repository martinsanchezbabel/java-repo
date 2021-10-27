package es.curso.modelo.repository.impl;

import java.util.LinkedList;
import java.util.List;

import es.curso.modelo.entidad.Usuario;
import es.curso.modelo.repository.UsuarioRepository;

public class UsuarioRepositoryImpl implements UsuarioRepository {
	
	private final List<Usuario> inMemoryUsuarios = new LinkedList<Usuario>();


	public UsuarioRepositoryImpl() {
		Usuario usuario1 = new Usuario();
		usuario1.setUsername("martin");
		usuario1.setPassword("1234");
		
		Usuario usuario2 = new Usuario();
		usuario2.setUsername("usuario");
		usuario2.setPassword("contrasena");
		
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
