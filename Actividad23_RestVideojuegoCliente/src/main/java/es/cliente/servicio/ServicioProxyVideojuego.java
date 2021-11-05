package es.cliente.servicio;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import es.cliente.model.entity.Videojuego;

@Service
public class ServicioProxyVideojuego {

	public static final String URL = "http://localhost:8080/videojuego/";

	@Autowired
	private RestTemplate restTemplate;

	public Videojuego obtener(int id) {
		try {
			ResponseEntity<Videojuego> re = restTemplate.getForEntity(URL + id, Videojuego.class);
			HttpStatus hs = re.getStatusCode();
			if (hs == HttpStatus.OK) {
				return re.getBody();
			} else {
				System.out.println("Respuesta no completada.");
				return null;
			}

		} catch (HttpClientErrorException e) {
			System.out.println("obtener -> El videojuego NO se ha encontrado, id: " + id);
			System.out.println("obtener -> Codigo de respuesta: " + e.getStatusCode());
			return null;
		}
	}

	public Videojuego alta(Videojuego v) {
		try {
			ResponseEntity<Videojuego> re = restTemplate.postForEntity(URL, v, Videojuego.class);
			System.out.println("alta -> Codigo de respuesta " + re.getStatusCode());
			return re.getBody();
		} catch (HttpClientErrorException e) {
			System.out.println("obtener -> El videojuego NO se ha dado de alta : " + v);
			System.out.println("obtener -> Codigo de respuesta: " + e.getStatusCode());
			return null;
		}
	}

	public boolean modificar(Videojuego v) {
		try {
			restTemplate.put(URL + v.getId(), v, Videojuego.class);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("obtener -> El videojuego NO se ha modificado : " + v);
			System.out.println("obtener -> Codigo de respuesta: " + e.getStatusCode());
			return false;
		}
	}

	public boolean borrar(int id) {
		try {
			restTemplate.delete(URL + id);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("obtener -> El videojuego NO se ha borrado, id : " + id);
			System.out.println("obtener -> Codigo de respuesta: " + e.getStatusCode());
			return false;
		}

	}

	public List<Videojuego> listar(String nombre) {
		String queryParams = "";
		if (nombre != null) {
			queryParams = "?nombre=" + nombre;
		}
		try {
			ResponseEntity<Videojuego[]> re = restTemplate.getForEntity(URL + queryParams, Videojuego[].class);
			Videojuego[] arrayVideojuegos = re.getBody();
			return Arrays.asList(arrayVideojuegos);
		} catch (HttpClientErrorException e) {
			System.out.println("listar -> Error al obtener la lista de videojuegos");
			System.out.println("listar -> Codigo de respuesta: " + e.getStatusCode());
			return null;
		}
	}
}
