package modelo.entidad;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Cliente {

	private int id;
	private String nombre;
	private int edad;
	private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();

	public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, int edad, ArrayList<Pedido> listaPedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.listaPedidos = listaPedidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", listaPedidos=" + listaPedidos + "]";
	}

}
