package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

        import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔐 Invalidar la sesión actual
        HttpSession session = request.getSession(false); // false: no crea una nueva sesión si no existe
        if (session != null) {
            session.invalidate();
        }

        // 🔁 Redirigir al login
        response.sendRedirect("jsp/login.jsp");
    }
}
