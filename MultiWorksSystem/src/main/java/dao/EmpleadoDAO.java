package dao;

import model.Empleado;
import model.Estado;
import model.TipoContratacion;
import model.TipoPersona;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpleadoDAO {

    // Insertar nuevo empleado
    public void insertar(Empleado e) {
        String sql = "INSERT INTO empleados (idEmpleado, nombre, documentoIdentificacion, contrasena, tipoPersona, tipoContratacion, telefono, correo, direccion, estado, creadoPor, fechaCreacion, fechaActualizacion, fechaInactivacion) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, e.getIdEmpleado());
            stmt.setString(2, e.getNombre());
            stmt.setString(3, e.getDocumentoIdentificacion());
            stmt.setString(4, e.getContrasena());
            stmt.setString(5, e.getTipoPersona().name());
            stmt.setString(6, e.getTipoContratacion().name());
            stmt.setString(7, e.getTelefono());
            stmt.setString(8, e.getCorreo());
            stmt.setString(9, e.getDireccion());
            stmt.setString(10, e.getEstado().name());
            stmt.setString(11, e.getCreadoPor());
            stmt.setDate(12, new java.sql.Date(e.getFechaCreacion().getTime()));
            stmt.setDate(13, new java.sql.Date(e.getFechaActualizacion().getTime()));
            stmt.setDate(14, new java.sql.Date(e.getFechaInactivacion().getTime()));

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Listar empleados
    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombre(rs.getString("nombre"));
                e.setDocumentoIdentificacion(rs.getString("documentoIdentificacion"));
                e.setContrasena(rs.getString("contrasena"));
                e.setTipoPersona(TipoPersona.valueOf(rs.getString("tipoPersona")));
                e.setTipoContratacion(TipoContratacion.valueOf(rs.getString("tipoContratacion")));
                e.setTelefono(rs.getString("telefono"));
                e.setCorreo(rs.getString("correo"));
                e.setDireccion(rs.getString("direccion"));
                e.setEstado(Estado.valueOf(rs.getString("estado")));
                e.setCreadoPor(rs.getString("creadoPor"));
                e.setFechaCreacion(rs.getDate("fechaCreacion"));
                e.setFechaActualizacion(rs.getDate("fechaActualizacion"));
                e.setFechaInactivacion(rs.getDate("fechaInactivacion"));
                lista.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    // Eliminar empleado
    public void eliminar(int idEmpleado) {
        String sql = "DELETE FROM empleados WHERE idEmpleado = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idEmpleado);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Obtener empleado por ID
    public Empleado obtenerPorId(int idEmpleado) {
        String sql = "SELECT * FROM empleados WHERE idEmpleado = ?";
        Empleado e = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idEmpleado);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                e = new Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombre(rs.getString("nombre"));
                e.setDocumentoIdentificacion(rs.getString("documentoIdentificacion"));
                e.setContrasena(rs.getString("contrasena"));
                e.setTipoPersona(TipoPersona.valueOf(rs.getString("tipoPersona")));
                e.setTipoContratacion(TipoContratacion.valueOf(rs.getString("tipoContratacion")));
                e.setTelefono(rs.getString("telefono"));
                e.setCorreo(rs.getString("correo"));
                e.setDireccion(rs.getString("direccion"));
                e.setEstado(Estado.valueOf(rs.getString("estado")));
                e.setCreadoPor(rs.getString("creadoPor"));
                e.setFechaCreacion(rs.getDate("fechaCreacion"));
                e.setFechaActualizacion(rs.getDate("fechaActualizacion"));
                e.setFechaInactivacion(rs.getDate("fechaInactivacion"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return e;
    }

    // Actualizar empleado
    public void actualizar(Empleado e) {
        String sql = "UPDATE empleados SET nombre = ?, documentoIdentificacion = ?, contrasena = ?, tipoPersona = ?, tipoContratacion = ?, telefono = ?, correo = ?, direccion = ?, estado = ?, creadoPor = ?, fechaActualizacion = ?, fechaInactivacion = ? WHERE idEmpleado = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getDocumentoIdentificacion());
            stmt.setString(3, e.getContrasena());
            stmt.setString(4, e.getTipoPersona().name());
            stmt.setString(5, e.getTipoContratacion().name());
            stmt.setString(6, e.getTelefono());
            stmt.setString(7, e.getCorreo());
            stmt.setString(8, e.getDireccion());
            stmt.setString(9, e.getEstado().name());
            stmt.setString(10, e.getCreadoPor());
            stmt.setDate(11, new java.sql.Date(e.getFechaActualizacion().getTime()));
            stmt.setDate(12, new java.sql.Date(e.getFechaInactivacion().getTime()));
            stmt.setInt(13, e.getIdEmpleado());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
