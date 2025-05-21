package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Cambia estos valores según tu configuración local
    private static final String URL = "jdbc:mysql://localhost:3306/multiworksdb"; // Nombre de la Base de Datos
    private static final String USER = "root"; // Usuario de MySQL
    private static final String PASSWORD = "tu_contraseña"; // Contraseña de MySQL

    // Método para obtener una conexión
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
