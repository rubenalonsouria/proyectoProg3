package Entradas;

import java.time.LocalDate;

import javax.swing.JFrame;

import Cine.Cine;
import Pelicula.Pelicula;
import Usuarios.Cliente;
import Usuarios.MetodoDePago;

public class Compra {
	protected static int idCompra;
	protected LocalDate fechaCompra;
	protected Cliente cliente;
	protected int NumeroEntradas;
	protected MetodoDePago metodoDePago;
	protected double totalCompra;
	protected Cine cine;
	protected Pelicula pelicula;
	protected Entrada entrada;
	// Metodos

	private double calcularPrecioSinDescuentos() {
		/*
		 * TODO En ventana compra hay que hacer un .showMessage que salga si el cliente
		 * tiene algun tipo de descuento, ejemplo los puntos, seguir almacenando o
		 * gastar, tambien el descuento de cumpleanos o si no es con showMessage hacerlo
		 * de manera mas intuitiva con un checkbox y que seleccione si quiere aplicar
		 * los descuentos disponibles en su cuenta.
		 */
		return entrada.getPrecio() * NumeroEntradas;
	}

	// Constructor
	public Compra(LocalDate fechaCompra, Cliente cliente, int numeroEntradas, MetodoDePago metodoDePago,
			double totalCompra, Cine cine, Pelicula pelicula) {
		super();
		this.fechaCompra = fechaCompra;
		this.cliente = cliente;
		NumeroEntradas = numeroEntradas;
		this.metodoDePago = metodoDePago;
		this.totalCompra = totalCompra;
		this.cine = cine;
		this.pelicula = pelicula;
		idCompra = idCompra + 1;
	}

//Getters y Setters
	public static int getIdCompra() {
		return idCompra;
	}

	public static void setIdCompra(int idCompra) {
		Compra.idCompra = idCompra;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumeroEntradas() {
		return NumeroEntradas;
	}

	public void setNumeroEntradas(int numeroEntradas) {
		NumeroEntradas = numeroEntradas;
	}

	public MetodoDePago getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(MetodoDePago metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	public double getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	// ToString
	@Override
	public String toString() {
		return "Compra [fechaCompra=" + fechaCompra + ", cliente=" + cliente + ", NumeroEntradas=" + NumeroEntradas
				+ ", metodoDePago=" + metodoDePago + ", totalCompra=" + totalCompra + ", cine=" + cine + ", pelicula="
				+ pelicula + "]";
	}

}
