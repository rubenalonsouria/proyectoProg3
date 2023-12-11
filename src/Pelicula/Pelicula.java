package Pelicula;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Pelicula{//Abstracta por qeu ????
	
	protected String titulo;
	protected ImageIcon poster;
	protected int duracion;
	protected String sinopsis;
	protected ArrayList<String> actores = new ArrayList<>();
	protected ArrayList<String> directores = new ArrayList<>();
	protected Genero genero;
	protected Valoracion estrellas; // Hay que crear en la ventana que se visualice por estrellas
	
	public Pelicula(String titulo, int duracion, String sinopsis, ArrayList<String> actores,
			ArrayList<String> directores, Genero genero, Valoracion estrellas) {
		super();
		
		this.titulo = titulo;
		this.duracion = duracion;
		this.sinopsis = sinopsis;
		this.actores = actores;
		this.directores = directores;
		this.genero = genero;
		this.estrellas = estrellas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public ImageIcon getPoster() {
		return poster;
	}

	public void setPoster(ImageIcon poster) {
		this.poster = poster;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public ArrayList<String> getActores() {
		return actores;
	}

	public void setActores(ArrayList<String> actores) {
		this.actores = actores;
	}

	public ArrayList<String> getDirectores() {
		return directores;
	}

	public void setDirectores(ArrayList<String> directores) {
		this.directores = directores;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Valoracion getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Valoracion estrellas) {
		this.estrellas = estrellas;
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", duracion=" + duracion + ", sinopsis=" + sinopsis + ", actores="
				+ actores + ", directores=" + directores + ", genero=" + genero + ", estrellas=" + estrellas + "]";
	}
	
}
