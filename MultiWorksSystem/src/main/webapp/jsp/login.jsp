<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login - MultiWorks Group</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
        }
        .login-box {
            width: 350px;
            margin: 80px auto;
            padding: 30px;
            background: #ffffff;
            border: 1px solid #ddd;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .login-box h2 {
            margin-bottom: 20px;
            text-align: center;
        }
        .login-box input[type=text],
        .login-box input[type=password] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 16px 0;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        .login-box input[type=submit] {
            background-color: #007BFF;
            color: white;
            padding: 10px;
            width: 100%;
            border: none;
            cursor: pointer;
        }
        .login-box input[type=submit]:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            text-align: center;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="login-box">
    <h2>Acceso al Sistema</h2>

    <% if (request.getAttribute("error") != null) { %>
    <div class="error"><%= request.getAttribute("error") %></div>
    <% } %>

    <form action="<%= request.getContextPath() %>/login" method="post">
    <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario" required>

        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required>

        <input type="submit" value="Ingresar">
    </form>
</div>
</body>
</html>
