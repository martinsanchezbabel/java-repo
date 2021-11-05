package es.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.curso.model.entity.Videojuego;
import es.curso.model.service.VideojuegoService;

@RestController
public class ControladorVideojuego {

	@Autowired
	private VideojuegoService videoService;

	// Buscar por id
	@GetMapping(path = "videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> getPersona(@PathVariable("id") int id) {
		Videojuego v = videoService.findVideojuegoById(id);
		if (v != null) {
			return new ResponseEntity<Videojuego>(v, HttpStatus.OK);// 200 OK
		} else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);// 404 NOT FOUND
		}
	}

	// Crear videojuego.
	@PostMapping(path = "videojuegos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> altaVideojuego(@RequestBody Videojuego v) {
		videoService.añadirVideojuego(v);
		return new ResponseEntity<Videojuego>(v, HttpStatus.CREATED);// 201 CREATED
	}

	// Listar videojuegos. Tambien por nombre o por compania.
	@GetMapping(path = "videojuegos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> getVideojuego(
			@RequestParam(name = "compania", required = false) String compania,
			@RequestParam(name = "nombre", required = false) String nombre) {

		List<Videojuego> listaVideojuegos = null;
		if (compania == null && nombre == null) {
			listaVideojuegos = videoService.getAllVideojuegos();
		} else if (compania != null) {
			listaVideojuegos = videoService.findVideojuegoByCompania(compania);
		} else {
			listaVideojuegos = videoService.findVideojuegoByNombre(nombre);

		}
		return new ResponseEntity<List<Videojuego>>(listaVideojuegos, HttpStatus.OK);

	}

	// Modificar un videojuego

	@PutMapping(path = "videojuegos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarVideojuego(@PathVariable("id") int id, @RequestBody Videojuego v) {
		v.setId(id);
		Videojuego vUpdate = videoService.añadirVideojuego(v);
		if (vUpdate != null) {
			return new ResponseEntity<Videojuego>(HttpStatus.OK);// 200 OK
		} else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);// 404 NOT FOUND
		}
	}

	@DeleteMapping(path = "videojuegos/{id}")
	public ResponseEntity<Videojuego> borrarVideojuego(@PathVariable int id) {
		videoService.eliminarVideojuego(id);
		return new ResponseEntity<Videojuego>(HttpStatus.OK);// 200 OK
	}
}
