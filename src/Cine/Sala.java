package Cine;

import java.util.ArrayList;

public class Sala extends Cine{
	 protected ArrayList<Integer> numerosButacas; //Lista de todos los numeros de butacs que hay en esta sala
	 protected int numSala; //Numero de la sala (identificativo)
	
	 public Sala(String nombreCine, String localizacion, ArrayList<Integer> numerosButacas, int numSala) {
		super(nombreCine, localizacion);
		
		this.numerosButacas = numerosButacas;
		this.numSala = numSala;
	}

	public ArrayList<Integer> getNumerosButacas() {
		return numerosButacas;
	}

	public void setNumerosButacas(ArrayList<Integer> numerosButacas) {
		this.numerosButacas = numerosButacas;
	}

	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}

	@Override
	public String toString() {
		return "Sala [numerosButacas=" + numerosButacas + ", numSala=" + numSala + "]";
	}
	 
	 
	 
}
