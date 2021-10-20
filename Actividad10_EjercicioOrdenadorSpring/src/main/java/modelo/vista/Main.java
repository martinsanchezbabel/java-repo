package modelo.vista;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Ordenador;
import modelo.persistencia.DaoOrdenador;

public class Main {
	public static ApplicationContext context = null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		context = new ClassPathXmlApplicationContext("ApplicationContext01.xml");
		DaoOrdenador DaoOrdenador = new DaoOrdenador();
		Ordenador o = context.getBean("Ordenador", Ordenador.class);

		DaoOrdenador.guardarOrdenador(o);

		System.out.println(o.toString());
	}

}
