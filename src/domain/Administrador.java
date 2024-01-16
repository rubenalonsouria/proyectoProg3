package domain;
import java.time.LocalDate;

public class Administrador extends Usuario {
	protected Cine cine;
	protected Pelicula peliculas;

	// Constructor
	public Administrador(String correo, String password, String nombre, String apellido, String dni,
			LocalDate fechaNacimineto, boolean admin) {
		super(correo, password, nombre, apellido, dni, fechaNacimineto, admin);
		admin = true;
		id = id + 1;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public Pelicula getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Pelicula peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public String toString() {
		return "Administrador [cine=" + cine + ", peliculas=" + peliculas + ", correo=" + correo + ", password="
				+ password + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimineto="
				+ fechaNacimineto + ", admin=" + admin + "]";
	}

	
	
	

}
