package model;

public class Administrador {

    private int idAdministrador;
    private String usuarioAdmin;
    private String contrasenaAdmin;

    // Constructor vacío
    public Administrador() {
    }

    // Constructor con parámetros
    public Administrador(int idAdministrador, String usuarioAdmin, String contrasenaAdmin) {
        this.idAdministrador = idAdministrador;
        this.usuarioAdmin = usuarioAdmin;
        this.contrasenaAdmin = contrasenaAdmin;
    }

    // Getters y Setters
    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getContrasenaAdmin() {
        return contrasenaAdmin;
    }

    public void setContrasenaAdmin(String contrasenaAdmin) {
        this.contrasenaAdmin = contrasenaAdmin;
    }
}
