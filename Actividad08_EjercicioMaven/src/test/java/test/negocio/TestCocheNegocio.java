package test.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.entidad.Coche;
import modelo.persistencia.CocheDaoMySql;

public class TestCocheNegocio {
	CocheDaoMySql cdm = new CocheDaoMySql();

	@Test
	public void altaTest() {
		// Todo correcto
		Coche c = new Coche();
		c.setNumKm(9999);
		c.setMatricula("9876ZYW");
		c.setModelo("Renault");
		c.setMarca("Clio");

		assertEquals(true, cdm.alta(c));

		// La matricula tiene que tener 7 caracteres
		Coche c2 = new Coche();
		c2.setNumKm(9999);
		c2.setMatricula("12");
		c2.setModelo("Renault");
		c2.setMarca("Clio");

		assertEquals(false, cdm.alta(c));

		// El modelo no puede estar vacío
		Coche c3 = new Coche();
		c3.setNumKm(9999);
		c3.setMatricula("12");
		c3.setModelo("Renault");
		c3.setMarca("Clio");

		assertEquals(false, cdm.alta(c));

		// La marca no puede estar vacía
		Coche c4 = new Coche();
		c4.setNumKm(9999);
		c4.setMatricula("12");
		c4.setModelo("Renault");
		c4.setMarca("");

		assertEquals(false, cdm.alta(c));
	}
	
	
}
