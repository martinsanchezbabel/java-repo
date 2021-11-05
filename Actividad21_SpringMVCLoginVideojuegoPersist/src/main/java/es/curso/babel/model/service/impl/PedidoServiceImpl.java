package es.curso.babel.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.babel.model.entity.Pedido;
import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.repository.PedidoRepository;
import es.curso.babel.model.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepo;

	@Override
	public List<Pedido> getAllPedidos() {
		return pedidoRepo.findAll();
	}

	@Override
	public Pedido findPedidoById(int id) {
		return pedidoRepo.findById(id).orElse(null);
	}

	@Override
	public void añadirPedido(Pedido pedido) {
		pedidoRepo.save(pedido);

	}

	@Override
	public void eliminarPedido(int id) {
		pedidoRepo.deleteById(id);
	}

}
