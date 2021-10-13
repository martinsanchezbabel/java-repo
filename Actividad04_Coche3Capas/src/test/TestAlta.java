package test;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class TestAlta {
	public static void main(String[] args) {
		Coche coche = new Coche();
		coche.setMatricula("1234ABC");
		coche.setMarca("KIA");
		coche.setModelo("CEED");
		coche.setNumKm(100000);
		
		GestorCoche gestorCoche = new GestorCoche();
		boolean alta = gestorCoche.alta(coche);
		if(alta){
			System.out.println("El coche se ha dado de alta");
		}else{
			System.out.println("El coche NO se ha dado de alta");
		}
	}
}
