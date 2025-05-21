<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Nueva Asignación</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .form-box {
            width: 500px;
            margin: 50px auto;
            background: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        input[type=text], textarea {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type=submit] {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            width: 100%;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #218838;
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
    <h2>Registrar Nueva Asignación</h2>
    <form action="../../asignacion" method="post">
        <label>Título Actividad:</label>
        <input type="text" name="tituloActividad" required>

        <label>Título Subtarea:</label>
        <input type="text" name="tituloSubTarea" required>

        <label>Descripción Subtarea:</label>
        <textarea name="descripcionSubTarea" rows="4" required></textarea>

        <input type="submit" value="Guardar Asignación">
    </form>

    <a href="listarAsignaciones.jsp">Ver todas las asignaciones →</a>
</div>

</body>
</html>
