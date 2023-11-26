package main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

import Pelicula.Pelicula;
import gui.VentanaPrincipal;


public class MainCine {
	private ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
	static Logger logger = Logger.getLogger(MainCine.class.getName());
	
public static void main(String[] args) {
	
	//Logger
	logger.setLevel(Level.ALL); 
	try {
		logger.log(Level.INFO, "Cargando DeustoCine...");
	} catch (Exception e) {

		e.printStackTrace();
	}
	
	//Cargar todo lo que esta en ficheros
	
	try {
		Scanner sc = new Scanner(new FileReader("Ficheros/peliculas"));
		String pelicula = sc.nextLine(); // Primera linea no la queremos
		String linea;
		while (sc.hasNext()) {
			linea = sc.nextLine();
			String[] partes = linea.split(",");
			String titulo = partes[0];
			String duracion = partes[1];
			String sipnosis = partes[2];
			String actoresArray = partes[3];
			String directoresArray = partes[4];
			String genero = partes[5];
			String valoracion = partes[6];
			//Hay que pasar los strings a lo que pida la clase
		//	new Pelicula(titulo, Integer.parseInt(duracion), sipnosis, actoresArray, directoresArray, genero, valoracion) {
			};
			//	mapaUsuarios.put(correo, values);
	//	}
		sc.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
		

	
		//iniciar ventana
	//VentanaPrincipalTesting ventanaPrincipalTesting = new VentanaPrincipalTesting();
	VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
	//VentanaPrincipalAdminTesting ventanaAdminTest= new VentanaPrincipalAdminTesting();
	//VentanaIdentificarse v = new VentanaIdentificarse();
	//VentanaIniciarSesionTesting ventanaIniciarSesionTesting = new VentanaIniciarSesionTesting();
	//WindowBuilder v = new WindowBuilder();
	

}

}
