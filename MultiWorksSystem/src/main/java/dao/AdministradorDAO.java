package dao;

import model.Administrador;
import util.DBConnection;
import util.SeguridadUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// DAO para manejo de autenticación del Administrador (Solo existe un Administrador en el Sistema)
public class AdministradorDAO {

    /**
     * Valida las credenciales ingresadas usando SeguridadUtil (BCrypt)
     * @param usuario nombre de usuario ingresado
     * @param contrasenaIngresada contraseña en texto plano ingresada
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean validarCredenciales(String usuario, String contrasenaIngresada) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT contrasenaAdmin FROM administrador WHERE usuarioAdmin = ?")) {

            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashGuardado = rs.getString("contrasenaAdmin");
                return SeguridadUtil.verificarPassword(contrasenaIngresada, hashGuardado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Obtiene el objeto Administrador por su nombre de usuario
     * @param usuario nombre de usuario
     * @return objeto Administrador o null si no se encuentra
     */
    public Administrador obtenerPorUsuario(String usuario) {
        Administrador admin = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM administrador WHERE usuarioAdmin = ?")) {

            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                admin = new Administrador();
                admin.setIdAdministrador(rs.getInt("idAdministrador"));
                admin.setUsuarioAdmin(rs.getString("usuarioAdmin"));
                admin.setContrasenaAdmin(rs.getString("contrasenaAdmin")); // opcional
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return admin;
    }
}
