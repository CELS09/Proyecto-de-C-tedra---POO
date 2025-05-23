<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 17/5/2025
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="model.Asignacion" %>
<%@ page import="dao.AsignacionDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    String usuario = (String) session.getAttribute("usuarioAdmin");
    if (usuario == null) {
        response.sendRedirect("../../jsp/login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Asignaciones Registradas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f3;
        }

        .container {
            width: 90%;
            margin: 30px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px #ccc;
        }

        h2 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        a.button {
            display: inline-block;
            padding: 8px 12px;
            margin: 10px 0;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        a.button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Asignaciones Registradas</h2>

    <a href="nuevaAsignacion.jsp" class="button">+ Nueva Asignación</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Título Actividad</th>
            <th>Título Subtarea</th>
            <th>Descripción Subtarea</th>
        </tr>

        <%
            AsignacionDAO dao = new AsignacionDAO();
            List<Asignacion> asignaciones = dao.listar();

            for (Asignacion a : asignaciones) {
        %>
        <tr>
            <td><%= a.getIdAsignacion() %></td>
            <td><%= a.getTituloActividad() %></td>
            <td><%= a.getTituloSubTarea() %></td>
            <td><%= a.getDescripcionSubTarea() %></td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
