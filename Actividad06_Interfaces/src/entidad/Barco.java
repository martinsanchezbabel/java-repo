package entidad;

//Entidad Barco que heredara de Vehiculo
public class Barco extends Vehiculo {

	// Metodo del Interfaz implementada por la clase padre Vehiculo que
	// sobreescribiremos por la necesidad de realizar una funcion diferente
	@Override
	public void movimiento(String nombre) {
		int metros = 10;
		int metrosTotal = metros + (this.getCaballos() * 2);// Formula que nos dara los metros totales que reocorrera el barco
															// sumando su potencia base
		
		// Nos mostrara por pantalla un texto dandonos el nombre del vehiculo y los
		// metros recorridos
		System.out.println("El vehiculo " + this.getNombre() + " se ha movido " + metrosTotal + " metros por el agua.");
	}
}
