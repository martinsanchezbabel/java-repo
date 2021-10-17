package test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.entidad.Coche;
import modelo.persistencia.CocheDaoMySql;

public class TestCocheDao {

	private CocheDaoMySql cdm = new CocheDaoMySql();

	/*
	@BeforeAll
	public void cargarBasedeDatos() {
		cdm.abrirConexion();
	}

	@AfterAll
	public void cerarBaseDeDatos() {
		cdm.cerrarConexion();
	}
	*/

	@Test
	public void altaTest() {

		Coche coche = new Coche();
		coche.setNumKm(112000);
		coche.setMarca("Opel");
		coche.setModelo("Corsa");
		coche.setMatricula("9999ZZZ");

		assertEquals(true, cdm.alta(coche));

	}

	@Test
	public void obtenerTest() {
		
		Coche cocheObtenido = cdm.obtener("3456WER");
		assertEquals("3456WER", cocheObtenido.getMatricula());
		
	}
	
	@Test
	public void modificarTest() {
		
		Coche c = cdm.obtener("3456WER");
		c.setNumKm(0);
		assertEquals(true, cdm.modificar(c));
	}
	
	@Test
	public void bajaTest() {
		// No existe ningún coche con esta id
		assertEquals(false, cdm.baja("0000000"));

		assertEquals(true, cdm.baja("9999ZZZ"));
	}
	


}
