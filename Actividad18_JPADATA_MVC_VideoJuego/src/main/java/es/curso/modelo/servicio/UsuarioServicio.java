package es.curso.modelo.servicio;

import java.util.List;

import es.curso.modelo.entidad.Usuario;

public interface UsuarioServicio {
	List<Usuario> getAllUsuarios();

	boolean isUsuarioRegistred(String username);

	List<String> addUsuario(String username, String password);
}
