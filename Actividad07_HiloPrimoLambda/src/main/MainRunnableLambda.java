package main;

import java.util.ArrayList;
import java.util.Scanner;

public class MainRunnableLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creamos el Scanner
		Scanner sc = new Scanner(System.in);

		// Creamos el arrayList de int donde se alojaran los numeros introducidos por
		// teclado
		ArrayList<Integer> listaNumeros = new ArrayList<>();

		// Pedimos los tres numeros por pantalla
		System.out.println("---PROGRAMA PARA SABER SI 3 NUMEROS SON PRIMOS---");
		System.out.println("Introduzca el primero:");
		int pNumero = sc.nextInt();
		listaNumeros.add(pNumero);

		System.out.println("Introduzca el segundo:");
		int sNumero = sc.nextInt();
		listaNumeros.add(sNumero);

		System.out.println("Introduzca el tercero:");
		int tNumero = sc.nextInt();
		listaNumeros.add(tNumero);

		// Hacemos la clase runnable lambda donde se comprobara si los numeros alojados
		// en el arrayList son primos o no
		Runnable runnable = () -> {

			for (int i = 0; i < listaNumeros.size(); i++) {
				System.out.println("Arrancando hilo: " + Thread.currentThread().getName());

				// Mediante esta formula se realizara la comprobacion de si son numeros primos o
				// no
				int contador = 2;
				boolean primo = true;
				while ((primo) && (contador != listaNumeros.get(i))) {// Bucle para recorrer el arrayList de numeros
					if (listaNumeros.get(i) % contador == 0)
						primo = false;
					contador++;
				}

				// Bloque if-else que nos mostrara por pantalla un mensaje distinto dependiendo
				// de si son numeros primos o no
				if (primo == true) {
					System.out.println("El numero " + listaNumeros.get(i) + " es primo");
				} else {
					System.out.println("El numero " + listaNumeros.get(i) + " no es primo");
				}
			}
		};

		// Creamos un hilo donde se ejectuara el codigo creado en el runnable
		new Thread(runnable, "Hilo primos").start();

	}

}
