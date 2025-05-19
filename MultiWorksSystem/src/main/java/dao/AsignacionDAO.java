package dao;

import model.Asignacion;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsignacionDAO {

    // Método para insertar una nueva asignación
    public void insertar(Asignacion a) {
        String sql = "INSERT INTO asignaciones (tituloActividad, tituloSubTarea, descripcionSubTarea) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, a.getTituloActividad());
            stmt.setString(2, a.getTituloSubTarea());
            stmt.setString(3, a.getDescripcionSubTarea());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todas las asignaciones
    public List<Asignacion> listar() {
        List<Asignacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM asignaciones";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Asignacion a = new Asignacion();
                a.setIdAsignacion(rs.getInt("idAsignacion"));
                a.setTituloActividad(rs.getString("tituloActividad"));
                a.setTituloSubTarea(rs.getString("tituloSubTarea"));
                a.setDescripcionSubTarea(rs.getString("descripcionSubTarea"));
                lista.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
