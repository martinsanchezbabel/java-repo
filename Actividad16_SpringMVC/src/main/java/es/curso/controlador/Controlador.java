package es.curso.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.service.UsuarioService;
import es.curso.modelo.service.VideojuegoService;
import es.curso.modelo.service.impl.UsuarioServiceImpl;
import es.curso.modelo.service.impl.VideojuegoServiceImpl;

//Para dar de alta un controlador  y que FrontController sepa localizarlo
//usaremos la anotacion @Controller
@Controller
public class Controlador {

	/**
	 * 
	 * 
	 * http://localhost:8080/Actividad16_SpringMVC/
	 * 
	 * 
	 */
	private VideojuegoService videoService = new VideojuegoServiceImpl();

	// Mediante la anotacion @RequestMapping (que es propia de MVC) podemos
	// mapear URLs
	@RequestMapping("verFormularioLogin")
	public String verFormulario() {
		// al devolver "formularioSaludo" usara el objeto viewResolver para formar
		// la direccion "/WEB-INF/vistas/formularioSaludo.jsp"
		return "login";
	}

	@RequestMapping(path = "login", method = RequestMethod.GET)
	public ModelAndView metodoLogin(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpServletRequest request, HttpSession session,
			ModelAndView mav) {

		UsuarioService userService = new UsuarioServiceImpl();

		if (userService.isUsuarioRegistered(username, password)) {
			String saludo = "Bienvenido " + username;

			mav.setViewName("redirect:verVideojuegos");

			mav.addObject("username", saludo);
		} else {
			mav.addObject("error", "Usuario o contrasena incorrectos!");
		}

		return mav;
	}

	@GetMapping("verVideojuegos")
	public String mostrarVideojuegos(@RequestParam("username") String username, Model model) {

		List<Videojuego> videojuegos = videoService.getAllVideojuegos();

		model.addAttribute("videojuegos", videojuegos);
		model.addAttribute("saludo", username);

		return "listarVideojuegos";
	}

	@GetMapping("detalleVideojuego")
	public String detalleVideojuego(@RequestParam("id") String id, Model model) {

		Integer idNumerico = Integer.parseInt(id);
		Videojuego videojuego = videoService.findVideojuegoById(idNumerico);
		model.addAttribute("videojuego", videojuego);
		model.addAttribute("id", id);
		return "videojuegoDetalle";
	}
}
