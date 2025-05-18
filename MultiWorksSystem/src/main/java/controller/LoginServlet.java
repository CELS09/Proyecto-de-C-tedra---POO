package controller;

import dao.AdministradorDAO;
import model.Administrador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

        import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        AdministradorDAO dao = new AdministradorDAO();

        boolean accesoValido = dao.validarCredenciales(usuario, contrasena);

        if (accesoValido) {
            Administrador admin = dao.obtenerPorUsuario(usuario);
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            response.sendRedirect("jsp/menu.jsp");
        } else {
            request.setAttribute("error", "Usuario o contraseña incorrectos...");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }
    }
}
