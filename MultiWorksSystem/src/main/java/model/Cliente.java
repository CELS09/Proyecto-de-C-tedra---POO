package model;

import java.util.Date;

public class Cliente extends Persona {

    private int idCliente;

    // Constructor vacío
    public Cliente() {
        super();
    }

    // Constructor con todos los atributos (incluye heredados y propios)
    public Cliente(int idCliente, String nombre, String documentoIdentificacion, String contrasena,
                   TipoPersona tipoPersona, TipoContratacion tipoContratacion, String telefono, String correo,
                   String direccion, Estado estado, String creadoPor, Date fechaCreacion,
                   Date fechaActualizacion, Date fechaInactivacion) {

        super(nombre, documentoIdentificacion, contrasena, tipoPersona, tipoContratacion,
                telefono, correo, direccion, estado, creadoPor, fechaCreacion,
                fechaActualizacion, fechaInactivacion);

        this.idCliente = idCliente;
    }

    // Getter y Setter
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
