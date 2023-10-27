package Datos;

import java.time.LocalDate;

public class Sesion extends Pelicula{
	//La sesion es de pelicula, qeu seran las horas en las que estara disponible
	//Pero no se si mejor que fuera hija de cine.
	// Igual mejor de cine

	protected Pelicula pelicula;
	protected int numSala;
	protected LocalDate fecha;
	protected boolean variable3D;
}
