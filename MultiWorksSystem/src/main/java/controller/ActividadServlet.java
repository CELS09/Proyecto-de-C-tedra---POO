package controller;

import dao.ActividadDAO;
import model.Actividad;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/actividad")
public class ActividadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Capturar los datos del formulario
        String tituloActividad = request.getParameter("tituloActividad");
        String trabajadorAsignado = request.getParameter("trabajadorAsignado");
        String areaAsignada = request.getParameter("areaAsignada");
        double costoPorHora = Double.parseDouble(request.getParameter("costoPorHora"));
        int horasAprox = Integer.parseInt(request.getParameter("cantidadHorasAproximadas"));
        double costoBase = Double.parseDouble(request.getParameter("costoBase"));
        double incrementoExtra = Double.parseDouble(request.getParameter("incrementoExtra"));

        // Fechas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime fechaInicio = LocalDateTime.parse(request.getParameter("fechaHoraInicio"), formatter);
        LocalDateTime fechaFin = LocalDateTime.parse(request.getParameter("fechaHoraFin"), formatter);

        // Calcular costo total
        double costoTotal = (costoPorHora * horasAprox) + incrementoExtra;

        // Crear objeto
        Actividad actividad = new Actividad();
        actividad.setTituloActividad(tituloActividad);
        actividad.setTrabajadorAsignado(trabajadorAsignado);
        actividad.setAreaAsignada(areaAsignada);
        actividad.setCostoPorHoraParaEmpleado(costoPorHora);
        actividad.setCantidadHorasAproximadas(horasAprox);
        actividad.setCostoBase(costoBase);
        actividad.setIncrementoExtra(incrementoExtra);
        actividad.setCostoTotal(costoTotal);
        actividad.setFechaHoraInicio(fechaInicio);
        actividad.setFechaHoraFin(fechaFin);

        // Guardar en base de datos
        ActividadDAO dao = new ActividadDAO();
        dao.insertar(actividad);

        response.sendRedirect("jsp/actividades/listarActividades.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ActividadDAO dao = new ActividadDAO();
        List<Actividad> lista = dao.listar();
        request.setAttribute("actividades", lista);
        request.getRequestDispatcher("jsp/actividades/listarActividades.jsp").forward(request, response);
    }
}
