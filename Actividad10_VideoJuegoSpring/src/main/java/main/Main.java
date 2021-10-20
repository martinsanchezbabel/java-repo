package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entidad.Personaje;
import negocio.Batalla;

public class Main {
	
	public static ApplicationContext context = null;
	
	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Batalla batalla = context.getBean("batalla",Batalla.class);
		Personaje pGanador = batalla.combatir();
		System.out.println("El ganador de la arena es!!!!!: " + pGanador);
	}
}
