package hilo;

//Clase HiloPrimo que implementara la interface Runnable para poder ejecutar un bloque de codigo cuya funcion es comprobar si un numero dado es primo o no
public class HiloPrimo implements Runnable {

	private int numeroComprobar;

	// Numero puesto a comprobar si es primo o no
	public HiloPrimo(int numeroComprobar) {
		this.numeroComprobar = numeroComprobar;
	}

	@Override
	public void run() {// Codigo que al ser ejecutado el hilo comprobara si el numero pasado por
						// parametro mas arriba es primo o no
		// TODO Auto-generated method stub
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());

		int contador = 2;
		boolean primo = true;
		// Mediante esta formula se realizara la comprobacion de si son numeros primos o
		// no
		while ((primo) && (contador != numeroComprobar)) {
			if (numeroComprobar % contador == 0)
				primo = false;
			contador++;
		}

		// Bloque if-else que nos mostrara por pantalla un mensaje distinto dependiendo
		// de si son numeros primos o no
		if (primo == true) {
			System.out.println("El numero " + numeroComprobar + " es primo");
		} else {
			System.out.println("El numero " + numeroComprobar + " no es primo");
		}

	}
}
