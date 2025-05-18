package dao;

import model.Administrador;
import util.DBConnection;
import util.SeguridadUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDAO {

    public boolean validarCredenciales(String usuario, String contrasenaPlano) {
        String sql = "SELECT * FROM administradores WHERE usuarioAdmin = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashAlmacenado = rs.getString("contrasenaAdmin");
                return SeguridadUtil.validar(contrasenaPlano, hashAlmacenado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Administrador obtenerPorUsuario(String usuario) {
        String sql = "SELECT * FROM administradores WHERE usuarioAdmin = ?";
        Administrador admin = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                admin = new Administrador();
                admin.setIdAdministrador(rs.getInt("idAdministrador"));
                admin.setUsuarioAdmin(rs.getString("usuarioAdmin"));
                admin.setContrasenaAdmin(rs.getString("contrasenaAdmin"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
}
