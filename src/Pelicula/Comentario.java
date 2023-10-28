package Pelicula;

import java.time.LocalDate;

import Usuarios.Usuario;

public class Comentario extends Pelicula{
	//Los comentarios los puede eliminar el administrador si no son adecuados
	protected Usuario usuario;
	protected String texto;
	protected LocalDate fecha;
}
