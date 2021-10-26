package es.curso.modelo.negocio;

import es.curso.modelo.persistencia.DaoUsuario;

public class GestorUsuario {

	private DaoUsuario usuarioDao;

	public boolean autenticarUsuario(String nombre, String contrasena) {
		usuarioDao = new DaoUsuario();
		return usuarioDao.autenticarUsuario(nombre, contrasena);
	}
}
