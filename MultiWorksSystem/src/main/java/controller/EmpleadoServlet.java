package controller;

import dao.EmpleadoDAO;
import model.Empleado;
import model.Estado;
import model.TipoContratacion;
import model.TipoPersona;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/empleado")
public class EmpleadoServlet extends HttpServlet {

    private final EmpleadoDAO dao = new EmpleadoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("actualizar".equals(accion)) {
            actualizarEmpleado(request, response);
        } else {
            registrarEmpleado(request, response);
        }
    }

    private void registrarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            Empleado empleado = extraerEmpleadoDesdeRequest(request);
            dao.insertar(empleado);
            response.sendRedirect("jsp/empleados/listarEmpleados.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "Error al registrar empleado.");
        }
    }

    private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            Empleado empleado = extraerEmpleadoDesdeRequest(request);
            dao.actualizar(empleado);
            response.sendRedirect("jsp/empleados/listarEmpleados.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "Error al actualizar empleado.");
        }
    }

    private Empleado extraerEmpleadoDesdeRequest(HttpServletRequest request) {
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        String nombre = request.getParameter("nombre");
        String documento = request.getParameter("documentoIdentificacion");
        String contrasena = request.getParameter("contrasena") != null ? request.getParameter("contrasena") : "";
        TipoPersona tipoPersona = TipoPersona.valueOf(request.getParameter("tipoPersona"));
        TipoContratacion tipoContratacion = TipoContratacion.valueOf(request.getParameter("tipoContratacion"));
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        Estado estado = Estado.valueOf(request.getParameter("estado"));
        String creadoPor = request.getParameter("creadoPor") != null ? request.getParameter("creadoPor") : "admin";

        Date ahora = new Date();

        return new Empleado(idEmpleado, nombre, documento, contrasena, tipoPersona,
                tipoContratacion, telefono, correo, direccion,
                estado, creadoPor, ahora, ahora, ahora);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            response.sendRedirect("jsp/empleados/listarEmpleados.jsp");

        } else if ("editar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Empleado empleado = dao.obtenerPorId(id);
            request.setAttribute("empleado", empleado);
            request.getRequestDispatcher("jsp/empleados/editarEmpleado.jsp").forward(request, response);

        } else {
            List<Empleado> empleados = dao.listar();
            request.setAttribute("empleados", empleados);
            request.getRequestDispatcher("jsp/empleados/listarEmpleados.jsp").forward(request, response);
        }
    }
}
