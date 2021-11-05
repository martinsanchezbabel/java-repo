package es.curso.modelo.servicio.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidad.Usuario;
import es.curso.modelo.repositorio.UsuarioRepositorio;
import es.curso.modelo.servicio.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioRepositorio userRepo;

	@Override
	public List<Usuario> getAllUsuarios() {
		return userRepo.findAll();
	}

	@Override
	public boolean isUsuarioRegistred(String username) {
		Usuario usuario = userRepo.findById(username).orElse(null);
		if (usuario != null) {
			if (usuario.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<String> addUsuario(String username, String password) {
		List<String> messages = new LinkedList<String>();

		if (username == null) {
			messages.add("El nombre no puede estar vac�o");
		}

		if (password == null) {
			messages.add("La password no puede estar vac�a");
		}

		if (username.length() < 5) {
			messages.add("El n�mero de car�cteres de usuario debe ser mayor a 5");
		}

		if (password.length() < 7) {
			messages.add("La contrase�a debe tener un m�nimo de 7 car�cteres");
		}

		if (messages.size() == 0) {
			Usuario usuario = new Usuario();
			usuario.setUsername(username);
			usuario.setPassword(password);
			userRepo.save(usuario);
			messages.add("Usuario registrado correctamente");
		}

		return messages;
	}

}
