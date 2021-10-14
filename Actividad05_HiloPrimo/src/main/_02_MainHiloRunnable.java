package main;

import hilo._02_HiloRunnable;

public class _02_MainHiloRunnable {
	public static void main(String[] args) {
		_02_HiloRunnable hilo1 = new _02_HiloRunnable("Valor 1");
		Thread t1 = new Thread(hilo1);
		
		t1.setName("Hilo1");
		
		
		_02_HiloRunnable hilo2 = new _02_HiloRunnable("Valor 2");
		Thread t2 = new Thread(hilo2,"Hilo2");
				
		try {
			Thread.sleep(5000);//5 seg
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.start();		
		t2.start();
		
		System.out.println("Hilo principal parando");
	}
}