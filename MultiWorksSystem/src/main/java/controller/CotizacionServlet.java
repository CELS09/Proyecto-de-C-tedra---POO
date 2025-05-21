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
        Cotizacion cotizacion = extraerCotizacionDesdeRequest(request, false);
        dao.insertar(cotizacion);
        response.sendRedirect("jsp/cotizaciones/listarCotizaciones.jsp");
    }

    private void actualizarCotizacion(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Cotizacion cotizacion = extraerCotizacionDesdeRequest(request, true);
        dao.actualizar(cotizacion);
        response.sendRedirect("jsp/cotizaciones/listarCotizaciones.jsp");
    }

    private Cotizacion extraerCotizacionDesdeRequest(HttpServletRequest request, boolean incluirId) {
        try {
            Cotizacion c = new Cotizacion();

            if (incluirId) {
                int id = Integer.parseInt(request.getParameter("idCotizacion"));
                c.setIdCotizacion(id);
            }

            c.setNombreCliente(request.getParameter("nombreCliente"));
            c.setCantidadHorasProyecto(Integer.parseInt(request.getParameter("cantidadHorasProyecto")));
            c.setFechaTentativaInicio(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaTentativaInicio")));
            c.setFechaTentativaFin(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaTentativaFin")));
            c.setCostoAsignaciones(Double.parseDouble(request.getParameter("costoAsignaciones")));
            c.setCostoAdicionales(Double.parseDouble(request.getParameter("costoAdicionales")));
            c.setTotal(Double.parseDouble(request.getParameter("total")));

            return c;

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
