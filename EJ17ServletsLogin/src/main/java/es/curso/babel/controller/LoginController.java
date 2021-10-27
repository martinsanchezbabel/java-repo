package es.curso.babel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.babel.model.service.UsuarioService;
import es.curso.babel.model.service.impl.UsuarioServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService userService = new UsuarioServiceImpl();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (userService.isUsuarioRegistered(username, password)) {
			request.setAttribute("username", username);
			request.getRequestDispatcher("/VideojuegoController").forward(request, response);
		} else {
			request.setAttribute("error", "Unknown user, please try again");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}		
		
	}

}
