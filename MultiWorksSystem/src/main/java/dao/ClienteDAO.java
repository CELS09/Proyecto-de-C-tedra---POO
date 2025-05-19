package dao;

import model.Cliente;
import model.Estado;
import model.TipoContratacion;
import model.TipoPersona;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteDAO {

    // Insertar nuevo cliente
    public void insertar(Cliente c) {
        String sql = "INSERT INTO clientes (idCliente, nombre, documentoIdentificacion, contrasena, tipoPersona, tipoContratacion, telefono, correo, direccion, estado, creadoPor, fechaCreacion, fechaActualizacion, fechaInactivacion) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, c.getIdCliente());
            stmt.setString(2, c.getNombre());
            stmt.setString(3, c.getDocumentoIdentificacion());
            stmt.setString(4, c.getContrasena());
            stmt.setString(5, c.getTipoPersona().name());
            stmt.setString(6, c.getTipoContratacion().name());
            stmt.setString(7, c.getTelefono());
            stmt.setString(8, c.getCorreo());
            stmt.setString(9, c.getDireccion());
            stmt.setString(10, c.getEstado().name());
            stmt.setString(11, c.getCreadoPor());
            stmt.setDate(12, new java.sql.Date(c.getFechaCreacion().getTime()));
            stmt.setDate(13, new java.sql.Date(c.getFechaActualizacion().getTime()));
            stmt.setDate(14, new java.sql.Date(c.getFechaInactivacion().getTime()));

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Listar todos los clientes
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNombre(rs.getString("nombre"));
                c.setDocumentoIdentificacion(rs.getString("documentoIdentificacion"));
                c.setContrasena(rs.getString("contrasena"));
                c.setTipoPersona(TipoPersona.valueOf(rs.getString("tipoPersona")));
                c.setTipoContratacion(TipoContratacion.valueOf(rs.getString("tipoContratacion")));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correo"));
                c.setDireccion(rs.getString("direccion"));
                c.setEstado(Estado.valueOf(rs.getString("estado")));
                c.setCreadoPor(rs.getString("creadoPor"));
                c.setFechaCreacion(rs.getDate("fechaCreacion"));
                c.setFechaActualizacion(rs.getDate("fechaActualizacion"));
                c.setFechaInactivacion(rs.getDate("fechaInactivacion"));

                lista.add(c);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    // Eliminar cliente
    public void eliminar(int idCliente) {
        String sql = "DELETE FROM clientes WHERE idCliente = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Obtener cliente por ID
    public Cliente obtenerPorId(int idCliente) {
        String sql = "SELECT * FROM clientes WHERE idCliente = ?";
        Cliente c = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNombre(rs.getString("nombre"));
                c.setDocumentoIdentificacion(rs.getString("documentoIdentificacion"));
                c.setContrasena(rs.getString("contrasena"));
                c.setTipoPersona(TipoPersona.valueOf(rs.getString("tipoPersona")));
                c.setTipoContratacion(TipoContratacion.valueOf(rs.getString("tipoContratacion")));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correo"));
                c.setDireccion(rs.getString("direccion"));
                c.setEstado(Estado.valueOf(rs.getString("estado")));
                c.setCreadoPor(rs.getString("creadoPor"));
                c.setFechaCreacion(rs.getDate("fechaCreacion"));
                c.setFechaActualizacion(rs.getDate("fechaActualizacion"));
                c.setFechaInactivacion(rs.getDate("fechaInactivacion"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return c;
    }

    // Actualizar cliente
    public void actualizar(Cliente c) {
        String sql = "UPDATE clientes SET nombre = ?, documentoIdentificacion = ?, contrasena = ?, tipoPersona = ?, tipoContratacion = ?, telefono = ?, correo = ?, direccion = ?, estado = ?, creadoPor = ?, fechaActualizacion = ?, fechaInactivacion = ? WHERE idCliente = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getDocumentoIdentificacion());
            stmt.setString(3, c.getContrasena());
            stmt.setString(4, c.getTipoPersona().name());
            stmt.setString(5, c.getTipoContratacion().name());
            stmt.setString(6, c.getTelefono());
            stmt.setString(7, c.getCorreo());
            stmt.setString(8, c.getDireccion());
            stmt.setString(9, c.getEstado().name());
            stmt.setString(10, c.getCreadoPor());
            stmt.setDate(11, new java.sql.Date(c.getFechaActualizacion().getTime()));
            stmt.setDate(12, new java.sql.Date(c.getFechaInactivacion().getTime()));
            stmt.setInt(13, c.getIdCliente());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
