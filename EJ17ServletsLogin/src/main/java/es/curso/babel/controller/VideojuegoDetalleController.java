package es.curso.babel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.service.VideojuegoService;
import es.curso.babel.model.service.impl.VideojuegoServiceImpl;

@WebServlet("/VideojuegoDetalleController")
public class VideojuegoDetalleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideojuegoService videoService = new VideojuegoServiceImpl();

	public VideojuegoDetalleController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Videojuego videojuego = videoService.findVideojuegoById(id);
		request.setAttribute("videojuego", videojuego);
		request.getRequestDispatcher("/videojuegoDetalle.jsp").forward(request, response);
	}

}
