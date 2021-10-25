package es.curso.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.cfg.ConfiguracionJPA;
import es.curso.modelo.entidad.Coche;
import es.curso.modelo.negocio.GestorCoche;

public class MainJPA {

	private static ApplicationContext context;
	static Scanner sc = new Scanner(System.in);// Creamos el Scanner

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(ConfiguracionJPA.class);
		/**
		 * context = new AnnotationConfigApplicationContext(ConfiguracionJPA.class);
		 * System.out.println("Inicializando BBDD...");
		 * 
		 * Coche c = context.getBean("coche", Coche.class); c.setMatricula("1234ABC");
		 * c.setMarca("Volkswagen"); c.setModelo("Golf"); c.setNumKm(214000);
		 * 
		 * GestorCoche gc = context.getBean(GestorCoche.class); System.out.println("****
		 * INSERTANDO COCHE ****"); String matricula = gc.insertar(c);
		 * System.out.println("Matricula insertada: " + matricula);
		 * 
		 * System.out.println("**** BUSCAR COCHE ****");
		 * 
		 * System.out.println(gc.buscar(matricula));
		 * 
		 * System.out.println("**** MODIFICAR COCHE ****"); // Esto para modificar solo
		 * los campos que queramos c = context.getBean("coche", Coche.class);
		 * c.setMatricula("1234ABC"); c.setMarca("KIA"); c.setModelo("CEED");
		 * c.setNumKm(90000); gc.modificar(c);
		 * 
		 * System.out.println("**** BUSCAR COCHE ****");
		 * System.out.println(gc.buscar("1234ABC"));
		 * 
		 * System.out.println("**** INSERTANDO COCHE ****"); Coche c2 = new Coche();
		 * c2.setMatricula("5678DEF"); c2.setMarca("Ford"); c2.setModelo("Focus");
		 * c2.setNumKm(300000);
		 * 
		 * gc.insertar(c2);
		 * 
		 * System.out.println("**** LISTAR COCHES ****"); List<Coche> lista =
		 * gc.listar(); // Con una funcion lambda podemos recorrer todas las peliculas
		 * lista.forEach((v) -> System.out.println(v));
		 * 
		 * System.out.println("**** BORRAR COCHE ****"); gc.borrar("1234ABC");
		 * 
		 * System.out.println("**** LISTAR COCHES ****"); lista = gc.listar();
		 * lista.forEach((v) -> System.out.println(v));
		 **/

		int eleccion = 0;// Inicializaos a 0 la eleccion para que entre en el bucle de abajo y no elija
							// ninguno de los casos propuestos

		// Bucle que se realizara mientras la opcion introducida no sea 5
		do {
			System.out.println("\n Buenas, ¿que desea hacer? \n1: Dar de alta un coche \n2: Dar de baja un coche "
					+ "\n3: Buscar un coche \n4: Modificar un coche. \n5: Listar coches \n6: Salir \n");
			eleccion = sc.nextInt();

			switch (eleccion) {

			// Eleccion de crear un Coche nuevo
			case 1:
				anadirCoche();
				break;

			// Eleccion de eliminar un Coche
			case 2:
				borrarCoche();
				break;

			// Eleccion de buscar un Coche
			case 3:
				buscarCoche();
				break;

			// Eleccion de modificar un Coche
			case 4:
				modificarCoche();
				break;

			case 5:
				listarCoche();
				break;
			}

		} while (eleccion != 6);// Al elegir la 5ta opcion el programa se detendra
		System.out.println("¡Hasta luego!");
	}

	public static void anadirCoche() {
		// Crearemos un objeto Coche cuyos atributos seran declarados por el usuario
		// mediante teclado
		Coche c = context.getBean("coche", Coche.class);
		System.out.println("Introduzca la nueva matricula:");
		c.setMatricula(sc.next());

		System.out.println("Introduzca la marca:");
		c.setMarca(sc.next());

		System.out.println("Introduzca el modelo:");
		c.setModelo(sc.next());

		System.out.println("Introduzca los kilometros:");
		c.setNumKm(sc.nextInt());

		GestorCoche gc = context.getBean(GestorCoche.class);
		gc.insertar(c);// Se llamara al metodo alta para almacenar el Coche creado junto
							// a sus atributos

		System.out.println("Se ha creado el coche: " + c);
	}

	public static void borrarCoche() {
		// Pediremos al usuario que introduzca la matriucla del coche que desee eliminar
		System.out.println("Introduzca la matricula del coche que desea dar de baja:");
		String matricula = sc.next();
		GestorCoche gc = context.getBean(GestorCoche.class);
		gc.borrar(matricula); // Se llamara al metodo baja para eliminar al Coche seleccionado
								// junto a sus atributos
		System.out.println("El coche se ha dado de baja");
	}

	public static void buscarCoche() {
		// Pediremos al usuario que introduzca la matriucla del coche que desee buscar
		System.out.println("Introduzca la matricula del coche que desea buscar:");
		String matriculaBusc = sc.next();
		System.out.println(matriculaBusc);
		GestorCoche gc = context.getBean(GestorCoche.class);
		Coche coche1 = gc.buscar(matriculaBusc);// Se llamara al metodo obtener para buscar al Coche
												// seleccionado junto a sus atributos
		System.out.println(coche1);// Se muestra el coche por pantalla

	}

	public static void modificarCoche() {
		// Pediremos al usuario que introduzca la matriucla del coche que desee
		// modificar
		System.out.println("Introduzca la matricula del coche que desea modificar:");
		GestorCoche gp2 = new GestorCoche();
		Coche coche2 = gp2.buscar(sc.next());// Se llamara al metodo obtener para buscar al Coche seleccionado
												// junto a sus atributos, obtenerlos y poder modificar sus datos

		// Se piden los nuevos datos del Coche
		System.out.println("Introduzca la nueva marca:");
		coche2.setMarca(sc.next());
		System.out.println("Introduzca el nuevo modelo:");
		coche2.setModelo(sc.next());
		System.out.println("Introduzca los nuevos kilometros:");
		coche2.setNumKm(sc.nextInt());
		GestorCoche gc = context.getBean(GestorCoche.class);
		gc.modificar(coche2);// Se llamara al metodo modificar para sustiruir los datos

		System.out.println("El coche se ha modificado");

	}

	public static void listarCoche() {
		GestorCoche gc = context.getBean(GestorCoche.class);
		gc.listar();
	}
}
