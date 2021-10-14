package main;

import java.util.Scanner;

import hilo.HiloPrimo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creamos el Scanner
		Scanner sc = new Scanner(System.in);

		// Pedimos los tres numeros por pantalla
		System.out.println("---PROGRAMA PARA SABER SI 3 NUMEROS SON PRIMOS---");
		System.out.println("Introduzca el primero:");
		int pNumero = sc.nextInt();
		System.out.println("Introduzca el segundo:");
		int sNumero = sc.nextInt();
		System.out.println("Introduzca el tercero:");
		int tNumero = sc.nextInt();

		// Creamos tres objetos HiloPrimo pasandole por el constructor su respectivo
		// numero en cuestion
		// Posterirmente creamos tres hilos que recibira por parametro el respectivo
		// objeto hiloX y el nombre correspondiente "HiloX"
		HiloPrimo hilo1 = new HiloPrimo(pNumero);
		Thread t1 = new Thread(hilo1, "Hilo1");

		HiloPrimo hilo2 = new HiloPrimo(sNumero);
		Thread t2 = new Thread(hilo2, "Hilo2");

		HiloPrimo hilo3 = new HiloPrimo(tNumero);
		Thread t3 = new Thread(hilo3, "Hilo3");

		// Ejecutamos los tres hilos que nos devolvera por consola la comprobacion
		t1.start();
		t2.start();
		t3.start();
	}

}
