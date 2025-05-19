package controller;

import dao.ClienteDAO;
import model.Cliente;
import model.Estado;
import model.TipoContratacion;
import model.TipoPersona;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {

    private final ClienteDAO dao = new ClienteDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("actualizar".equals(accion)) {
            actualizarCliente(request, response);
        } else {
            registrarCliente(request, response);
        }
    }

    private void registrarCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Cliente cliente = extraerClienteDesdeRequest(request);
        dao.insertar(cliente);
        response.sendRedirect("jsp/clientes/listarClientes.jsp");
    }

    private void actualizarCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Cliente cliente = extraerClienteDesdeRequest(request);
        dao.actualizar(cliente);
        response.sendRedirect("jsp/clientes/listarClientes.jsp");
    }

    private Cliente extraerClienteDesdeRequest(HttpServletRequest request) {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String documento = request.getParameter("documentoIdentificacion");
        String contrasena = request.getParameter("contrasena");
        TipoPersona tipoPersona = TipoPersona.valueOf(request.getParameter("tipoPersona"));
        TipoContratacion tipoContratacion = TipoContratacion.valueOf(request.getParameter("tipoContratacion"));
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        Estado estado = Estado.valueOf(request.getParameter("estado"));
        String creadoPor = request.getParameter("creadoPor") != null ? request.getParameter("creadoPor") : "admin";
        Date ahora = new Date();

        return new Cliente(idCliente, nombre, documento, contrasena, tipoPersona,
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
            response.sendRedirect("jsp/clientes/listarClientes.jsp");

        } else if ("editar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Cliente cliente = dao.obtenerPorId(id);
            request.setAttribute("cliente", cliente);
            request.getRequestDispatcher("jsp/clientes/editarCliente.jsp").forward(request, response);

        } else {
            List<Cliente> clientes = dao.listar();
            request.setAttribute("clientes", clientes);
            request.getRequestDispatcher("jsp/clientes/listarClientes.jsp").forward(request, response);
        }
    }
}
