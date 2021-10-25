package es.curso.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.cfg.ConfiguracionJPA;
import es.curso.modelo.entidad.Coche;
import es.curso.modelo.negocio.GestorCoche;

public class MainJPA2 {
	private static ApplicationContext context;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		context = new AnnotationConfigApplicationContext(ConfiguracionJPA.class);
		System.out.println("Inicializando BBDD...");

		Coche c = context.getBean("coche", Coche.class);
		c.setMatricula("1234ABC");
		c.setMarca("Volkswagen");
		c.setModelo("Golf");
		c.setNumKm(214000);

		GestorCoche gc = context.getBean(GestorCoche.class);
		System.out.println("****INSERTANDO COCHE ****");
		String matricula = gc.insertar(c);
		System.out.println("Matricula insertada: " + matricula);

		System.out.println("**** BUSCAR COCHE ****");

		System.out.println(gc.buscar(matricula));

		System.out.println("**** MODIFICAR COCHE ****"); // Esto para modificar solo los campos que queramos
		c = context.getBean("coche", Coche.class);
		c.setMatricula("1234ABC");
		c.setMarca("KIA");
		c.setModelo("CEED");
		c.setNumKm(90000);
		gc.modificar(c);

		System.out.println("**** BUSCAR COCHE ****");
		System.out.println(gc.buscar("1234ABC"));

		System.out.println("**** INSERTANDO COCHE ****");
		Coche c2 = new Coche();
		c2.setMatricula("5678DEF");
		c2.setMarca("Ford");
		c2.setModelo("Focus");
		c2.setNumKm(300000);

		gc.insertar(c2);

		System.out.println("**** LISTAR COCHES ****");
		List<Coche> lista = gc.listar(); // Con una funcion lambda podemos recorrer todas las peliculas
		lista.forEach((v) -> System.out.println(v));

		System.out.println("**** BORRAR COCHE ****");
		gc.borrar("1234ABC");

		System.out.println("**** LISTAR COCHES ****");
		lista = gc.listar();
		lista.forEach((v) -> System.out.println(v));

	}

}
