package cnf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import modelo.entidad.Ordenador;
import modelo.entidad.Periferico;
import modelo.entidad.PlacaBase;
import modelo.entidad.Procesador;
import modelo.entidad.Ram;
import modelo.entidad.TarjetaGrafica;
import util.Util;

@Configuration
public class ConfiguracionSpring {

	Util util = new Util();
	@Bean
	public Ram ramOrdenador1() {
		Ram ramOrdenador1 = new Ram();
		ramOrdenador1.setPrecio(util.generateRandomNumber(100, 200));
		ramOrdenador1.setGeneracion("8");
		ramOrdenador1.setHz(2000);
		return ramOrdenador1;
	}

	@Bean
	public Ram ramOrdenador2() {
		Ram ramOrdenador2 = new Ram();
		ramOrdenador2.setPrecio(util.generateRandomNumber(100, 200));
		ramOrdenador2.setGeneracion("10");
		ramOrdenador2.setHz(3000);
		return ramOrdenador2;
	}

	@Bean
	public Ram ramGrafica1() {
		Ram ramGrafica1 = new Ram();
		ramGrafica1.setPrecio(util.generateRandomNumber(100, 200));
		ramGrafica1.setGeneracion("8");
		ramGrafica1.setHz(1000);
		return ramGrafica1;
	}

	@Bean
	public Ram ramGrafica2() {
		Ram ramGrafica2 = new Ram();
		ramGrafica2.setPrecio(util.generateRandomNumber(100, 200));
		ramGrafica2.setGeneracion("7");
		ramGrafica2.setHz(3500);
		return ramGrafica2;
	}

	@Bean
	public Ram ramGraficaProcesador() {
		Ram ramGraficaProcesador = new Ram();
		ramGraficaProcesador.setPrecio(util.generateRandomNumber(100, 200));
		ramGraficaProcesador.setGeneracion("7");
		ramGraficaProcesador.setHz(3500);
		return ramGraficaProcesador;
	}

	@Bean
	public TarjetaGrafica tarjetaGraficaOrdenador() {
		TarjetaGrafica tarjetaGraficaOrdenador = new TarjetaGrafica();
		tarjetaGraficaOrdenador.setMarca(util.getRandomMarca());
		tarjetaGraficaOrdenador.setPrecio(util.generateRandomNumber(100, 200));
		tarjetaGraficaOrdenador.setRam(ramGrafica1());
		tarjetaGraficaOrdenador.setModelo("Segundo");
		return tarjetaGraficaOrdenador;
	}

	@Bean
	public TarjetaGrafica tarjetaGraficaOrdenador2() {
		TarjetaGrafica tarjetaGraficaOrdenador2 = new TarjetaGrafica();
		tarjetaGraficaOrdenador2.setMarca(util.getRandomMarca());
		tarjetaGraficaOrdenador2.setPrecio(util.generateRandomNumber(100, 200));
		tarjetaGraficaOrdenador2.setRam(ramGrafica2());
		tarjetaGraficaOrdenador2.setModelo("Tercero");
		return tarjetaGraficaOrdenador2;
	}

	@Bean
	public TarjetaGrafica tarjetaGraficaProcesador() {
		TarjetaGrafica tarjetaGraficaProcesador = new TarjetaGrafica();
		tarjetaGraficaProcesador.setMarca(util.getRandomMarca());
		tarjetaGraficaProcesador.setPrecio(util.generateRandomNumber(100, 200));
		tarjetaGraficaProcesador.setRam(ramGraficaProcesador());
		tarjetaGraficaProcesador.setModelo("Primero");
		return tarjetaGraficaProcesador;
	}

	@Bean
	public Periferico periferico1() {
		Periferico periferico1 = new Periferico();
		periferico1.setMarca(util.getRandomMarca());
		periferico1.setPrecio(util.generateRandomNumber(100, 200));
		periferico1.setNombre("Raton");
		return periferico1;
	}

	@Bean
	public Periferico periferico2() {
		Periferico periferico2 = new Periferico();
		periferico2.setMarca("Lenovo");
		periferico2.setPrecio(util.generateRandomNumber(100, 200));
		periferico2.setNombre("Teclado");
		return periferico2;
	}

	@Bean
	public Periferico periferico3() {
		Periferico periferico3 = new Periferico();
		periferico3.setMarca(util.getRandomMarca());
		periferico3.setPrecio(15);
		periferico3.setNombre("Altavoces");
		return periferico3;
	}

	@Bean
	public PlacaBase placaBase() {
		PlacaBase placaBase = new PlacaBase();
		placaBase.setPrecio(util.generateRandomNumber(100, 200));
		placaBase.setMarca(util.getRandomMarca());
		placaBase.setModelo("Tercero");
		return placaBase;
	}

	@Bean
	public Procesador procesador() {
		Procesador procesador = new Procesador();
		procesador.setPrecio(util.generateRandomNumber(100, 200));
		procesador.setHz(6000);
		procesador.setMarca(util.getRandomMarca());
		procesador.settarjetaGraficaProcesador(tarjetaGraficaProcesador());

		return procesador;
	}

	@Bean
	public ArrayList<Ram> ramListOrdenador() {
		ArrayList<Ram> ramListOrdenador = new ArrayList<Ram>();
		ramListOrdenador.add(ramOrdenador1());
		ramListOrdenador.add(ramOrdenador2());
		return ramListOrdenador;

	}

	@Bean
	public ArrayList<TarjetaGrafica> graficaListOrdenador() {
		ArrayList<TarjetaGrafica> graficaListOrdenador = new ArrayList<TarjetaGrafica>();
		graficaListOrdenador.add(tarjetaGraficaOrdenador());
		graficaListOrdenador.add(tarjetaGraficaOrdenador2());
		return graficaListOrdenador;

	}

	@Bean
	public ArrayList<Periferico> perifListOrdenador() {
		ArrayList<Periferico> perifListOrdenador = new ArrayList<Periferico>();
		perifListOrdenador.add(periferico1());
		perifListOrdenador.add(periferico2());
		perifListOrdenador.add(periferico3());
		return perifListOrdenador;

	}

	@Bean
	public Ordenador ordenador() {
		Ordenador ordenador = new Ordenador();
		ordenador.setMarca(util.getRandomMarca());
		ordenador.setPrecio(2000);

		ordenador.setRamListOrdenador(ramListOrdenador());
		ordenador.setGraficaListOrdenador(graficaListOrdenador());
		ordenador.setPerifListOrdenador(perifListOrdenador());

		ordenador.setProcesador(procesador());
		ordenador.setPlacaBase(placaBase());
		return ordenador;
	}

}
