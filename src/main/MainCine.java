package main;
import java.io.FileReader;
import java.util.Scanner;
import gui.VentanaPrincipal;


public class MainCine {
	
public static void main(String[] args) {
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
			
			//	mapaUsuarios.put(correo, values);
		}
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
