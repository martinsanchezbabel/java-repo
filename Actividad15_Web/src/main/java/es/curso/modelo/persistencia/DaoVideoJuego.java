package es.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import es.curso.modelo.entidad.Videojuego;

public class DaoVideoJuego {
	public DaoVideoJuego() {

	}

	public List<Videojuego> listar() {
		List<Videojuego> listaVideojuego = new ArrayList<Videojuego>();

		Videojuego v = new Videojuego();
		v.setId(1);
		v.setCompania("Capcom");
		v.setNombre("MH3");
		v.setNotaMedia(8.5);

		listaVideojuego.add(v);

		v = new Videojuego();
		v.setId(2);
		v.setCompania("EA");
		v.setNombre("FIFA22");
		v.setNotaMedia(1.2);

		listaVideojuego.add(v);

		return listaVideojuego;
	}

	public Videojuego obtener(int id) {

		if (id == 1) {
			Videojuego v = new Videojuego();
			v.setId(1);
			v.setCompania("Capcom");
			v.setNombre("MH3");
			v.setNotaMedia(8.5);
			return v;
		} else if (id == 2) {
			Videojuego v = new Videojuego();
			v = new Videojuego();
			v.setId(2);
			v.setCompania("EA");
			v.setNombre("FIFA22");
			v.setNotaMedia(1.2);

			return v;
		} else {
			return null;
		}
	}
}
