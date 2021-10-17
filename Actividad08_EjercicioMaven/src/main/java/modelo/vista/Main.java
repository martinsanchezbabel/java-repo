package modelo.vista;

import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);// Creamos el Scanner
		int eleccion = 0;// Inicializaos a 0 la eleccion para que entre en el bucle de abajo y no elija
							// ninguno de los casos propuestos

		// Bucle que se realizara mientras la opcion introducida no sea 5
		do {
			System.out.println(
					"\n Buenas, ¿que desea hacer? \n1: Dar de alta un coche \n2 Dar de baja un coche \n3: Buscar un coche \n4: Modificar un coche. \n5: Imprimir BD en PDF \n6: Salir \n");
			eleccion = sc.nextInt();

			switch (eleccion) {

			// Eleccion de crear un Coche nuevo
			case 1:
				// Crearemos un objeto Coche cuyos atributos seran declarados por el usuario
				// mediante teclado
				Coche coche = new Coche();

				System.out.println("Introduzca la nueva matricula:");
				coche.setMatricula(sc.next());

				System.out.println("Introduzca la marca:");
				coche.setMarca(sc.next());

				System.out.println("Introduzca el modelo:");
				coche.setModelo(sc.next());

				System.out.println("Introduzca los kilometros:");
				coche.setNumKm(sc.nextInt());

				GestorCoche gestorCoche = new GestorCoche();
				boolean alta = gestorCoche.alta(coche);// Se llamara al metodo alta para almacenar el Coche creado junto
														// a sus atributos

				System.out.println("Se ha creado el coche: " + coche);

				break;

			// Eleccion de eliminar un Coche
			case 2:
				// Pediremos al usuario que introduzca la matriucla del coche que desee eliminar
				System.out.println("Introduzca la matricula del coche que desea dar de baja:");
				String matricula = sc.next();

				GestorCoche gc = new GestorCoche();

				boolean baja = gc.baja(matricula); // Se llamara al metodo baja para eliminar al Coche seleccionado
													// junto a sus atributos
				if (baja) {
					System.out.println("El coche se ha dado de baja");
				} else {
					System.out.println("El coche NO se ha dado de baja");
				}
				break;

			// Eleccion de buscar un Coche
			case 3:
				// Pediremos al usuario que introduzca la matriucla del coche que desee buscar
				System.out.println("Introduzca la matricula del coche que desea buscar:");
				GestorCoche gp = new GestorCoche();
				String matriculaBusc = sc.next();
				System.out.println(matriculaBusc);
				Coche coche1 = gp.obtener(matriculaBusc);// Se llamara al metodo obtener para buscar al Coche
															// seleccionado junto a sus atributos
				System.out.println(coche1);// Se muestra el coche por pantalla

				break;

			// Eleccion de modificar un Coche
			case 4:
				// Pediremos al usuario que introduzca la matriucla del coche que desee
				// modificar
				System.out.println("Introduzca la matricula del coche que desea modificar:");
				GestorCoche gp2 = new GestorCoche();
				Coche coche2 = gp2.obtener(sc.next());// Se llamara al metodo obtener para buscar al Coche seleccionado
														// junto a sus atributos, obtenerlos y poder modificar sus datos

				// Se piden los nuevos datos del Coche
				System.out.println("Introduzca la nueva marca:");
				coche2.setMarca(sc.next());
				System.out.println("Introduzca el nuevo modelo:");
				coche2.setModelo(sc.next());
				System.out.println("Introduzca los nuevos kilometros:");
				coche2.setNumKm(sc.nextInt());

				GestorCoche gpMod = new GestorCoche();

				boolean modificar = gpMod.modificar(coche2);// Se llamara al metodo modificar para sustiruir los datos
															// antiguos con los nuevos
				if (modificar) {
					System.out.println("El coche se ha modificado");
				} else {
					System.out.println("El coche NO se ha modificado");
				}
				break;
				
			case 5:
				GestorCoche gcListar = new GestorCoche();
				gcListar.listarPDF();
				break;
			}

		} while (eleccion != 6);// Al elegir la 5ta opcion el programa se detendra
		System.out.println("¡Hasta luego!");
	}

}
