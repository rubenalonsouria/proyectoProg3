package domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Comentario extends Pelicula{
	//Los comentarios los puede eliminar el administrador si no son adecuados
	protected Usuario usuario;
	protected String texto;
	protected LocalDate fecha;
	
	public Comentario(String titulo, int duracion, String sinopsis, ArrayList<String> actores,
			ArrayList<String> directores, Genero genero, Valoracion estrellas, Usuario usuario, String texto,
			LocalDate fecha) {
		super(titulo, duracion, sinopsis, actores, directores, genero, estrellas);
		
		this.usuario = usuario;
		this.texto = texto;
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Comentario [usuario=" + usuario + ", texto=" + texto + ", fecha=" + fecha + "]";
	}
	
	
	
}
