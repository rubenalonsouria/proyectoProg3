package domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sesion extends Pelicula{
	//La sesion es de pelicula, qeu seran las horas en las que estara disponible
	
	//protected Pelicula pelicula;no hace falta por que su madre es pelicula
	protected Sala sala;
	protected LocalDate fecha;
	protected boolean variable3D;
	


	public Sesion(String titulo, int duracion, String sinopsis, ArrayList<String> actores, ArrayList<String> directores,
			Genero genero, Valoracion estrellas, Sala sala, LocalDate fecha, boolean variable3d) {
		super(titulo, duracion, sinopsis, actores, directores, genero, estrellas);
		
		this.sala = sala;
		this.fecha = fecha;
		variable3D = variable3d;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isVariable3D() {
		return variable3D;
	}

	public void setVariable3D(boolean variable3d) {
		variable3D = variable3d;
	}

	@Override
	public String toString() {
		return "Sesion [sala=" + sala + ", fecha=" + fecha + ", variable3D=" + variable3D + "]";
	}
	
	
	
}
