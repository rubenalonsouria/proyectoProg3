package main;

import java.io.FileReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
import db.BaseDeDatos;
import domain.Administrador;
import domain.Cliente;
import domain.Genero;
import domain.Pelicula;
import domain.Valoracion;
import gui.VentanaPricipalNueva;

public class MainCine {
	private static ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
	private static ArrayList<Cliente> listaClientes = new ArrayList<>();
	private static ArrayList<Administrador> listaAdministradores = new ArrayList<>();
	private static Map<String, String[]> mapaCorreoValoresUsuarios = new HashMap<>();
	static Logger logger = Logger.getLogger(MainCine.class.getName());

	public static ArrayList<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public static Map<String, String[]> getMapaUsuarios() {
		return mapaCorreoValoresUsuarios;
	}

	public static ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public static ArrayList<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

	public static void cargarPeliculas() {
		listaPeliculas.clear();

		Connection con = BaseDeDatos.initBD("deustoCine.db");
		BaseDeDatos.borrarTodasLasPeliculas(con);
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

				// Creo la pelicula y la añado a la lista
				Pelicula peli = new Pelicula(titulo, duracion, sipnosis, actoresArray, directoresArray, genero, null) {
				};
				BaseDeDatos.anadirPelicula(titulo, genero, Valoracion.ACEPTABLE);
				BaseDeDatos.closeBD(con);
				listaPeliculas.add(peli);
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cargaDeUsuarios() {
		mapaCorreoValoresUsuarios.clear();
		listaAdministradores.clear();
		listaClientes.clear();

		BaseDeDatos.borrarTodosLosClientes();
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
					Administrador adminU = new Administrador(correo, contrasena, nombre, apellidos, dni, null, true) {
					};
					listaAdministradores.add(adminU);
				} else {
					Cliente cliente = new Cliente(correo, contrasena, nombre, apellidos, dni, null, tlf, false) {
					};
					listaClientes.add(cliente);
					BaseDeDatos.anadirCliente(cliente);

				}

			}
			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// Logger
		logger.setLevel(Level.ALL);
		logger.log(Level.INFO, "Cargando DeustoCine...");

		// Ejemplos de logger
		// logger.info("Se ha mostrado un mensaje en consola");
		// logger.warning("Mensaje de warning"); logger.severe("Mensaje de error");

		/* METODOS */

		cargarPeliculas();
		cargaDeUsuarios();

		/* BASE DE DATOS */
		Connection con = BaseDeDatos.initBD("deustoCine.db");
		BaseDeDatos.crearTablas(con);
		for (Pelicula p : listaPeliculas) {
			String n = p.getTitulo().replace(" ", "");
			BaseDeDatos.crearFilasAsientos(n);
		}
		BaseDeDatos.closeBD(con);
		/* VENTANA */
		new VentanaPricipalNueva();

	}

}
