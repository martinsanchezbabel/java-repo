package es.curso.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.model.entity.Pedido;
import es.curso.model.repository.PedidoRepository;
import es.curso.model.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepo;

	@Override
	@Transactional
	public void añadirPedido(Pedido pedido) {
		pedidoRepo.save(pedido);

	}

	@Override
	public List<Pedido> findByUsuarioId(int id) {
		return pedidoRepo.findByUsuarioId(id);
	}

	@Override
	public double calcularTotal(Pedido pedido) {
		return pedido.calcularTotal();
	}

}
