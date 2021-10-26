package es.curso.modelo.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.modelo.entidad.Usuario;
import es.curso.modelo.negocio.GestorUsuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GestorUsuario gu = new GestorUsuario();

		String nombre = request.getParameter("username");
		String contrasena = request.getParameter("password");

		System.out.println(nombre + contrasena);
		boolean comprobar = gu.autenticarUsuario(nombre, contrasena);

		if (comprobar == true) {
			// Podemos pasarle a la vista toda la informacion que queramos
			// mediante atributos clave-valor (Map)

			// Le decimos al servlet que vista queremos elegir
			response.sendRedirect("/Actividad15_Web/VideojuegoServlet");
		} else {
			request.getRequestDispatcher("errorUsuario.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
