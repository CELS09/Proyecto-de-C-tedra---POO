<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 20/5/2025
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Cliente" %>
<%@ page import="model.TipoPersona" %>
<%@ page import="model.TipoContratacion" %>
<%@ page import="model.Estado" %>
<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
    if (cliente == null) {
        response.sendRedirect("listarClientes.jsp");
        return;
    }
%>
<html>
<head>
    <title>Editar Cliente</title>
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
    <h2>Editar Cliente</h2>
    <form action="../../cliente?accion=actualizar" method="post">

        <input type="hidden" name="idCliente" value="<%= cliente.getIdCliente() %>">

        <label>Nombre:</label>
        <input type="text" name="nombre" value="<%= cliente.getNombre() %>" required>

        <label>Documento Identificación:</label>
        <input type="text" name="documentoIdentificacion" value="<%= cliente.getDocumentoIdentificacion() %>" required>

        <label>Contraseña:</label>
        <input type="text" name="contrasena" value="<%= cliente.getContrasena() %>" required>

        <!--<label>Tipo de Persona:</label>
        <select name="tipoPersona">
            <option value="CLIENTE" <%= cliente.getTipoPersona() == TipoPersona.CLIENTE ? "selected" : "" %>>CLIENTE</option>
        </select>-->

        <label>Tipo de Contratación:</label>
        <select name="tipoContratacion">
            <option value="TIEMPO_COMPLETO" <%= cliente.getTipoContratacion() == TipoContratacion.TIEMPO_COMPLETO ? "selected" : "" %>>Tiempo Completo</option>
            <option value="POR_PROYECTO" <%= cliente.getTipoContratacion() == TipoContratacion.POR_PROYECTO ? "selected" : "" %>>Por Proyecto</option>
            <option value="TEMPORAL" <%= cliente.getTipoContratacion() == TipoContratacion.TEMPORAL ? "selected" : "" %>>Temporal</option>
        </select>

        <label>Teléfono:</label>
        <input type="text" name="telefono" value="<%= cliente.getTelefono() %>">

        <label>Correo:</label>
        <input type="email" name="correo" value="<%= cliente.getCorreo() %>">

        <label>Dirección:</label>
        <input type="text" name="direccion" value="<%= cliente.getDireccion() %>">

        <label>Estado:</label>
        <select name="estado">
            <option value="ACTIVO" <%= cliente.getEstado() == Estado.ACTIVO ? "selected" : "" %>>ACTIVO</option>
            <option value="INACTIVO" <%= cliente.getEstado() == Estado.INACTIVO ? "selected" : "" %>>INACTIVO</option>
        </select>

        <label>Creado por:</label>
        <input type="text" name="creadoPor" value="<%= cliente.getCreadoPor() %>" required>

        <input type="submit" value="Actualizar Cliente">
    </form>

    <a href="listarClientes.jsp">← Volver al listado</a>
</div>

</body>
</html>
