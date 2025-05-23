<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Si ya hay sesión activa, redirigir al menú principal
    String usuario = (String) session.getAttribute("usuarioAdmin");

    if (usuario != null) {
        response.sendRedirect("jsp/menu.jsp");
    } else {
        response.sendRedirect("jsp/login.jsp");
    }
%>
