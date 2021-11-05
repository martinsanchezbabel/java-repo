package es.curso.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	List<Pedido> findByUsuarioId(int id);
}
