import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		//
		//RAM
		//
		Ram ramOrdenador1 = new Ram();
		ramOrdenador1.setPrecio(400.75);
		ramOrdenador1.setGeneracion("8");
		ramOrdenador1.setHz(2000);
		
		Ram ramOrdenador2 = new Ram();
		ramOrdenador2.setPrecio(600.75);
		ramOrdenador2.setGeneracion("10");
		ramOrdenador2.setHz(3000);
		
		
		Ram ramGrafica1 = new Ram();
		ramGrafica1.setPrecio(100.5);
		ramGrafica1.setGeneracion("8");
		ramGrafica1.setHz(1000);
		
		Ram ramGrafica2 = new Ram();
		ramGrafica2.setPrecio(220);
		ramGrafica2.setGeneracion("7");
		ramGrafica2.setHz(3500);
		
		Ram ramGraficaProcesador = new Ram();
		ramGraficaProcesador.setPrecio(100);
		ramGraficaProcesador.setGeneracion("7");
		ramGraficaProcesador.setHz(3500);
		
		//
		//TARJETA GRAFICA
		//
		TarjetaGrafica tarjetaGraficaOrdenador= new TarjetaGrafica();
		tarjetaGraficaOrdenador.setMarca("Nvidia");
		tarjetaGraficaOrdenador.setPrecio(700);
		tarjetaGraficaOrdenador.setRam(ramGrafica1);
		tarjetaGraficaOrdenador.setModelo("Segundo");
		
		TarjetaGrafica tarjetaGraficaOrdenador2= new TarjetaGrafica();
		tarjetaGraficaOrdenador2.setMarca("Nvidia");
		tarjetaGraficaOrdenador2.setPrecio(550);
		tarjetaGraficaOrdenador2.setRam(ramGrafica2);
		tarjetaGraficaOrdenador2.setModelo("Tercero");
		
		TarjetaGrafica tarjetaGraficaProcesador= new TarjetaGrafica();
		tarjetaGraficaProcesador.setMarca("Nvidia");
		tarjetaGraficaProcesador.setPrecio(220);
		tarjetaGraficaProcesador.setRam(ramGraficaProcesador);
		tarjetaGraficaProcesador.setModelo("Primero");
		
		//
		//PROCESADOR
		//
		Procesador procesador = new Procesador();
		procesador.setPrecio(600.75);
		procesador.setHz(6000);
		procesador.setMarca("HP");
		procesador.setTarjetaGrafica(tarjetaGraficaProcesador);
		
		//
		//PLACA BASE
		//
		PlacaBase placaBase = new PlacaBase();
		placaBase.setPrecio(750.5);
		placaBase.setMarca("Lenovo");
		placaBase.setModelo("Tercero");
		
		//
		//PERIFERICOS
		//
		Periferico periferico1= new Periferico();
		periferico1.setMarca("Lenovo");
		periferico1.setPrecio(10);
		periferico1.setNombre("Raton");
		
		Periferico periferico2= new Periferico();
		periferico2.setMarca("Lenovo");
		periferico2.setPrecio(15);
		periferico2.setNombre("Teclado");
		
		Periferico periferico3= new Periferico();
		periferico3.setMarca("Lenovo");
		periferico3.setPrecio(15);
		periferico3.setNombre("Altavoces");
		
		//
		//ORDENADOR
		//
		Ordenador ordenador = new Ordenador();
		
		ordenador.setMarca("Dell");
		
		ArrayList<Ram> ramListOrdenador = new ArrayList<Ram>();
		ramListOrdenador.add(ramOrdenador1);
		ramListOrdenador.add(ramOrdenador2);
		ordenador.setRamList(ramListOrdenador);
		
		ArrayList<TarjetaGrafica> graficaListOrdenador = new ArrayList<TarjetaGrafica>();
		graficaListOrdenador.add(tarjetaGraficaOrdenador);
		graficaListOrdenador.add(tarjetaGraficaOrdenador2);
		ordenador.setGraficaList(graficaListOrdenador);
		
		
		ArrayList<Periferico> perifListOrdenador = new ArrayList<Periferico>();
		perifListOrdenador.add(periferico1);
		perifListOrdenador.add(periferico2);
		perifListOrdenador.add(periferico3);
		ordenador.setPerifList(perifListOrdenador);

		ordenador.setProcesador(procesador);
		ordenador.setPlacaBase(placaBase);
		
		ordenador.setPrecio(ordenador.getProcesador().getPrecio() + ordenador.getPlacaBase().getPrecio());
		
		//System.out.println(ordenador.getGraficaList());
		System.out.println("El precio total del ordenador será de: " + ordenador.calcularPrecioComponentes() +"€");
	}

}
