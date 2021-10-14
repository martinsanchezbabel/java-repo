package hilo;

public class HiloPrimo implements Runnable {

	private int numeroComprobar;

	// String name
	public HiloPrimo(int numeroComprobar) {
		this.numeroComprobar = numeroComprobar;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());

		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador != numeroComprobar)) {
			if (numeroComprobar % contador == 0)
				primo = false;
			contador++;
		}

		if (primo == true) {
			System.out.println("El numero " + numeroComprobar + " es primo");
		} else {
			System.out.println("El numero " + numeroComprobar + " no es primo");
		}

	}
}
