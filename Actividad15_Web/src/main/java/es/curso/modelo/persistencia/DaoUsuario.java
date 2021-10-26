package es.curso.modelo.persistencia;

import es.curso.modelo.entidad.Usuario;

public class DaoUsuario {

	public boolean autenticarUsuario(String nombre, String contrasena) {
		System.out.println(nombre + " " + contrasena);
		if (nombre.equals("usuario") && contrasena.equals("contrasena")) {
			Usuario u = new Usuario();
			u.setNombre("usuario");
			u.setContrasena("contrasena");
			return true;
		} else {
			return false;
		}
	}
}
