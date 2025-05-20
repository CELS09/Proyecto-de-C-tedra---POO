package dao;

import model.Cotizacion;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CotizacionDAO {

    // Crear nueva cotización
    public void insertar(Cotizacion c) {
        String sql = "INSERT INTO cotizaciones (idCotizacion, nombreCliente, cantidadHorasProyecto, fechaTentativaInicio, fechaTentativaFin, costoAsignaciones, costoAdicionales, total) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, c.getIdCotizacion());
            stmt.setString(2, c.getNombreCliente());
            stmt.setInt(3, c.getCantidadHorasProyecto());
            stmt.setDate(4, new java.sql.Date(c.getFechaTentativaInicio().getTime()));
            stmt.setDate(5, new java.sql.Date(c.getFechaTentativaFin().getTime()));
            stmt.setDouble(6, c.getCostoAsignaciones());
            stmt.setDouble(7, c.getCostoAdicionales());
            stmt.setDouble(8, c.getTotal());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Leer todas las cotizaciones
    public List<Cotizacion> listar() {
        List<Cotizacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM cotizaciones";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cotizacion c = new Cotizacion();
                c.setIdCotizacion(rs.getInt("idCotizacion"));
                c.setNombreCliente(rs.getString("nombreCliente"));
                c.setCantidadHorasProyecto(rs.getInt("cantidadHorasProyecto"));
                c.setFechaTentativaInicio(rs.getDate("fechaTentativaInicio"));
                c.setFechaTentativaFin(rs.getDate("fechaTentativaFin"));
                c.setCostoAsignaciones(rs.getDouble("costoAsignaciones"));
                c.setCostoAdicionales(rs.getDouble("costoAdicionales"));
                c.setTotal(rs.getDouble("total"));

                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Obtener cotización por ID
    public Cotizacion obtenerPorId(int idCotizacion) {
        Cotizacion c = null;
        String sql = "SELECT * FROM cotizaciones WHERE idCotizacion = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idCotizacion);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                c = new Cotizacion();
                c.setIdCotizacion(rs.getInt("idCotizacion"));
                c.setNombreCliente(rs.getString("nombreCliente"));
                c.setCantidadHorasProyecto(rs.getInt("cantidadHorasProyecto"));
                c.setFechaTentativaInicio(rs.getDate("fechaTentativaInicio"));
                c.setFechaTentativaFin(rs.getDate("fechaTentativaFin"));
                c.setCostoAsignaciones(rs.getDouble("costoAsignaciones"));
                c.setCostoAdicionales(rs.getDouble("costoAdicionales"));
                c.setTotal(rs.getDouble("total"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    // Actualizar cotización existente
    public void actualizar(Cotizacion c) {
        String sql = "UPDATE cotizaciones SET nombreCliente = ?, cantidadHorasProyecto = ?, fechaTentativaInicio = ?, fechaTentativaFin = ?, costoAsignaciones = ?, costoAdicionales = ?, total = ? " +
                "WHERE idCotizacion = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, c.getNombreCliente());
            stmt.setInt(2, c.getCantidadHorasProyecto());
            stmt.setDate(3, new java.sql.Date(c.getFechaTentativaInicio().getTime()));
            stmt.setDate(4, new java.sql.Date(c.getFechaTentativaFin().getTime()));
            stmt.setDouble(5, c.getCostoAsignaciones());
            stmt.setDouble(6, c.getCostoAdicionales());
            stmt.setDouble(7, c.getTotal());
            stmt.setInt(8, c.getIdCotizacion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar cotización
    public void eliminar(int idCotizacion) {
        String sql = "DELETE FROM cotizaciones WHERE idCotizacion = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idCotizacion);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
