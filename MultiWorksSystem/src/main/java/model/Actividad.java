package model;

import java.time.LocalDateTime;

public class Actividad {

    private int idActividad;
    private String tituloActividad;
    private String trabajadorAsignado;
    private String areaAsignada;
    private double costoPorHoraParaEmpleado;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private int cantidadHorasAproximadas;
    private double costoBase;
    private double incrementoExtra;
    private double costoTotal;

    //Getters y Setters
    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getTituloActividad() {
        return tituloActividad;
    }

    public void setTituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    public String getTrabajadorAsignado() {
        return trabajadorAsignado;
    }

    public void setTrabajadorAsignado(String trabajadorAsignado) {
        this.trabajadorAsignado = trabajadorAsignado;
    }

    public String getAreaAsignada() {
        return areaAsignada;
    }

    public void setAreaAsignada(String areaAsignada) {
        this.areaAsignada = areaAsignada;
    }

    public double getCostoPorHoraParaEmpleado() {
        return costoPorHoraParaEmpleado;
    }

    public void setCostoPorHoraParaEmpleado(double costoPorHoraParaEmpleado) {
        this.costoPorHoraParaEmpleado = costoPorHoraParaEmpleado;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public int getCantidadHorasAproximadas() {
        return cantidadHorasAproximadas;
    }

    public void setCantidadHorasAproximadas(int cantidadHorasAproximadas) {
        this.cantidadHorasAproximadas = cantidadHorasAproximadas;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public double getIncrementoExtra() {
        return incrementoExtra;
    }

    public void setIncrementoExtra(double incrementoExtra) {
        this.incrementoExtra = incrementoExtra;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
