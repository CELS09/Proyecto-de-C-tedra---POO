<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Actividad" %>
<%@ page import="dao.ActividadDAO" %>
<html>
<head><title>Actividades</title></head>
<body>
<h2>Listado de Actividades</h2>
<a href="registrarActividad.jsp">+ Nueva Actividad</a><br><br>
<table border="1">
    <tr>
        <th>ID</th><th>Título</th><th>Trabajador</th><th>Área</th><th>Horas</th><th>Costo Total</th>
    </tr>
    <%
        ActividadDAO dao = new ActividadDAO();
        List<Actividad> lista = dao.listar();
        for (Actividad a : lista) {
    %>
    <tr>
        <td><%= a.getIdActividad() %></td>
        <td><%= a.getTituloActividad() %></td>
        <td><%= a.getTrabajadorAsignado() %></td>
        <td><%= a.getAreaAsignada() %></td>
        <td><%= a.getCantidadHorasAproximadas() %></td>
        <td>$<%= a.getCostoTotal() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
