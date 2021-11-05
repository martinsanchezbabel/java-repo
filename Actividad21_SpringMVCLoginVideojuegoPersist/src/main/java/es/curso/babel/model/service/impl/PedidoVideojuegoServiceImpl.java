package es.curso.babel.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.babel.model.entity.PedidoVideojuego;
import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.repository.PedidoRepository;
import es.curso.babel.model.repository.PedidoVideojuegoRepository;
import es.curso.babel.model.repository.VideojuegoRepository;
import es.curso.babel.model.service.PedidoVideojuegoService;
import es.curso.babel.model.service.VideojuegoService;

@Service
public class PedidoVideojuegoServiceImpl implements PedidoVideojuegoService {

	@Autowired
	private PedidoVideojuegoRepository pedidoVideoRepo;

	@Autowired
	private VideojuegoRepository videoRepo;

	@Autowired
	private PedidoRepository pedidoRepo;

	@Override
	public Videojuego findVideojuegoPedidoById(int idPedido) {
		return null;
	}

	@Override
	public void añadirPedidoVideojuego(PedidoVideojuego pedidoVideojuego) {
		// TODO Auto-generated method stub
		pedidoVideoRepo.save(pedidoVideojuego);
	}

	@Override
	public void eliminarPedidoVideojuego(int id) {
		pedidoVideoRepo.deleteById(id);
	}

}
