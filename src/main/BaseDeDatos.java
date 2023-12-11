package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Usuarios.Cliente;

public class BaseDeDatos {
	
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			//String url = "proyectoProg3/sqlite-jdbc-3.44.1.0.jar"; //PARA Windows
			String url = "proyectoProg3/slf4j-api-2.0.9.jar"; //PARA Mac
            
			// create a connection to the database
            con = DriverManager.getConnection(url);
			System.out.println("si");
		} catch (Exception e) {
			e.printStackTrace();
		} catch (ExceptionInInitializerError e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeBD(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*Al ejecutar una sentencia sql tenemos 2 opciones:
	  - Modificar la base de datos: CREATE TABLE, UPDATE, DELETE, INSERT, DROP, MODIFY
	  				st.executeUpdate(sql);
	  				
	  - No modifica la base de datos, sólo accede al contenido: SELECT
	                ResultSet rs = st.executeQuery(sql);
	  */
	
	/*Cuando se captura una excepción podemos hacer 2 cosas:
	 * 
	 * - Darle tratamiento a esa excepción en el catch
	 * - Propagar la excepción -> Si un método propaga una excepción,lo tiene que indicar en la cabecer
	 * 
	 * */
	public static void crearTablas(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Cliente (dni String, nombre String)";
		String sql2 = "CREATE TABLE IF NOT EXISTS Pelicula (titulo String, genero Genero, estrellas Valoracion)";
		String sql3 = "CREATE TABLE IF NOT EXISTS Carrito(dni String, titulo String)";
		//Añadir sesiones y y qeu la de carrito salga el precio de la sesion y mas cosas
		
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
	
	/*Devuelve una lista con las personas de la tabla Persona*/
	public static List<Cliente> obtenerListaPersonas(Connection con){
		String sql = "SELECT * FROM Cliente";
		List<Cliente> l = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String dni = rs.getString("dni");
				String nom = rs.getString("nombre");
				Cliente c = new Cliente(dni, null, nom, null, null, null, 0, false);
				l.add(c);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public static List<String> obtenerListaCarrito(Connection con, String dni){
		String sql = String.format("SELECT * FROM Carrito WHERE dni='%s'", dni);
		List<String> l = new ArrayList<>();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String titulo = rs.getString("nombre");
				l.add(titulo);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	/*public static List<Compra> obtenerComprasPersona(Connection con, String dni){
		//String sql = String.format("SELECT * FROM Compra WHERE dni='%s'", dni);
		String sql = String.format("SELECT C.idC,C.id,C.unidades,C.fecha,A.precio FROM Compra C, Articulo a "
				+ "WHERE C.id = A.id AND C.dni='%s'", dni);
		List<Compra> l = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int idC = rs.getInt("idC");
				int id = rs.getInt("id");
				int unidades = rs.getInt("unidades");
				String fecha = rs.getString("fecha");
				double precio = rs.getDouble("precio");
				Compra c = new Compra(idC, dni, id, unidades, fecha, (float)(unidades*precio));
				l.add(c);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public static void borrarCompra(Connection con, int idC) {
		String sql = String.format("DELETE FROM Compra WHERE idC=%d", idC);
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
			
}

