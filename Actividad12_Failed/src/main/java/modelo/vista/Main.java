package modelo.vista;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Configuracion;
import modelo.entidad.Cliente;
import modelo.entidad.Pedido;
import modelo.persistencia.DaoClienteJDBCTemplate;

public class Main {
	private static ApplicationContext context;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		context = new AnnotationConfigApplicationContext(Configuracion.class);

		DaoClienteJDBCTemplate d = new DaoClienteJDBCTemplate();

		Cliente c = context.getBean("cliente", Cliente.class);
		c.setNombre("Martin");
		c.setEdad(21);
		d.insertarCliente(c);
	}

}
