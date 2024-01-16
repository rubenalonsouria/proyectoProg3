package domain;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cliente extends Usuario{
	
	protected int numeroTelefono;
	protected MetodoDePago metodoDePago;//Esto no en el momento de creacion del cliente sera null
	//protected int numeroTarjeta;		//Una vez que reserve se pediran datos depago y se actualizaran.
	protected int puntos;	//Por cada compra almacena puntos que 100 = 1$ de descuento
	protected Map<Pelicula, ArrayList<Compra>> historialDeCompras; //Almacenaremos la Pelicula como clave y en la ArrayList
																   //guardaremos las compras para esa pelicula.
	
	//constructor
	public Cliente(String correo, String password, String nombre, String apellido, String dni,
			LocalDate fechaNacimineto, int numeroTelefono, boolean admin){
		super(correo, password, nombre, apellido, dni, fechaNacimineto, admin);
		
		this.numeroTelefono = numeroTelefono;
		this.metodoDePago = null;
		//this.numeroTarjeta = 0;
		this.puntos = 0;
		this.historialDeCompras = new HashMap<>();
		this.admin = false;
		id = id+1;
	}
	
	//Setters y Getters
	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public MetodoDePago getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(MetodoDePago metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	/*
	 * public int getNumeroTarjeta() { return numeroTarjeta; }
	 * 
	 * public void setNumeroTarjeta(int numeroTarjeta) { this.numeroTarjeta =
	 * numeroTarjeta; }
	 */

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Map<Pelicula, ArrayList<Compra>> getHistorialDeCompras() {
		return historialDeCompras;
	}

	public void setHistorialDeCompras(Map<Pelicula, ArrayList<Compra>> historialDeCompras) {
		this.historialDeCompras = historialDeCompras;
	}
	//ToString

	@Override
	public String toString() {
		return "Cliente [numeroTelefono=" + numeroTelefono + ", metodoDePago=" + metodoDePago //+ ", numeroTarjeta="+ numeroTarjeta 
				+ ", puntos=" + puntos + ", historialDeCompras=" + historialDeCompras + ", correo="
				+ correo + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaNacimineto=" + fechaNacimineto + ", admin=" + admin + "]";
	}
	
	
}
