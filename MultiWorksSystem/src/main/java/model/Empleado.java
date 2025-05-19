package model;

import java.util.Date;

public class Empleado extends Persona {

    private int idEmpleado;

    // Constructor vacío
    public Empleado() {
        super();
    }

    // Constructor completo (atributos heredados + idEmpleado)
    public Empleado(int idEmpleado, String nombre, String documentoIdentificacion, String contrasena,
                    TipoPersona tipoPersona, TipoContratacion tipoContratacion,
                    String telefono, String correo, String direccion,
                    Estado estado, String creadoPor, Date fechaCreacion,
                    Date fechaActualizacion, Date fechaInactivacion) {

        super(nombre, documentoIdentificacion, contrasena, tipoPersona, tipoContratacion,
                telefono, correo, direccion, estado, creadoPor, fechaCreacion,
                fechaActualizacion, fechaInactivacion);

        this.idEmpleado = idEmpleado;
    }

    // Getters y Setters

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
