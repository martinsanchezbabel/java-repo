package es.curso.babel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.curso.babel.model.entity.Pedido;
import es.curso.babel.model.entity.Usuario;
import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.service.PedidoService;
import es.curso.babel.model.service.UsuarioService;
import es.curso.babel.model.service.VideojuegoService;

@Controller
@RequestMapping("videojuegos")
public class VideojuegoController {

	@Autowired
	private VideojuegoService videoService;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private UsuarioService userService;

	@Autowired
	private Usuario usuario;

	@GetMapping("")
	public ModelAndView getVideojuegos() {
		if (usuario.getUsername() == null) {
			return new ModelAndView("redirect:/login");
		}

		Pedido p = new Pedido();
		p.setUsuario(userService.findByUsername(usuario.getUsername()));
		System.out.println(userService.findByUsername(usuario.getUsername()));
		p.setTotalPedido(0);
		pedidoService.añadirPedido(p);

		ModelAndView modelView = new ModelAndView("videojuegos");
		modelView.addObject("videojuegos", videoService.getAllVideojuegos());
		return modelView;
	}

	@GetMapping("/detalle")
	public ModelAndView getVideojuegoDetalle(@RequestParam("id") int id) {
		if (usuario.getUsername() == null) {
			return new ModelAndView("redirect:/login");
		}
		ModelAndView modelView = new ModelAndView("videojuegoDetalle");
		modelView.addObject("videojuego", videoService.findVideojuegoById(id));
		return modelView;
	}

	@GetMapping("/delete")
	public String eliminarVideojuego(@RequestParam("id") int id, Model model) {
		if (usuario.getUsername() == null) {
			return "redirect:/login";
		}
		videoService.eliminarVideojuego(id);
		return "redirect:/videojuegos";
	}

	@GetMapping("/formVideojuego")
	public String getFormVideojuego(@RequestParam(required = false) Integer id, Model model) {

		if (usuario.getUsername() == null) {
			return "redirect:/login";
		}

		if (id != null) {
			model.addAttribute("videojuego", videoService.findVideojuegoById(id));
		} else {
			model.addAttribute("videojuego", new Videojuego());
		}
		return "formVideojuego";
	}

	@PostMapping("/doFormVideojuego")
	public String newVideojuego(Model model, @Valid @ModelAttribute Videojuego videojuego, BindingResult errors) {

		if (errors.hasErrors()) {
			return "formVideojuego";
		}

		videojuego.setImagen("imagen-default.jpg");

		videoService.añadirVideojuego(videojuego);

		return "redirect:/videojuegos";

	}

	// Usar el carrito de la compra
	@GetMapping("/addVideojuego")
	public String addVideojuego(@RequestParam("id") Integer id) {

		if (usuario.getUsername() == null) {
			return "redirect:/login";
		}

		// usuario.getListaVideojuegos().add(videoService.findVideojuegoById(id));
		return "redirect:/videojuegos";
	}

	@GetMapping("/removeVideojuego")
	public String removeVideojuego(@RequestParam("id") Integer id) {

		if (usuario.getUsername() == null) {
			return "redirect:/login";
		}

		// usuario.getListaVideojuegos().remove(videoService.findVideojuegoById(id));
		return "redirect:/videojuegos";
	}

	@GetMapping("/carritoCompra")
	public String getCarritoCompra(Model model) {
		if (usuario.getUsername() == null) {
			return "redirect:/login";
		}

		// model.addAttribute("listaCompra", usuario.getListaVideojuegos());
		// model.addAttribute("total", usuario.calcularTotal());
		return "listaCompra";
	}

	@GetMapping("/carritoCompra/comprar")
	public String hacerPedido() {

		if (usuario.getUsername() == null) {
			return "redirect:/login";
		}

		// usuario.getListaVideojuegos().clear();
		return "redirect:/videojuegos";
	}
}
