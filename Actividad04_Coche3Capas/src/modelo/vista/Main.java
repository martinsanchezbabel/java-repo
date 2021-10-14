package modelo.vista;

import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int eleccion = 0;

		do {
			System.out.println(
					"\n Buenas, ¿que desea hacer? \n1: Dar de alta un coche \n2 Dar de baja un coche \n3: Buscar un coche \n4: Modificar un coche. \n5: Salir \n");
			eleccion = sc.nextInt();

			switch (eleccion) {

			case 1:
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
				boolean alta = gestorCoche.alta(coche);

				System.out.println("Se ha creado el coche: " + coche);

				break;

			case 2:
				System.out.println("Introduzca la matricula del coche que desea dar de baja:");
				String matricula = sc.next();

				GestorCoche gc = new GestorCoche();

				boolean baja = gc.baja(matricula);
				if (baja) {
					System.out.println("El coche se ha dado de baja");
				} else {
					System.out.println("El coche NO se ha dado de baja");
				}
				break;

			case 3:
				System.out.println("Introduzca la matricula del coche que desea buscar:");
				GestorCoche gp = new GestorCoche();
				String matriculaBusc = sc.next();
				System.out.println(matriculaBusc);
				Coche coche1 = gp.obtener(matriculaBusc);
				System.out.println(coche1);

				break;

			case 4:
				System.out.println("Introduzca la matricula del coche que desea modificar:");
				GestorCoche gp2 = new GestorCoche();
				Coche coche2 = gp2.obtener(sc.next());
				System.out.println("Introduzca la nueva marca:");
				coche2.setMarca(sc.next());
				System.out.println("Introduzca el nuevo modelo:");
				coche2.setModelo(sc.next());
				System.out.println("Introduzca los nuevos kilometros:");
				coche2.setNumKm(sc.nextInt());

				GestorCoche gpMod = new GestorCoche();

				boolean modificar = gpMod.modificar(coche2);
				if (modificar) {
					System.out.println("El coche se ha modificado");
				} else {
					System.out.println("El coche NO se ha modificado");
				}
				break;
			}

		} while (eleccion != 5);
		System.out.println("¡Hasta luego!");
	}

}
