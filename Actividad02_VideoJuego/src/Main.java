import java.util.ArrayList;
import java.util.Scanner;

import Armas.Arco;
import Armas.Espada;
import Armas.Hechizo;
import Armas.Rezo;
import Personajes.Curandero;
import Personajes.Guerrero;
import Personajes.Mago;
import Personajes.Personaje;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int eleccion = 0;
		ArrayList<Personaje> personajes = new ArrayList();

		System.out.println(
				"¡Bienvenido! \n Para comenzar elija el personaje N1: \n 1: Mago \n 2: Guerrero \n 3: Curandero");
		eleccion = sc.nextInt();

		switch (eleccion) {
		case 1:
			Mago m1 = crearMago();
			personajes.add(m1);
			break;

		case 2:
			Guerrero g1 = crearGuerrero();
			personajes.add(g1);
			break;

		case 3:
			Curandero c1 = crearCurandero();
			personajes.add(c1);
			break;
		}

		System.out.println("¡Perfecto! \n Ahora elija el personaje N2: \n 1: Mago \n 2: Guerrero \n 3: Curandero");
		int eleccion2 = sc.nextInt();
		switch (eleccion2) {
		case 1:
			Mago m2 = crearMago();
			personajes.add(m2);
			break;

		case 2:
			Guerrero g2 = crearGuerrero();
			personajes.add(g2);
			break;

		case 3:
			Curandero c2 = crearCurandero();
			personajes.add(c2);
			break;
		}

		do {

			System.out.println("\n Personaje N1 elija arma: \n 1: Espada \n 2: Arco \n 3: Hechizo \n 4: Rezos");
			int dañoTotal = 0;
			int ataque1 = sc.nextInt();
			switch (ataque1) {
			case 1:
				Espada e1 = crearEspada();
				personajes.get(0).setArma(e1);

				if (personajes.get(0) instanceof Guerrero) {
					Guerrero g1 = (Guerrero) personajes.get(0);
					dañoTotal = g1.getFuerza() + e1.getDaño();
					System.out.println("Al ser un GUERRERO y coger una ESPADA hace " + g1.getFuerza() + " mas daño!");
				} else {
					dañoTotal = e1.getDaño();

				}
				personajes.get(1).setVida(personajes.get(1).getVida() - dañoTotal);
				if (personajes.get(1).getVida() <= 0) {
					System.out.println("El JUGADOR 2 HA MUERTO");
				} else {
					System.out.println(
							"Al segundo jugador le quedan " + personajes.get(1).getVida() + " puntos de vida!");
				}

				break;

			case 2:
				Arco a1 = crearArco();
				personajes.get(0).setArma(a1);

				if (personajes.get(0) instanceof Guerrero) {
					Guerrero g1 = (Guerrero) personajes.get(0);
					dañoTotal = g1.getFuerza() + a1.getDaño();
					System.out.println("Al ser un GUERRERO y coger un ARCO hace " + g1.getFuerza() + " mas daño!");
				} else {
					dañoTotal = a1.getDaño();

				}
				personajes.get(1).setVida(personajes.get(1).getVida() - dañoTotal);
				if (personajes.get(1).getVida() <= 0) {
					System.out.println("El JUGADOR 2 HA MUERTO");
				} else {
					System.out.println(
							"Al segundo jugador le quedan " + personajes.get(1).getVida() + " puntos de vida!");
				}
				break;

			case 3:
				Hechizo h1 = crearHechizo();
				personajes.get(0).setArma(h1);

				if (personajes.get(0) instanceof Mago) {
					Mago m1 = (Mago) personajes.get(0);
					dañoTotal = m1.getInteligencia() + h1.getDaño();
					System.out.println(
							"Al ser un MAGO y lanzar un HECHIZO hace " + m1.getInteligencia() + " puntos mas de daño!");
				} else {
					dañoTotal = h1.getDaño();

				}

				personajes.get(1).setVida(personajes.get(1).getVida() - dañoTotal);
				if (personajes.get(1).getVida() <= 0) {
					System.out.println("El JUGADOR 2 HA MUERTO");
				} else {
					System.out.println(
							"Al segundo jugador le quedan " + personajes.get(1).getVida() + " puntos de vida!");
				}
				break;

			case 4:
				Rezo r2 = crearRezo();
				personajes.get(0).setArma(r2);

				if (personajes.get(0) instanceof Curandero) {
					Curandero c2 = (Curandero) personajes.get(0);
					dañoTotal = c2.getSabiduria() + r2.getDaño();
					System.out.println(
							"Al ser un CURANDERO y hacer REZOS hace " + c2.getSabiduria() + " puntos mas de daño!");
				} else {
					dañoTotal = r2.getDaño();
				}

				personajes.get(1).setVida(personajes.get(1).getVida() - r2.getDaño());

				if (personajes.get(1).getVida() <= 0) {
					System.out.println("El JUGADOR 2 HA MUERTO");
				} else {
					System.out.println(
							"Al segundo jugador le quedan " + personajes.get(1).getVida() + " puntos de vida!");
				}
				break;
			}

			System.out.println("\n Personaje N2 elija arma: \n 1: Espada \n 2: Arco \n 3: Hechizo \n 4: Rezos");
			int ataque2 = sc.nextInt();
			int dañoTotal2 = 0;
			switch (ataque1) {
			case 1:
				Espada e2 = crearEspada();
				personajes.get(1).setArma(e2);

				if (personajes.get(1) instanceof Guerrero) {
					Guerrero g2 = (Guerrero) personajes.get(1);
					dañoTotal2 = g2.getFuerza() + e2.getDaño();
					System.out.println("Al ser un GUERRERO y coger una ESPADA hace " + g2.getFuerza() + " mas daño!");
				} else {
					dañoTotal2 = e2.getDaño();

				}
				personajes.get(0).setVida(personajes.get(0).getVida() - dañoTotal2);
				if (personajes.get(0).getVida() <= 0) {
					System.out.println("El JUGADOR 1 HA MUERTO");
				} else {
					System.out
							.println("Al primer jugador le quedan " + personajes.get(0).getVida() + " puntos de vida!");
				}

				break;

			case 2:
				Arco a2 = crearArco();
				personajes.get(1).setArma(a2);

				if (personajes.get(1) instanceof Guerrero) {
					Guerrero g2 = (Guerrero) personajes.get(1);
					dañoTotal2 = g2.getFuerza() + a2.getDaño();
					System.out.println("Al ser un GUERRERO y coger un ARCO hace " + g2.getFuerza() + " mas daño!");
				} else {
					dañoTotal2 = a2.getDaño();

				}
				personajes.get(0).setVida(personajes.get(0).getVida() - dañoTotal2);

				if (personajes.get(0).getVida() <= 0) {
					System.out.println("El JUGADOR 1 HA MUERTO");
				} else {
					System.out
							.println("Al primer jugador le quedan " + personajes.get(0).getVida() + " puntos de vida!");
				}
				break;

			case 3:
				Hechizo h2 = crearHechizo();
				personajes.get(1).setArma(h2);

				if (personajes.get(1) instanceof Mago) {
					Mago m2 = (Mago) personajes.get(1);
					dañoTotal2 = m2.getInteligencia() + h2.getDaño();
					System.out.println(
							"Al ser un MAGO y lanzar un HECHIZO hace " + m2.getInteligencia() + " puntos mas de daño!");
				} else {
					dañoTotal2 = h2.getDaño();

				}

				personajes.get(0).setVida(personajes.get(0).getVida() - dañoTotal2);

				if (personajes.get(0).getVida() <= 0) {
					System.out.println("El JUGADOR 1 HA MUERTO");
				} else {
					System.out
							.println("Al primer jugador le quedan " + personajes.get(0).getVida() + " puntos de vida!");
				}
				break;

			case 4:
				Rezo r2 = crearRezo();
				personajes.get(1).setArma(r2);

				if (personajes.get(1) instanceof Curandero) {
					Curandero c2 = (Curandero) personajes.get(1);
					dañoTotal2 = c2.getSabiduria() + r2.getDaño();
					System.out.println(
							"Al ser un CURANDERO y hacer REZOS hace " + c2.getSabiduria() + " puntos mas de daño!");
				} else {
					dañoTotal2 = r2.getDaño();
				}

				personajes.get(0).setVida(personajes.get(0).getVida() - dañoTotal2);

				if (personajes.get(0).getVida() <= 0) {
					System.out.println("El JUGADOR 1 HA MUERTO");
				} else {

					System.out
							.println("Al primer jugador le quedan " + personajes.get(0).getVida() + " puntos de vida!");
				}
				break;
			}

			if (personajes.get(0).getVida() > 0 || personajes.get(1).getVida() > 0) {

			} else {
				System.out.println(
						"En este turno el JUGADOR UNO tiene " + personajes.get(0).getVida() + " PUNTOS de VIDA \n"
								+ "y el JUGADOR DOS tiene " + personajes.get(1).getVida() + " PUNTOS de VIDA");
			}

		} while (personajes.get(0).getVida() > 0 && personajes.get(1).getVida() > 0);

		if (personajes.get(0).getVida() < 0) {
			System.out.println("\n ¡FELICIDADES JUGADOR 2 HAS GANADO!");
		} else {
			System.out.println("\n ¡FELICIDADES JUGADOR 1 HAS GANADO!");
		}

	}

	public static Mago crearMago() {
		int atributo;
		Mago m;
		atributo = (int) Math.floor(Math.random() * (9 + 1) + 1);
		m = new Mago(atributo);
		m.setVida(100);
		System.out.println("Ha elegido a un MAGO con una inteligencia de " + atributo + " puntos y " + m.getVida()
				+ " puntos de vida");
		return m;
	}

	public static Guerrero crearGuerrero() {
		int atributo;
		Guerrero g;
		atributo = (int) Math.floor(Math.random() * (9 + 1) + 1);
		g = new Guerrero(atributo);
		g.setVida(100);
		System.out.println("Ha elegido a un GUERERRO con una fuerza de " + atributo + " puntos " + g.getVida()
				+ " puntos de vida");
		return g;
	}

	public static Curandero crearCurandero() {
		int atributo;
		Curandero c;
		atributo = (int) Math.floor(Math.random() * (9 + 1) + 1);
		c = new Curandero(atributo);
		c.setVida(100);
		System.out.println("Ha elegido a un CURANDERO con una sabiduria de " + atributo + " puntos " + c.getVida()
				+ " puntos de vida");
		return c;
	}

	// Metodo para crear una espada con un daño aleatorio entre 1 y 10
	public static Espada crearEspada() {
		int atributo;
		Espada e;
		atributo = (int) Math.floor(Math.random() * (9 + 1) + 1);
		e = new Espada(atributo);
		System.out.println("Ha elegido una ESPADA con un daño de " + atributo + " puntos ");
		return e;
	}

	public static Arco crearArco() {
		int atributo;
		Arco a;
		atributo = (int) Math.floor(Math.random() * (9 + 1) + 1);
		a = new Arco(atributo);
		System.out.println("Ha elegido un ARCO con un daño de " + atributo + " puntos ");
		return a;
	}

	public static Hechizo crearHechizo() {
		int atributo;
		Hechizo h;
		atributo = (int) Math.floor(Math.random() * (9 + 1) + 1);
		h = new Hechizo(atributo);
		System.out.println("Ha elegido un HECHIZO con un daño de " + atributo + " puntos ");
		return h;
	}

	public static Rezo crearRezo() {
		int atributo;
		Rezo r;
		atributo = (int) Math.floor(Math.random() * (9 + 1) + 1);
		r = new Rezo(atributo);
		System.out.println("Ha elegido unos REZOS con un daño de " + atributo + " puntos ");
		return r;
	}

}
