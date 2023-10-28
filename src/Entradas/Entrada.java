package Entradas;

import Cine.Sesion;
import Pelicula.Pelicula;
import Usuarios.Cliente;

public class Entrada extends Pelicula{
//PENSAR MEJOR ATRIBUTOS ESTA PROVISIONAL
	protected double precio;
	protected Cliente cliente;
	protected Sesion sesion;
	
	
	
	
	
	public Entrada(double precio, Cliente cliente, Sesion sesion) {
		super();
		this.precio = precio;
		this.cliente = cliente;
		this.sesion = sesion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Sesion getSesion() {
		return sesion;
	}
	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}
	
	

}
