package controller;

import dao.CotizacionDAO;
import model.Cotizacion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/cotizacion")
public class CotizacionServlet extends HttpServlet {

    private final CotizacionDAO dao = new CotizacionDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("actualizar".equals(accion)) {
            actualizarCotizacion(request, response);
        } else {
            registrarCotizacion(request, response);
        }
    }

    private void registrarCotizacion(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Cotizacion cotizacion = extraerCotizacionDesdeRequest(request);
        dao.insertar(cotizacion);
        response.sendRedirect("jsp/cotizaciones/listarCotizaciones.jsp");
    }

    private void actualizarCotizacion(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Cotizacion cotizacion = extraerCotizacionDesdeRequest(request);
        dao.actualizar(cotizacion);
        response.sendRedirect("jsp/cotizaciones/listarCotizaciones.jsp");
    }

    private Cotizacion extraerCotizacionDesdeRequest(HttpServletRequest request) {
        try {
            int idCotizacion = Integer.parseInt(request.getParameter("idCotizacion"));
            String nombreCliente = request.getParameter("nombreCliente");
            int cantidadHoras = Integer.parseInt(request.getParameter("cantidadHorasProyecto"));
            Date fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaTentativaInicio"));
            Date fechaFin = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaTentativaFin"));
            double costoAsignaciones = Double.parseDouble(request.getParameter("costoAsignaciones"));
            double costoAdicionales = Double.parseDouble(request.getParameter("costoAdicionales"));
            double total = Double.parseDouble(request.getParameter("total"));

            return new Cotizacion(idCotizacion, nombreCliente, cantidadHoras, fechaInicio, fechaFin,
                    costoAsignaciones, costoAdicionales, total);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            response.sendRedirect("jsp/cotizaciones/listarCotizaciones.jsp");

        } else if ("editar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Cotizacion c = dao.obtenerPorId(id);
            request.setAttribute("cotizacion", c);
            request.getRequestDispatcher("jsp/cotizaciones/editarCotizacion.jsp").forward(request, response);

        } else {
            List<Cotizacion> cotizaciones = dao.listar();
            request.setAttribute("cotizaciones", cotizaciones);
            request.getRequestDispatcher("jsp/cotizaciones/listarCotizaciones.jsp").forward(request, response);
        }
    }
}
