package entidad;

//Entidad Avion que heredara de Vehiculo
public class Avion extends Vehiculo {

	//Metodo del Interfaz implementada por la clase padre Vehiculo que sobreescribiremos por la necesidad de realizar una funcion diferente
	@Override
	public void movimiento(String nombre) {
		int metros = 10;
		int metrosTotal = metros + (this.getCaballos() * 3); //Formula que nos dara los metros totales que reocorrera el avion 
															 //sumando su potencia base
		
		// Nos mostrara por pantalla un texto dandonos el nombre del vehiculo y los
		// metros recorridos
		System.out.println("El vehiculo " + this.getNombre() + " se ha movido " + metrosTotal + " metros por el aire.");
	}
}
