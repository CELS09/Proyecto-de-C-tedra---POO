<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
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
    <title>Registrar Empleado</title>
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
            color: #333;
        }

        input[type="text"], input[type="password"], input[type="email"], select {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 12px;
            width: 100%;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 15px;
        }
    </style>
</head>
<body>

<div class="form-box">
    <h2>Registrar Nuevo Empleado</h2>
    <form action="../../empleado" method="post">

        <label for="idEmpleado">ID Empleado:</label>
        <input type="text" id="idEmpleado" name="idEmpleado" required>

        <label for="nombre">Nombre completo:</label>
        <input type="text" id="nombre" name="nombre" required>

        <label for="documentoIdentificacion">Documento de Identificación:</label>
        <input type="text" id="documentoIdentificacion" name="documentoIdentificacion" required>

        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required>

        <!--<label for="tipoPersona">Tipo de Persona:</label>
       <select id="tipoPersona" name="tipoPersona">
           <option value="EMPLEADO">Empleado</option>
       </select>-->

       <label for="tipoContratacion">Tipo de Contratación:</label>
       <select id="tipoContratacion" name="tipoContratacion">
           <option value="TIEMPO_COMPLETO">Tiempo Completo</option>
           <option value="POR_PROYECTO">Por Proyecto</option>
           <option value="TEMPORAL">Temporal</option>
       </select>

       <label for="telefono">Teléfono:</label>
       <input type="text" id="telefono" name="telefono">

       <label for="correo">Correo electrónico:</label>
       <input type="email" id="correo" name="correo">

       <label for="direccion">Dirección:</label>
       <input type="text" id="direccion" name="direccion">

       <label for="estado">Estado:</label>
       <select id="estado" name="estado">
           <option value="ACTIVO">ACTIVO</option>
           <option value="INACTIVO">INACTIVO</option>
       </select>

       <label for="creadoPor">Creado por (usuario):</label>
       <input type="text" id="creadoPor" name="creadoPor" required>

       <input type="submit" value="Guardar Empleado">
   </form>

   <a href="listarEmpleados.jsp">← Ver lista de empleados</a>
</div>

</body>
</html>
