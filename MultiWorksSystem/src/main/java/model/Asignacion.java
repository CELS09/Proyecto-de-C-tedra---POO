package model;

public class Asignacion {

    private int idAsignacion;
    private String tituloActividad;
    private String tituloSubTarea;
    private String descripcionSubTarea;

    // Constructor vacío
    public Asignacion() {
    }

    // Constructor con parámetros
    public Asignacion(int idAsignacion, String tituloActividad, String tituloSubTarea, String descripcionSubTarea) {
        this.idAsignacion = idAsignacion;
        this.tituloActividad = tituloActividad;
        this.tituloSubTarea = tituloSubTarea;
        this.descripcionSubTarea = descripcionSubTarea;
    }

    // Getters y Setters
    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getTituloActividad() {
        return tituloActividad;
    }

    public void setTituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    public String getTituloSubTarea() {
        return tituloSubTarea;
    }

    public void setTituloSubTarea(String tituloSubTarea) {
        this.tituloSubTarea = tituloSubTarea;
    }

    public String getDescripcionSubTarea() {
        return descripcionSubTarea;
    }

    public void setDescripcionSubTarea(String descripcionSubTarea) {
        this.descripcionSubTarea = descripcionSubTarea;
    }
}
