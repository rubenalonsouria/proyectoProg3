package Cine;

public abstract class Cine{
	/*Hay qeu repasar lo de las clases hijas y madres 
	 * ya que cada pelicula tiene contiene un cine y
	 * 
	 */

	protected String nombreCine;
	protected String localizacion;
	
	public Cine(String nombreCine, String localizacion) {
		super();
		this.nombreCine = nombreCine;
		this.localizacion = localizacion;
	}

	public String getNombreCine() {
		return nombreCine;
	}

	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	@Override
	public String toString() {
		return "Cine [nombreCine=" + nombreCine + ", localizacion=" + localizacion + "]";
	}
	
	
}
