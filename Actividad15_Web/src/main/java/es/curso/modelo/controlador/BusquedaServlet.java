package es.curso.modelo.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.negocio.GestorVideojuego;

/**
 * Servlet implementation class BusquedaServlet
 */
public class BusquedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BusquedaServlet() {
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

		String id = request.getParameter("id");

		int idNumerico = Integer.parseInt(id);

		Videojuego v = gv.obtener(idNumerico);

		if (v != null) {
			// Podemos pasarle a la vista toda la informacion que queramos
			// mediante atributos clave-valor (Map)
			request.setAttribute("v", v);

			// Le decimos al servlet que vista queremos elegir
			request.getRequestDispatcher("detallePelicula.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("errorPelicula.jsp").forward(request, response);
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
