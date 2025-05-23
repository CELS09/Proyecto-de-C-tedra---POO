<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 20/5/2025
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Cotizacion" %>
<%@ page session="true" %>
<%
    String usuario = (String) session.getAttribute("usuarioAdmin");
    if (usuario == null) {
        response.sendRedirect("../../jsp/login.jsp");
        return;
    }
%>
<%
    Cotizacion cotizacion = (Cotizacion) request.getAttribute("cotizacion");
    if (cotizacion == null) {
        response.sendRedirect("listarCotizaciones.jsp");
        return;
    }
%>
<html>
<head>
    <title>Editar Cotización</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f3;
        }

        .form-box {
            width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px #ccc;
        }

        h2 {
            text-align: center;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin: 10px 0 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #ffc107;
            border: none;
            color: white;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            background-color: #e0a800;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
        }
    </style>
</head>
<body>

<div class="form-box">
    <h2>Editar Cotización</h2>

    <form action="../../cotizacion?accion=actualizar" method="post">
        <input type="hidden" name="idCotizacion" value="<%= cotizacion.getIdCotizacion() %>">

        <label for="nombreCliente">Nombre del Cliente:</label>
        <input type="text" id="nombreCliente" name="nombreCliente" value="<%= cotizacion.getNombreCliente() %>" required>

        <label for="cantidadHorasProyecto">Cantidad de Horas del Proyecto:</label>
        <input type="number" id="cantidadHorasProyecto" name="cantidadHorasProyecto" value="<%= cotizacion.getCantidadHorasProyecto() %>" required>

        <label for="fechaTentativaInicio">Fecha Tentativa de Inicio:</label>
        <input type="date" id="fechaTentativaInicio" name="fechaTentativaInicio"
               value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(cotizacion.getFechaTentativaInicio()) %>" required>

        <label for="fechaTentativaFin">Fecha Tentativa de Fin:</label>
        <input type="date" id="fechaTentativaFin" name="fechaTentativaFin"
               value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(cotizacion.getFechaTentativaFin()) %>" required>

        <label for="costoAsignaciones">Costo por Asignaciones:</label>
        <input type="number" step="0.01" id="costoAsignaciones" name="costoAsignaciones"
               value="<%= cotizacion.getCostoAsignaciones() %>" required>

        <label for="costoAdicionales">Costos Adicionales:</label>
        <input type="number" step="0.01" id="costoAdicionales" name="costoAdicionales"
               value="<%= cotizacion.getCostoAdicionales() %>" required>

        <label for="total">Total:</label>
        <input type="number" step="0.01" id="total" name="total" value="<%= cotizacion.getTotal() %>" required>

        <input type="submit" value="Actualizar Cotización">
    </form>

    <a href="listarCotizaciones.jsp">← Volver al listado</a>
</div>

</body>
</html>
