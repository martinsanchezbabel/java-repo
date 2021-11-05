package es.curso.babel.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.babel.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
