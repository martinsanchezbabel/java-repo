package modelo.vista;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Superheroe;

public class Main {
	public static ApplicationContext context = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		context = new ClassPathXmlApplicationContext("ApplicationContext01.xml");
		Scanner sc = new Scanner(System.in);// Creamos el Scanner
		int eleccion = 0;// Inicializaos a 0 la eleccion para que entre en el bucle de abajo y no elija
							// ninguno de los casos propuestos

		do {
			System.out.println(
					"\n Buenas, ¿que desea hacer? \n1: Acceder a los Superheroes base. \n2: Aniadir Superheroe con 100 de poder base. "
							+ "\n3: Aniadir Superheroe con el superpoder 'Volar' \n4: Listar superheroes con 100 de poder base. "
							+ "\n5: Listar superheroes con el superpoder 'Volar' \n6: Salir.\n");
			eleccion = sc.nextInt();

			switch (eleccion) {
			case 1:
				Superheroe sh1 = context.getBean("superheroe1", Superheroe.class);
				Superheroe sh2 = context.getBean("superheroe2", Superheroe.class);
				Superheroe sh3 = context.getBean("superheroe3", Superheroe.class);

				System.out.println(sh1.toString() + "\n" + sh2.toString() + "\n" + sh3.toString() + "\n");
				break;
			case 2:
				ArrayList<Superheroe> listaSuperHeroesPoder = context.getBean("listaSuperHeroesPoder", ArrayList.class);
				System.out.println("Introduzca el ID: ");
				int nId = sc.nextInt();
				System.out.println("Introduzca el nombre: ");
				String nNombre = sc.next();
				System.out.println("Introduzca el superpoder: ");
				String nSuperpoder = sc.next();

				Superheroe nshP = context.getBean("plantillaSuperheroe1", Superheroe.class);
				nshP.setId(nId);
				nshP.setNombre(nNombre);
				nshP.setSuperpoder(nSuperpoder);
				listaSuperHeroesPoder.add(nshP);
				System.out.println("Nuevo superheroe anadido: " + nshP.toString());
				break;
			case 3:
				ArrayList<Superheroe> listaSuperHeroesSuperPoder = context.getBean("listaSuperHeroesSuperPoder",
						ArrayList.class);
				System.out.println("Introduzca el ID: ");
				int nId2 = sc.nextInt();
				System.out.println("Introduzca el nombre: ");
				String nNombre2 = sc.next();
				System.out.println("Introduzca el poder: ");
				int nPoder = sc.nextInt();

				Superheroe nshSP = context.getBean("plantillaSuperheroe2", Superheroe.class);
				nshSP.setId(nId2);
				nshSP.setNombre(nNombre2);
				nshSP.setPoder(nPoder);
				listaSuperHeroesSuperPoder.add(nshSP);
				System.out.println("Nuevo superheroe anadido: " + nshSP.toString());
				break;
			case 4:
				ArrayList<Superheroe> listaSuperHeroesPoderListar = context.getBean("listaSuperHeroesPoder",ArrayList.class);
				for (Superheroe sh : listaSuperHeroesPoderListar) {
					System.out.println(sh.toString());
				}
				break;
			case 5:
				ArrayList<Superheroe> listaSuperHeroesSuperPoderListar = context.getBean("listaSuperHeroesSuperPoder",ArrayList.class);
				for (Superheroe sh : listaSuperHeroesSuperPoderListar) {
					System.out.println(sh.toString());
				}
				break;
			}
		} while (eleccion != 6);// Al elegir la 6ta opcion el programa se detendra
		System.out.println("¡Hasta luego!");
	}
}
