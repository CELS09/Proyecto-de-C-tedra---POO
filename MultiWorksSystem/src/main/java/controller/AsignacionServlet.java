package controller;

import dao.AsignacionDAO;
import model.Asignacion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/asignacion")
public class AsignacionServlet extends HttpServlet {

    // Maneja peticiones POST (registro de nueva asignación)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Capturar los datos enviados desde el formulario
        String tituloActividad = request.getParameter("tituloActividad");
        String tituloSubTarea = request.getParameter("tituloSubTarea");
        String descripcionSubTarea = request.getParameter("descripcionSubTarea");

        // Crear objeto Asignacion
        Asignacion asignacion = new Asignacion();
        asignacion.setTituloActividad(tituloActividad);
        asignacion.setTituloSubTarea(tituloSubTarea);
        asignacion.setDescripcionSubTarea(descripcionSubTarea);

        // Insertar en la base de datos usando DAO
        AsignacionDAO dao = new AsignacionDAO();
        dao.insertar(asignacion);

        // Redirigir al listado actualizado
        response.sendRedirect("jsp/asignaciones/listarAsignaciones.jsp");
    }

    // Maneja peticiones GET (mostrar lista de asignaciones)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener todas las asignaciones desde DAO
        AsignacionDAO dao = new AsignacionDAO();
        List<Asignacion> lista = dao.listar();

        // Guardar en el atributo request
        request.setAttribute("asignaciones", lista);

        // Reenviar a la vista
        request.getRequestDispatcher("jsp/asignaciones/listarAsignaciones.jsp").forward(request, response);
    }
}
