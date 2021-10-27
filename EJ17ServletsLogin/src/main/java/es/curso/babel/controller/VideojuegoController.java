package es.curso.babel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.service.VideojuegoService;
import es.curso.babel.model.service.impl.VideojuegoServiceImpl;

/**
 * Servlet implementation class VideojuegoController
 */
@WebServlet("/VideojuegoController")
public class VideojuegoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideojuegoService videoService = new VideojuegoServiceImpl();
       
    public VideojuegoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Videojuego> videojuegos = videoService.getAllVideojuegos();
		request.setAttribute("videojuegos", videojuegos);
		request.getRequestDispatcher("/videojuegos.jsp").forward(request, response);
	}

}
