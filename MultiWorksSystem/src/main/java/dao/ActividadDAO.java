package dao;

import model.Actividad;
import util.DBConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActividadDAO {

    public void insertar(Actividad a) {
        String sql = "INSERT INTO actividades (tituloActividad, trabajadorAsignado, areaAsignada, costoPorHoraParaEmpleado, fechaHoraInicio, fechaHoraFin, cantidadHorasAproximadas, costoBase, incrementoExtra, costoTotal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, a.getTituloActividad());
            stmt.setString(2, a.getTrabajadorAsignado());
            stmt.setString(3, a.getAreaAsignada());
            stmt.setDouble(4, a.getCostoPorHoraParaEmpleado());
            stmt.setTimestamp(5, Timestamp.valueOf(a.getFechaHoraInicio()));
            stmt.setTimestamp(6, Timestamp.valueOf(a.getFechaHoraFin()));
            stmt.setInt(7, a.getCantidadHorasAproximadas());
            stmt.setDouble(8, a.getCostoBase());
            stmt.setDouble(9, a.getIncrementoExtra());
            stmt.setDouble(10, a.getCostoTotal());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Actividad> listar() {
        List<Actividad> lista = new ArrayList<>();
        String sql = "SELECT * FROM actividades";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Actividad a = new Actividad();
                a.setIdActividad(rs.getInt("idActividad"));
                a.setTituloActividad(rs.getString("tituloActividad"));
                a.setTrabajadorAsignado(rs.getString("trabajadorAsignado"));
                a.setAreaAsignada(rs.getString("areaAsignada"));
                a.setCostoPorHoraParaEmpleado(rs.getDouble("costoPorHoraParaEmpleado"));
                a.setFechaHoraInicio(rs.getTimestamp("fechaHoraInicio").toLocalDateTime());
                a.setFechaHoraFin(rs.getTimestamp("fechaHoraFin").toLocalDateTime());
                a.setCantidadHorasAproximadas(rs.getInt("cantidadHorasAproximadas"));
                a.setCostoBase(rs.getDouble("costoBase"));
                a.setIncrementoExtra(rs.getDouble("incrementoExtra"));
                a.setCostoTotal(rs.getDouble("costoTotal"));
                lista.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
