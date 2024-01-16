package domain;

public class Cine{
	/*Hay qeu repasar lo de las clases hijas y madres 
	 * ya que cada pelicula tiene contiene un cine y
	 * 
	 */

	protected String nombreCine;
	protected String descripcionCine;
	private String imagenCine;
	
	public Cine(String nombreCine, String imagenCine, String descripcionCine) {
		super();
		this.nombreCine = nombreCine;
		this.imagenCine = imagenCine;
		this.descripcionCine = descripcionCine;
	}

	public String getNombreCine() {
		return nombreCine;
	}

	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	public String getDescripcionCine() {
		return descripcionCine;
	}

	public void setDescripcionCine(String descripcionCine) {
		this.descripcionCine = descripcionCine;
	}

	public String getImagenCine() {
		return imagenCine;
	}

	public void setImagenCine(String imagenCine) {
		this.imagenCine = imagenCine;
	}

	@Override
	public String toString() {
		return "Cine [nombreCine=" + nombreCine + ", descripcionCine=" + descripcionCine + ", imagenCine=" + imagenCine
				+ "]";
	}
	
}
