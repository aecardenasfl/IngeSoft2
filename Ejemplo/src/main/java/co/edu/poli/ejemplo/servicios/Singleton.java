package co.edu.poli.ejemplo.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {

    // 1. Crear una variable estática para la instancia de la conexión
    private static Connection connection;

    // 2. Variables de configuración para la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/tienda";
    private static final String USER = "root";
    private static final String PASSWORD = "password123";

    // 3. Constructor privado para evitar instanciación fuera de la clase
    private Singleton() {
        // Lógica de inicialización si es necesario
    }

    // 4. Método estático para obtener la única instancia de la conexión
    public static Connection getConnection() throws SQLException {
        // Si la conexión aún no está creada, crearla
        if (connection == null || connection.isClosed()) {
            try {
                // Registrar el driver de MySQL (si es necesario)
                // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new SQLException("No se pudo conectar a la base de datos", e);
            }
        }
        return connection;
    }

    // Método para cerrar la conexión, si es necesario
    public static void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Cerrando conexión a la base de datos");
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }
}
