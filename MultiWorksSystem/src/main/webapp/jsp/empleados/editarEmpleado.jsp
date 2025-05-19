<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Empleado" %>
<%@ page import="model.TipoPersona" %>
<%@ page import="model.TipoContratacion" %>
<%@ page import="model.Estado" %>
<%
    Empleado emp = (Empleado) request.getAttribute("empleado");
    if (emp == null) {
        response.sendRedirect("listarEmpleados.jsp");
        return;
    }
%>
<html>
<head>
    <title>Editar Empleado</title>
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
    </style>
</head>
<body>

<div class="form-box">
    <h2>Editar Empleado</h2>
    <form action="../../empleado?accion=actualizar" method="post">

        <input type="hidden" name="idEmpleado" value="<%= emp.getIdEmpleado() %>">

        <label>Nombre:</label>
        <input type="text" name="nombre" value="<%= emp.getNombre() %>" required>

        <label>Documento de Identificación:</label>
        <input type="text" name="documentoIdentificacion" value="<%= emp.getDocumentoIdentificacion() %>" required>

        <label>Contraseña:</label>
        <input type="text" name="contrasena" value="<%= emp.getContrasena() %>" required>

        <label>Tipo de Persona:</label>
        <select name="tipoPersona">
            <option value="EMPLEADO" <%= emp.getTipoPersona() == TipoPersona.EMPLEADO ? "selected" : "" %>>EMPLEADO</option>
        </select>

        <label>Tipo de Contratación:</label>
        <select name="tipoContratacion">
            <option value="TIEMPO_COMPLETO" <%= emp.getTipoContratacion() == TipoContratacion.TIEMPO_COMPLETO ? "selected" : "" %>>Tiempo Completo</option>
            <option value="POR_PROYECTO" <%= emp.getTipoContratacion() == TipoContratacion.POR_PROYECTO ? "selected" : "" %>>Por Proyecto</option>
            <option value="TEMPORAL" <%= emp.getTipoContratacion() == TipoContratacion.TEMPORAL ? "selected" : "" %>>Temporal</option>
        </select>

        <label>Teléfono:</label>
        <input type="text" name="telefono" value="<%= emp.getTelefono() %>">

        <label>Correo:</label>
        <input type="email" name="correo" value="<%= emp.getCorreo() %>">

        <label>Dirección:</label>
        <input type="text" name="direccion" value="<%= emp.getDireccion() %>">

        <label>Estado:</label>
        <select name="estado">
            <option value="ACTIVO" <%= emp.getEstado() == Estado.ACTIVO ? "selected" : "" %>>ACTIVO</option>
            <option value="INACTIVO" <%= emp.getEstado() == Estado.INACTIVO ? "selected" : "" %>>INACTIVO</option>
        </select>

        <label>Creado por:</label>
        <input type="text" name="creadoPor" value="<%= emp.getCreadoPor() %>">

        <input type="submit" value="Actualizar Empleado">
    </form>
</div>

</body>
</html>
