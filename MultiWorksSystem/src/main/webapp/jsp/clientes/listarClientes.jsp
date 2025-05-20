<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="model.Cliente" %>
<%@ page import="dao.ClienteDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listado de Clientes</title>
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
        let clienteId = null;

        function confirmarEliminacion(id) {
            clienteId = id;
            document.getElementById("confirmModal").style.display = "block";
        }

        function cancelar() {
            document.getElementById("confirmModal").style.display = "none";
            clienteId = null;
        }

        function eliminar() {
            window.location.href = "../../cliente?accion=eliminar&id=" + clienteId;
        }
    </script>
</head>
<body>

<div class="container">
    <h2>Listado de Clientes</h2>

    <a class="add-btn" href="registrarCliente.jsp">+ Nuevo Cliente</a>

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
            ClienteDAO dao = new ClienteDAO();
            List<Cliente> lista = dao.listar();
            for (Cliente c : lista) {
        %>
        <tr>
            <td><%= c.getIdCliente() %></td>
            <td><%= c.getNombre() %></td>
            <td><%= c.getDocumentoIdentificacion() %></td>
            <td><%= c.getCorreo() %></td>
            <td><%= c.getTelefono() %></td>
            <td><%= c.getEstado() %></td>
            <td>
                <button class="btn edit-btn" onclick="location.href='editarCliente.jsp?id=<%= c.getIdCliente() %>'">Editar</button>
                <button class="btn delete-btn" onclick="confirmarEliminacion(<%= c.getIdCliente() %>)">Eliminar</button>
            </td>
        </tr>
        <% } %>
    </table>
</div>

<!-- Modal de Confirmación -->
<div id="confirmModal" class="modal">
    <div class="modal-content">
        <h3>¿Estás seguro de eliminar este cliente?</h3>
        <button class="confirm" onclick="eliminar()">Eliminar</button>
        <button class="cancel" onclick="cancelar()">Cancelar</button>
    </div>
</div>

</body>
</html>
