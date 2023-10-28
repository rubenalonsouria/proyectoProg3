package Pelicula;

import java.util.ArrayList;

import Cine.Cine;
import Entradas.Entrada;

public abstract class Pelicula extends Cine{
	
	protected String titulo;
	protected int duracion;
	protected String sinopsis;
	protected ArrayList<String> actores = new ArrayList<>();
	protected ArrayList<String> directores = new ArrayList<>();
	protected Genero genero;
	protected Valoracion estrellas; // Hay que crear en la ventana que se visualice por estrellas.
	
	
	
	
}
