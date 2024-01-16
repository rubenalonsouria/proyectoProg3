package domain;

import java.util.ArrayList;

public class Entrada extends Pelicula{
//ESTA PROVISIONAL
	protected double precio;
	protected Cliente cliente;
	protected Sesion sesion;
	
	public Entrada(String titulo, int duracion, String sinopsis, ArrayList<String> actores,
			ArrayList<String> directores, Genero genero, Valoracion estrellas, double precio, Cliente cliente,
			Sesion sesion) {
		super(titulo, duracion, sinopsis, actores, directores, genero, estrellas);
		
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
	
	@Override
	public String toString() {
		return "Entrada [precio=" + precio + ", cliente=" + cliente + ", sesion=" + sesion + "]";
	}
	
	

}