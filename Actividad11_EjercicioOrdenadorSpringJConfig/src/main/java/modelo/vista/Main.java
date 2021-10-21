package modelo.vista;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cnf.ConfiguracionSpring;
import modelo.entidad.Ordenador;
import modelo.persistencia.DaoOrdenador;

public class Main {
	public static ApplicationContext context = null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		context = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		 DaoOrdenador DaoOrdenador = new DaoOrdenador();
		Ordenador o = context.getBean("ordenador", Ordenador.class);

		 DaoOrdenador.guardarOrdenador(o);

		System.out.println(o.toString());
	}

}
