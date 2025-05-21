<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="model.Empleado" %>
<%@ page import="dao.EmpleadoDAO" %>
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
    <title>Listado de Empleados</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
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
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        .btn {
            padding: 6px 10px;
            border: none;
            cursor: pointer;
            color: white;
            border-radius: 4px;
        }

        .edit-btn { background-color: #28a745; }
        .delete-btn { background-color: #dc3545; }

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

        .confirm { background-color: #dc3545; color: white; border: none; }
        .cancel { background-color: #6c757d; color: white; border: none; }
    </style>

    <script>
        let empleadoId = null;

        function confirmarEliminacion(id) {
            empleadoId = id;
            document.getElementById("confirmModal").style.display = "block";
        }

        function cancelar() {
            document.getElementById("confirmModal").style.display = "none";
            empleadoId = null;
        }

        function eliminar() {
            window.location.href = "../../empleado?accion=eliminar&id=" + empleadoId;
        }
    </script>
</head>
<body>

<div class="container">
    <h2>Empleados Registrados</h2>

    <a href="registrarEmpleado.jsp">+ Nuevo Empleado</a><br><br>

    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Documento</th>
            <th>Correo</th>
            <th>Teléfono</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>
        <%
            EmpleadoDAO dao = new EmpleadoDAO();
            List<Empleado> lista = dao.listar();
            for (Empleado e : lista) {
        %>
        <tr>
            <td><%= e.getIdEmpleado() %></td>
            <td><%= e.getNombre() %></td>
            <td><%= e.getDocumentoIdentificacion() %></td>
            <td><%= e.getCorreo() %></td>
            <td><%= e.getTelefono() %></td>
            <td><%= e.getEstado() %></td>
            <td>
                <button class="btn edit-btn" onclick="location.href='editarEmpleado.jsp?id=<%= e.getIdEmpleado() %>'">Editar</button>
                <button class="btn delete-btn" onclick="confirmarEliminacion(<%= e.getIdEmpleado() %>)">Eliminar</button>
            </td>
        </tr>
        <% } %>
    </table>
</div>

<!-- Modal de Confirmación -->
<div id="confirmModal" class="modal">
    <div class="modal-content">
        <h3>¿Estás seguro de eliminar este empleado?</h3>
        <button class="confirm" onclick="eliminar()">Eliminar</button>
        <button class="cancel" onclick="cancelar()">Cancelar</button>
    </div>
</div>

</body>
</html>
