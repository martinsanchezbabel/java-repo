package es.curso.modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import es.curso.modelo.entidad.Coche;

@Repository
public class CocheDaoJPA implements CocheDAO {

	// Para inyectarle el objeto entity manager no podemos usar la anotacion
	// @Autowired ya que no hay un objeto de tipo EntityManager en mi contexto
	// de spring. El objeto que tengo dado de alta es un objeto de tipo
	// EntityManagerFactory. Para inyectar un objeto de tipo EntityManager
	// a partir de un objeto EntityManagerFactory, usaremos la anotacion
	// @PersistenceContext
	@PersistenceContext
	private EntityManager em;

	public String insertar(Coche c) {
		System.out.println(c);
		em.persist(c);// para insertar usaremos persist()
		return c.getMatricula();
	}

	public Coche modificar(Coche c) {
		return em.merge(c);// para modificar usaremos merge()
	}

	public Coche buscar(String matricula) {
		return em.find(Coche.class, matricula);// para buscar por id
	}

	public String borrar(String matricula) {
		// Para borrar usaremos remove(), pero...
		// Para poder borrar registros de la bbdd, JPA exige que
		// el objeto que vayamos a borrar este dentro del contexto
		// de persistencia (cache).
		// De esta manera, no podemos ejecutar remove() directamente,
		// primero tenemos que meter el objeto en el contexto
		// de persistencia y luego ya podemos borrarlo

		// Primero buscamos el objeto en base de datos
		Coche pAux = em.find(Coche.class, matricula);
		em.remove(pAux);
		return pAux.getMatricula();
	}

	@SuppressWarnings("unchecked")
	public List<Coche> listar() {
		// Para listar todas las peliculas tenemos que recurrir a un lenguaje llamado
		// JPQL
		// es un lenguaje mezcla entre SQL y POO
		List<Coche> listaCoches = em.createQuery("from Coche c").getResultList();
		return listaCoches;
	}

}
