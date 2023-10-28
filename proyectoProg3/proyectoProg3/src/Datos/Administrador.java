package Datos;

import java.time.LocalDate;

public class Administrador extends Usuario {
	protected Cine cine;
	protected Pelicula peliculas;

	// Constructor
	public Administrador(String correo, String password, String nombre, String apellido, String dni,
			LocalDate fechaNacimineto) {
		super(correo, password, nombre, apellido, dni, fechaNacimineto);
		id = id + 1;
	}

}
