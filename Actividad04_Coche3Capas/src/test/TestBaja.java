package test;

import modelo.negocio.GestorCoche;

public class TestBaja {
	public static void main(String[] args) {
		GestorCoche gc = new GestorCoche();
		
		boolean baja = gc.baja("1234ZZZ");
		if(baja){
			System.out.println("El coche se ha dado de baja");
		}else{
			System.out.println("El coche NO se ha dado de baja");
		}
	}
}
