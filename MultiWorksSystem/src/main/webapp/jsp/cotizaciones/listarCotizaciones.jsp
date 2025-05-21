<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="model.Cotizacion" %>
<%@ page import="dao.CotizacionDAO" %>
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
    <title>Listado de Cotizaciones (Cliente)</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        .container {
            width: 90%;
            margin: 40px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px #ccc;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        .btn {
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            color: white;
        }

        .edit-btn {
            background-color: #28a745;
        }

        .delete-btn {
            background-color: #dc3545;
        }

        .add-btn {
            display: inline-block;
            margin-bottom: 20px;
            padding: 10px 20px;
            background-color: #17a2b8;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        .modal {
            display: none;
            position: fixed;
            z-index: 999;
            left: 0; top: 0;
            width: 100%; height: 100%;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            background-color: white;
            margin: 15% auto;
            padding: 20px;
            border-radius: 8px;
            width: 350px;
            text-align: center;
        }

        .modal-content button {
            margin: 10px;
            padding: 8px 20px;
            cursor: pointer;
        }

        .confirm {
            background-color: #dc3545;
            color: white;
            border: none;
        }

        .cancel {
            background-color: #6c757d;
            color: white;
            border: none;
        }
    </style>

    <script>
        let idCotizacion = null;

        function confirmarEliminacion(id) {
            idCotizacion = id;
            document.getElementById("confirmModal").style.display = "block";
        }

        function cancelar() {
            document.getElementById("confirmModal").style.display = "none";
            idCotizacion = null;
        }

        function eliminar() {
            window.location.href = "../../cotizacion?accion=eliminar&id=" + idCotizacion;
        }
    </script>
</head>
<body>

<div class="container">
    <h2>Mis Cotizaciones</h2>

    <a class="add-btn" href="nuevaCotizacion.jsp">+ Nueva Cotización</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Cliente</th>
            <th>Horas</th>
            <th>Inicio</th>
            <th>Fin</th>
            <th>Asignaciones</th>
            <th>Adicionales</th>
            <th>Total</th>
            <th>Acciones</th>
        </tr>

        <%
            CotizacionDAO dao = new CotizacionDAO();
            List<Cotizacion> lista = dao.listar();
            for (Cotizacion c : lista) {
        %>
        <tr>
            <td><%= c.getIdCotizacion() %></td>
            <td><%= c.getNombreCliente() %></td>
            <td><%= c.getCantidadHorasProyecto() %></td>
            <td><%= c.getFechaTentativaInicio() %></td>
            <td><%= c.getFechaTentativaFin() %></td>
            <td>$<%= c.getCostoAsignaciones() %></td>
            <td>$<%= c.getCostoAdicionales() %></td>
            <td>$<%= c.getTotal() %></td>
            <td>
                <button class="btn edit-btn" onclick="location.href='editarCotizacion.jsp?id=<%= c.getIdCotizacion() %>'">Editar</button>
                <button class="btn delete-btn" onclick="confirmarEliminacion(<%= c.getIdCotizacion() %>)">Eliminar</button>
            </td>
        </tr>
        <% } %>
    </table>
</div>

<!-- Modal de Confirmación -->
<div id="confirmModal" class="modal">
    <div class="modal-content">
        <h3>¿Estás seguro de eliminar esta cotización?</h3>
        <button class="confirm" onclick="eliminar()">Eliminar</button>
        <button class="cancel" onclick="cancelar()">Cancelar</button>
    </div>
</div>

</body>
</html>
