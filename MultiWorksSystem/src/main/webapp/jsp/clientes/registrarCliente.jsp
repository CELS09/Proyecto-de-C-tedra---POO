<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    String usuario = (String) session.getAttribute("usuarioAdmin");
    if (usuario == null) {
        response.sendRedirect("../../jsp/login.jsp"); // Si no hay sesión, redirige al login
        return;
    }
%>
<html>
<head>
    <title>Registrar Cliente</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
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
            margin: 8px 0 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            font-weight: bold;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #218838;
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
    <h2>Registrar Cliente</h2>
    <form action="../../cliente" method="post">

        <label for="idCliente">ID Cliente:</label>
        <input type="text" id="idCliente" name="idCliente" required>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>

        <label for="documentoIdentificacion">Documento Identificación:</label>
        <input type="text" id="documentoIdentificacion" name="documentoIdentificacion" required>

        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required>

        <!--<label for="tipoPersona">Tipo de Persona:</label>
        <select id="tipoPersona" name="tipoPersona">
            <option value="CLIENTE">Cliente</option>
        </select>-->

        <label for="tipoContratacion">Tipo Contratación:</label>
        <select id="tipoContratacion" name="tipoContratacion">
            <option value="TIEMPO_COMPLETO">Tiempo Completo</option>
            <option value="POR_PROYECTO">Por Proyecto</option>
            <option value="TEMPORAL">Temporal</option>
        </select>

        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono">

        <label for="correo">Correo:</label>
        <input type="email" id="correo" name="correo">

        <label for="direccion">Dirección:</label>
        <input type="text" id="direccion" name="direccion">

        <label for="estado">Estado:</label>
        <select id="estado" name="estado">
            <option value="ACTIVO">ACTIVO</option>
            <option value="INACTIVO">INACTIVO</option>
        </select>

        <label for="creadoPor">Creado por:</label>
        <input type="text" id="creadoPor" name="creadoPor" value="admin" required>

        <input type="submit" value="Registrar Cliente">
    </form>

    <a href="listarClientes.jsp">← Volver al listado de clientes</a>
</div>

</body>
</html>
