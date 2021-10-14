package hilo;

public class _02_HiloRunnable implements Runnable{
	
	private String valorImprimir;

	// String name
	public _02_HiloRunnable(String valorImprimir) {
		this.valorImprimir = valorImprimir;
	}

	@Override
	public void run() {
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());
		for (int i = 0; i < 20; i++) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out
					.println("Hilo: " + Thread.currentThread().getName() 
							+ " , dice: " + valorImprimir + " ciclo: " + i);
		}
		System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado");
		for(int i = 0; i<= 9;i++) {
			
		}		
	}
}