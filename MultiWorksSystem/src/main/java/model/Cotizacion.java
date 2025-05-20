package model;

import java.util.Date;

public class Cotizacion {

    private int idCotizacion;
    private String nombreCliente;
    private int cantidadHorasProyecto;
    private Date fechaTentativaInicio;
    private Date fechaTentativaFin;
    private double costoAsignaciones;
    private double costoAdicionales;
    private double total;

    // Constructor vacío
    public Cotizacion() {
    }

    // Constructor completo
    public Cotizacion(int idCotizacion, String nombreCliente, int cantidadHorasProyecto, Date fechaTentativaInicio,
                      Date fechaTentativaFin, double costoAsignaciones, double costoAdicionales, double total) {
        this.idCotizacion = idCotizacion;
        this.nombreCliente = nombreCliente;
        this.cantidadHorasProyecto = cantidadHorasProyecto;
        this.fechaTentativaInicio = fechaTentativaInicio;
        this.fechaTentativaFin = fechaTentativaFin;
        this.costoAsignaciones = costoAsignaciones;
        this.costoAdicionales = costoAdicionales;
        this.total = total;
    }

    // Getters y Setters
    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getCantidadHorasProyecto() {
        return cantidadHorasProyecto;
    }

    public void setCantidadHorasProyecto(int cantidadHorasProyecto) {
        this.cantidadHorasProyecto = cantidadHorasProyecto;
    }

    public Date getFechaTentativaInicio() {
        return fechaTentativaInicio;
    }

    public void setFechaTentativaInicio(Date fechaTentativaInicio) {
        this.fechaTentativaInicio = fechaTentativaInicio;
    }

    public Date getFechaTentativaFin() {
        return fechaTentativaFin;
    }

    public void setFechaTentativaFin(Date fechaTentativaFin) {
        this.fechaTentativaFin = fechaTentativaFin;
    }

    public double getCostoAsignaciones() {
        return costoAsignaciones;
    }

    public void setCostoAsignaciones(double costoAsignaciones) {
        this.costoAsignaciones = costoAsignaciones;
    }

    public double getCostoAdicionales() {
        return costoAdicionales;
    }

    public void setCostoAdicionales(double costoAdicionales) {
        this.costoAdicionales = costoAdicionales;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
