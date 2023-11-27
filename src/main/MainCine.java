package main;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

import Pelicula.Genero;
import Pelicula.Pelicula;
import Usuarios.Administrador;
import Usuarios.Cliente;
import gui.VentanaMetodoDePago;
import gui.VentanaPrincipal;

public class MainCine {
	private static ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
	private static ArrayList<Cliente> listaClientes = new ArrayList<>();
	private static ArrayList<Administrador> listaAdministradores = new ArrayList<>();
	private static Map<String, String[]> mapaCorreoValoresUsuarios = new HashMap<>();
	static Logger logger = Logger.getLogger(MainCine.class.getName());

	public ArrayList<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public Map<String, String[]> getMapaUsuarios() {
		return mapaCorreoValoresUsuarios;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public ArrayList<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

	public static void main(String[] args) {
		// Logger
		logger.setLevel(Level.ALL);
		try {
			logger.log(Level.INFO, "Cargando DeustoCine...");
		} catch (Exception e) {

			e.printStackTrace();
		}
		// Ejemplos de logger
		// logger.info("Se ha mostrado un mensaje en consola");
		// logger.warning("Mensaje de warning"); logger.severe("Mensaje de error");

		// Carga de peliculas
		try {
			Scanner sc = new Scanner(new FileReader("Ficheros/peliculas"));
			String primeraLinea = sc.nextLine(); // Primera linea no la queremos
			String linea;
			while (sc.hasNext()) {
				linea = sc.nextLine();
				// Descompongo la linea
				String[] partes = linea.split(";");
				String titulo = partes[0];
				int duracion = Integer.parseInt(partes[1]);
				String sipnosis = partes[2];

				// Convierto el Array que es un string de actores en ArrayList
				String actoresString = partes[3];
				String[] actores = actoresString.split(",");
				ArrayList<String> actoresArray = new ArrayList<>();

				for (String actor : actores) {
					actoresArray.add(actor);
				}

				// Convierto el Array que es un string de directores en ArrayList
				String directoresString = partes[4];
				String[] directores = directoresString.split(",");
				ArrayList<String> directoresArray = new ArrayList<>();

				for (String director : directores) {
					directoresArray.add(director);
				}

				// convertir los Strings en el Enum (Consultado a una IA)
				Genero genero = Genero.valueOf(partes[5]);

				/*
				 * Hay que pensar que hacemos al principio cuando leemos las peliculas del
				 * fichero: (De momento a null)
				 * 
				 * * Por defecto que salga ha 5 y despues que el usuario despues de verla, lo
				 * valore y al cerrar la applicacion que se guarde en el fichero.
				 * 
				 */

				// Valoracion valoracion = Valoracion.valueOf(partes[6]);

				// Creo la pelicula y la añado a la lista
				Pelicula peli = new Pelicula(titulo, duracion, sipnosis, actoresArray, directoresArray, genero, null) {
				};
				listaPeliculas.add(peli);
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Carga de Usuarios
		try {

			Scanner sc = new Scanner(new FileReader("Ficheros/usuarios"));
			String primeraLinea = sc.nextLine(); // Primera linea no la queremos
			String usuarioLinea;

			while (sc.hasNext()) {
				usuarioLinea = sc.nextLine();
				String[] partes = usuarioLinea.split(",");
				String correo = partes[0];
				String contrasena = partes[1];
				String admin = partes[7];
				String[] values = { contrasena, admin };
				mapaCorreoValoresUsuarios.put(correo, values); // Este mapa lo utilizaremos para la clase iniciar Sesion

				// Listas Cliente y Admin
				String nombre = partes[2];
				String apellidos = partes[3];
				String dni = partes[4];
				Date fechaNacimiento = null; // Hay queu cambiar la fecha
				int tlf = Integer.parseInt(partes[6]);

				if (admin.equals("true")) {
					Administrador usuario = new Administrador(correo, contrasena, nombre, apellidos, dni, null, true) {
					};
					listaAdministradores.add(usuario);
				} else {
					Cliente usuario = new Cliente(correo, contrasena, nombre, apellidos, dni, null, tlf, false) {
					};
					listaClientes.add(usuario);
				}

			}
			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// iniciar ventana
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		VentanaMetodoDePago v = new VentanaMetodoDePago();

	}

}
