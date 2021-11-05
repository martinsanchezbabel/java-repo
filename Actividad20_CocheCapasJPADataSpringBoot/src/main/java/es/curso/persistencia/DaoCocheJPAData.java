package es.curso.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.entidad.Coche;

@Repository
public interface DaoCocheJPAData extends JpaRepository<Coche, String>{

}
