package interfaz;

//Interfaz que sera implementada por la entidad Vehiculo
public interface Movible {

	//Metodo que por defecto tendran todos los objetos Vehiculos y aquellos que hereden de ella
	default void movimiento(String nombre) {
		int metros = 10; //Valor por defecto para los metros recorridos
		
		
		//Nos mostrara por pantalla un texto dandonos el nombre del vehiculo y los metros recorridos
		System.out.println("El vehiculo " +nombre+ " se ha movido " + metros + " metros por la carretera.");
	}
}
