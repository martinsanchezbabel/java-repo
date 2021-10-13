package test;

import java.util.List;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class TestObtener {
	public static void main(String[] args) {
		GestorCoche gp = new GestorCoche();
		Coche coche = gp.obtener("1234ABC");
		System.out.println(coche);
		
		System.out.println("*******************");
		
		List<Coche> listaPersonas = gp.listar();
		for(Coche c : listaPersonas){
			System.out.println(c);
		}
	}
}
