package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import domain.Cliente;
import domain.Genero;
import domain.Pelicula;
import domain.Valoracion;
import main.MainCine;

public class BaseDeDatos {

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
			for (Pelicula p : MainCine.getListaPeliculas()) {
				String nombre = p.getTitulo().replace(" ", "");
				st.executeUpdate(String.format(
						"CREATE TABLE IF NOT EXISTS Asientos%s (c1 String, c2 String, c3 String, c4 String, c5 String, c6 String, c7 String, c8 String, c9 String, c10 String)",
						nombre));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void setFilasAsientos(String nombrePelicula, String numeroAsiento) {// No creo que funcione
		try {
			Connection con = BaseDeDatos.initBD("deustoCine.db");
			Statement st = con.createStatement();

			String sql = String.format("UPDATE Asientos%s SET estado = 1 WHERE rowid = %d", nombrePelicula,
					numeroAsiento);
			st.executeUpdate(sql);

			st.close();
			BaseDeDatos.closeBD(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void crearFilasAsientos(String nombre) {
		try {
			Connection con = BaseDeDatos.initBD("deustoCine.db");
			Statement st = con.createStatement();

			// Verificar si ya existen filas en la tabla para esta película
			String countQuery = String.format("SELECT COUNT(*) FROM Asientos%s", nombre);
			ResultSet rs = st.executeQuery(countQuery);
			rs.next();
			int rowCount = rs.getInt(1);

			if (rowCount < 20) { // Verificar si hay menos de 20 filas
				int rowsToAdd = 20 - rowCount;
				for (int i = 0; i < rowsToAdd; i++) {
					String sql = String.format(
							"INSERT INTO Asientos%s (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0, 0)",
							nombre);
					st.executeUpdate(sql);
				}
			}

			st.close();
			BaseDeDatos.closeBD(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void anadirPelicula(String titulo, Genero genero, Valoracion estrellas) {
		String sql = String.format("INSERT INTO Pelicula VALUES('%s','%s','%s')", titulo, genero.toString(),
				estrellas.toString());

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

	public static void quitarCarritoDeCliente(String correo, String nombrePelicula) { // TODO probar si funciona
		String sql = String.format(
				"DELETE FROM Carrito WHERE ROWID IN (SELECT ROWID FROM Carrito WHERE correo = '%s' AND titulo = '%s' LIMIT 1)",
				correo, nombrePelicula);

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

	public static List<String> obtenerListaCarrito(String Correo) {
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

	public static ArrayList<String[]> obtenerAsientos(String pelicula) {
		String sql = String.format("SELECT * FROM Asientos%s", pelicula);
		List<String[]> l = new ArrayList<>();

		try {
			Connection con = BaseDeDatos.initBD("deustoCine.db");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			while (rs.next()) {
				String[] rowData = new String[columnsNumber];
				for (int i = 0; i < columnsNumber; i++) {
					rowData[i] = rs.getString(i + 1);
				}
				l.add(rowData);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<String[]>) l;
	}

	public static void editarAsientos(int[] rows, int[] columns, String pelicula) {
	    try {
	        Connection conn = BaseDeDatos.initBD("deustoCine.db");
	        Statement st = conn.createStatement();

	        for (int r : rows) {
                int rs = columns[r];

	            for (int i = 0; i < columns.length; i++) {
	                int c = columns[i];
	                String columnName = "c" + c;
	                String sql = String.format("UPDATE Asientos%s SET %s = 1 WHERE ID = %d", pelicula, columnName, r);
	                st.executeUpdate(sql);
	            }
	        }

	        st.close();
	        BaseDeDatos.closeBD(conn);
	    } catch (SQLException e) {
	        System.out.println("Error al actualizar los datos: " + e.getMessage());
	    }
	}

}
