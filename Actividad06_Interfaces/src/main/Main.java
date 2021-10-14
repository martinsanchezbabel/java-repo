package main;

import entidad.Vehiculo;

import java.util.ArrayList;

import entidad.Avion;
import entidad.Barco;
import entidad.Coche;
import entidad.Moto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();//Creamos el arrayList donde alojaremos a los objetos que heredan de Vehiculo

		//Creamos un objeto Moto y le damos valor a sus parametros
		Moto m = new Moto();
		m.setId(1);
		m.setCaballos(200);
		m.setNombre("Kawasaki");
		vehiculos.add(m); //Lo aniadimos al arrayList de Vehiculos

		//Creamos un objeto Coche y le damos valor a sus parametros
		Coche c = new Coche();
		c.setId(2);
		c.setCaballos(100);
		c.setNombre("Volskwagen");
		vehiculos.add(c); //Lo aniadimos al arrayList de Vehiculos

		//Creamos un objeto Barco y le damos valor a sus parametros
		Barco b = new Barco();
		b.setId(3);
		b.setCaballos(400);
		b.setNombre("La Pinta");
		vehiculos.add(b); //Lo aniadimos al arrayList de Vehiculos

		//Creamos un objeto Avion y le damos valor a sus parametros
		Avion a = new Avion();
		a.setId(4);
		a.setCaballos(2000);
		a.setNombre("Boeing 787");
		vehiculos.add(a); //Lo aniadimos al arrayList de Vehiculos

		//Recorremos el array de Vehiculos para que por cada posicion se llame a su metodo
		//mostrandonos asi el nombre del vehiculo y los metros recorridos.
		for (int i = 0; i < vehiculos.size(); i++) {
			vehiculos.get(i).movimiento(vehiculos.get(i).getNombre());
		}
	}

}
