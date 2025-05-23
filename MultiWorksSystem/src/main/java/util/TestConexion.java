package util;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("✅ ¡Conexión exitosa a MySQL!");
            con.close();
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
    }
}
