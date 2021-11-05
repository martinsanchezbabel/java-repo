package es.cliente;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import es.cliente.model.entity.Videojuego;
import es.cliente.servicio.ServicioProxyVideojuego;

@SpringBootApplication
public class Actividad23RestVideojuegoClienteApplication implements CommandLineRunner {

	@Autowired
	private ServicioProxyVideojuego spv;

	@Autowired
	private ApplicationContext context;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Actividad23RestVideojuegoClienteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("*********** ALTA PERSONA ***************");
		Videojuego videojuego = new Videojuego();
		videojuego.setNombre("FIFA");
		videojuego.setCompania("EA");
		videojuego.setAuthor("EA");
		videojuego.setNota(6);
		videojuego.setPrice(70);

		Videojuego vAlta = spv.alta(videojuego);
		System.out.println("run -> Videjouego dado de alta " + vAlta);

		System.out.println("************ GET VIDEOJUEGO ***************");
		videojuego = spv.obtener(vAlta.getId());
		System.out.println("run -> Videjouego con id 1: " + videojuego);

		System.out.println("************ GET VIDEOJUEGO ERRONEO ***************");
		videojuego = spv.obtener(20);
		System.out.println("run -> Videjouego con id 20: " + videojuego);

		System.out.println("********* MODIFICAR VIDEOJUEGO *************");
		Videojuego vModificar = new Videojuego();
		vModificar.setPrice(50);
		vModificar.setNota(8);
		boolean modificado = spv.modificar(vModificar);
		System.out.println("run -> videojuego modificado? " + modificado);

		System.out.println("********* MODIFICAR VIDEOJUEGO ERRONEO*************");
		vModificar.setPrice(50);
		vModificar.setNota(8);
		vModificar.setId(20);
		modificado = spv.modificar(vModificar);
		System.out.println("run -> videojuego modificado? " + modificado);

		System.out.println("********** BORRAR VIDEOJUEGO **************");
		boolean borrado = spv.borrar(vAlta.getId());
		System.out.println("run -> Videojuego con id 5 borrada? " + borrado);

		System.out.println("******** BORRAR VIDEOJUEGO ERRONEO *******");
		borrado = spv.borrar(20);
		System.out.println("run -> Videojuego con id 20 borrado? " + borrado);

		System.out.println("********** LISTAR VIDEOJUEGOS ***************");
		List<Videojuego> listaVideojuegos = spv.listar(null);
		// Recorremos la lista y la imprimimos con funciones lambda
		// Tambien podriamos haber usado un for-each clasico de java
		listaVideojuegos.forEach((v) -> System.out.println(v));

		System.out.println("******* LISTAR VIDEOJUEGOS POR NOMBRE *******");
		listaVideojuegos = spv.listar("FIFA");
		listaVideojuegos.forEach((v) -> System.out.println(v));

		System.out.println("******************************************");
		System.out.println("******** Parando el cliente REST *********");
		// Mandamos parar nuestra aplicacion Spring Boot
		// pararAplicacion();
	}
	/**
	 * public void pararAplicacion() { SpringApplication.exit(context, () -> 0); }
	 **/
}
