package clasesEnDesuso;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class CrearBaseDeDatosSQLite {

	    public static void main(String[] args) {
	        // URL de conexión con la base de datos SQLite
	        String url = "jdbc:sqlite:/Users/ikerClase/Desktop/prueba.db";
	      
	        // Intenta establecer la conexión con la base de datos
	        try {  
	        	Class.forName("org.sqlite.JDBC");
	        	Connection conn = DriverManager.getConnection(url); 
	            if (conn != null) {
	                System.out.println("Conexión exitosa a la base de datos SQLite");
	                
	                // Sentencia para crear una tabla en la base de datos
	                String sql = "CREATE TABLE IF NOT EXISTS Ejemplo (" +
	                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
	                        "nombre TEXT NOT NULL," +
	                        "edad INTEGER);";
	                
	                // Ejecuta la sentencia SQL
	                Statement stmt = conn.createStatement();
	                stmt.execute(sql);
	                System.out.println("Tabla creada exitosamente");
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}

