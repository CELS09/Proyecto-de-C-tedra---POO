<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    // Verificar si hay sesión activa
    String usuario = (String) session.getAttribute("usuarioAdmin");
    if (usuario == null) {
        response.sendRedirect("login.jsp"); // Si no hay sesión, redirige al login
        return;
    }
%>
<html>
<head>
    <title>Menú Principal - MultiWorksSystem</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }

        .container {
            width: 800px;
            margin: 60px auto;
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 12px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        .menu-option {
            display: block;
            background-color: #007bff;
            color: white;
            padding: 15px 25px;
            border-radius: 5px;
            margin-bottom: 15px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.2s ease;
        }

        .menu-option:hover {
            background-color: #0056b3;
        }

        .logout {
            display: block;
            margin-top: 30px;
            text-align: center;
            color: #dc3545;
            text-decoration: none;
            font-weight: bold;
        }

        .logout:hover {
            color: #a71d2a;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Bienvenido, <%= usuario %></h2>

    <a class="menu-option" href="empleados/listarEmpleados.jsp">📋 Gestión de Empleados</a>
    <a class="menu-option" href="clientes/listarClientes.jsp">👥 Gestión de Clientes</a>
    <a class="menu-option" href="cotizaciones/listarCotizacionesAdmin.jsp">💼 Ver Cotizaciones</a>
    <a class="menu-option" href="asignaciones/listarAsignaciones.jsp">🛠 Gestión de Asignaciones</a>
    <a class="menu-option" href="actividades/listarActividades.jsp">📌 Gestión de Actividades</a>

    <!-- Lógica de logout -->
    <a class="logout" href="../../logout">Cerrar Sesión</a>
</div>

</body>
</html>
