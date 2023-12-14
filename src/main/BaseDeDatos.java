package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Pelicula.Genero;
import Pelicula.Valoracion;
import Usuarios.Cliente;

public class BaseDeDatos {
	/*
	 * Al ejecutar una sentencia sql tenemos 2 opciones: - Modificar la base de
	 * datos: CREATE TABLE, UPDATE, DELETE, INSERT, DROP, MODIFY
	 * st.executeUpdate(sql);
	 * 
	 * - No modifica la base de datos, sólo accede al contenido: SELECT ResultSet rs
	 * = st.executeQuery(sql);
	 */

	/*
	 * Cuando se captura una excepción podemos hacer 2 cosas:
	 * 
	 * - Darle tratamiento a esa excepción en el catch - Propagar la excepción -> Si
	 * un método propaga una excepción,lo tiene que indicar en la cabecer
	 * 
	 */

	public static Connection initBD(String nomBD) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:ficheros/" + nomBD);

			// con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
			// String url = "proyectoProg3/sqlite-jdbc-3.44.1.0.jar"; //PARA Windows
			// String url = "proyectoProg3/slf4j-api-2.0.9.jar"; //PARA
			// Mac"jdbc:sqlite:/slf4j-api-2.0.9.jar/"

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeBD(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void crearTablas(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Cliente (correo String, nombre String, metodoDePago String, historialDeCompras String)";
		String sql2 = "CREATE TABLE IF NOT EXISTS Pelicula (titulo String, genero Genero, estrellas Valoracion)";
		String sql3 = "CREATE TABLE IF NOT EXISTS Carrito(correo String, titulo String)";
		// Añadir sesiones y y qeu la de carrito salga el precio de la sesion y mas
		// cosas

		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void anadirPelicula(String titulo, Genero genero, Valoracion estrellas) {
		String sql = String.format("INSERT INTO Pelicula VALUES('%s','%s','%s')", titulo, genero.toString(),
				estrellas.toString());
		// String sql = "INSERT INTO Pelicula (titulo, genero, estrellas) VALUES (?, ?,
		// ?)";

		try {
			Connection con = BaseDeDatos.initBD("deustoCine.db");
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
			BaseDeDatos.closeBD(con);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void anadirCarritoDeCliente(String correo, String nombrePelicula) { // TODO probar si funciona
		String sql = String.format("insert into Carrito values('%s','%s')", correo, nombrePelicula);
		try {
			Connection con = BaseDeDatos.initBD("deustoCine.db");
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
			BaseDeDatos.closeBD(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void quitarCarritoDeCliente(String dni, String nombrePelicula) { // TODO probar si funciona
		String sql = String.format("delete from Carrito where correo = '%s' and titulo = '%s'", dni, nombrePelicula);
		try {
			Connection con = BaseDeDatos.initBD("deustoCine.db");
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
			BaseDeDatos.closeBD(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void anadirCliente(Cliente c) {
		String metodoPago = "";

		if (c.getMetodoDePago() == null) {
			metodoPago = null;
		} else {
			metodoPago = c.getMetodoDePago().toString();
		}

		String sql = String.format("insert into Cliente values('%s','%s','%s','%s')", c.getCorreo(), c.getNombre(),
				metodoPago, c.getHistorialDeCompras().toString());

		try {
			Connection con = BaseDeDatos.initBD("deustoCine.db");
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
			BaseDeDatos.closeBD(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void borrarTodosLosClientes() {
		String sql = "delete from Cliente";

		try {
			Connection coon = BaseDeDatos.initBD("deustoCine.db");
			Statement st = coon.createStatement();
			st.execute(sql);
			st.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void borrarTodasLasPeliculas(Connection con) {
		String sql = "delete from Pelicula";

		try {
			Statement st = con.createStatement();
			st.execute(sql);
			st.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/* Devuelve una lista con las personas de la tabla Persona */
	public static List<Cliente> obtenerListaClientes(Connection con) {// TODO probar si funciona
		String sql = "SELECT * FROM Cliente";
		List<Cliente> l = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String correo = rs.getString("correo");
				for (Cliente cliente : MainCine.getListaClientes()) {
					if (cliente.getCorreo().equals(correo)) {
						l.add(cliente);
						break;
					}
				}
				rs.close();
				st.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	public static List<String> obtenerListaCarrito(String Correo) {// TODO probar si funciona
		String sql = String.format("SELECT titulo FROM Carrito where correo ='%s'", Correo);
		List<String> l = new ArrayList<>();

		try {
			Connection con = BaseDeDatos.initBD("deustoCine.db");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String titulo = rs.getString("titulo");
				l.add(titulo);

				
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

}
