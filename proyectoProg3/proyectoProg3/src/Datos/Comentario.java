package Datos;

import java.time.LocalDate;

public class Comentario extends Pelicula{
	//Los comentarios los puede eliminar el administrador si no son adecuados
	protected Usuario usuario;
	protected String texto;
	protected LocalDate fecha;
}
