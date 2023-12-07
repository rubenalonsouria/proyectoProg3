package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteExample {

    // Ruta de la base de datos SQLite
    static final String DB_URL = "jdbc:sqlite:/Users/ikerClase/Desktop/prueba.db";
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection(DB_URL);

            // Crear una tabla en la base de datos (solo como ejemplo)
            createTable(connection);

            // Insertar datos en la tabla
            insertData(connection);

            // Consultar los datos insertados
            selectData(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Crear una tabla en la base de datos
    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Ejemplo (id INTEGER PRIMARY KEY, nombre TEXT, edad INTEGER)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    }

    // Insertar datos en la tabla
    private static void insertData(Connection connection) throws SQLException {
        String sql = "INSERT INTO Ejemplo (nombre, edad) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "Juan");
            statement.setInt(2, 30);
            statement.executeUpdate();
        }
    }

    // Consultar los datos insertados
    private static void selectData(Connection connection) throws SQLException {
        String sql = "SELECT * FROM Ejemplo";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int edad = resultSet.getInt("edad");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
            }
        }
    }
}

