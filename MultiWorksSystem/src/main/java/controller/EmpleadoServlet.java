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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/empleado")
public class EmpleadoServlet extends HttpServlet {

    private final EmpleadoDAO dao = new EmpleadoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Capturar datos del formulario
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        String nombre = request.getParameter("nombre");
        String documento = request.getParameter("documentoIdentificacion");
        String contrasena = request.getParameter("contrasena");
        TipoPersona tipoPersona = TipoPersona.valueOf(request.getParameter("tipoPersona"));
        TipoContratacion tipoContratacion = TipoContratacion.valueOf(request.getParameter("tipoContratacion"));
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        Estado estado = Estado.valueOf(request.getParameter("estado"));
        String creadoPor = request.getParameter("creadoPor");

        // Fecha actual
        Date ahora = new Date();

        // Crear el objeto Empleado
        Empleado empleado = new Empleado(idEmpleado, nombre, documento, contrasena,
                tipoPersona, tipoContratacion, telefono, correo, direccion,
                estado, creadoPor, ahora, ahora, ahora);

        // Guardar en la base de datos
        dao.insertar(empleado);

        // Redirigir al listado actualizado
        response.sendRedirect("jsp/empleados/listarEmpleados.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener lista de empleados desde el DAO
        List<Empleado> empleados = dao.listar();

        // Guardar la lista como atributo de request
        request.setAttribute("empleados", empleados);

        // Enviar a la vista JSP
        request.getRequestDispatcher("jsp/empleados/listarEmpleados.jsp").forward(request, response);
    }
}
