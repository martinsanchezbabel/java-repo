package test;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class TestModificar {
	public static void main(String[] args) {
		Coche coche = new Coche();
		coche.setMatricula("1234ABC");
		coche.setMarca("KIA");
		coche.setModelo("CEED");
		coche.setNumKm(100000);
		
		GestorCoche gp = new GestorCoche();
		
		boolean modificar = gp.modificar(coche);
		if(modificar){
			System.out.println("El coche se ha modificado");
		}else{
			System.out.println("El coche NO se ha modificado");
		}
	}
}
