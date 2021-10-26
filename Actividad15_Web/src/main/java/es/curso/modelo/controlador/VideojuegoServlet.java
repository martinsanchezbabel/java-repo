package es.curso.modelo.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.negocio.GestorVideojuego;

/**
 * Servlet implementation class VideojuegiServlet
 */
@WebServlet("/VideojuegoServlet")
public class VideojuegoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideojuegoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GestorVideojuego gv = new GestorVideojuego();

		List<Videojuego> listaVideojuegos = gv.listar();
		System.out.println(listaVideojuegos);

		// Podemos pasarle a la vista toda la informacion que queramos
		// mediante atributos clave-valor (Map)
		request.setAttribute("lista", listaVideojuegos);

		// Le decimos al servlet que vista queremos elegir
		request.getRequestDispatcher("listadoVideojuegos.jsp").forward(request, response);

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
