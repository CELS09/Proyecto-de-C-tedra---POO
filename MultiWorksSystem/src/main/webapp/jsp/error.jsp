<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>Error del Sistema</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .error-box {
            background-color: #f5c6cb;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
            max-width: 600px;
        }

        h2 {
            margin-bottom: 20px;
        }

        p {
            font-size: 16px;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            color: #721c24;
            font-weight: bold;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="error-box">
    <h2>¡Ha ocurrido un error inesperado!</h2>
    <p>Lo sentimos, algo ha salido mal. Por favor, intente nuevamente más tarde.</p>

    <%-- Mostrar detalles técnicos si están disponibles --%>
    <% if (exception != null) { %>
    <p><strong>Detalles:</strong> <%= exception.getMessage() %></p>
    <% } %>

    <a href="menu.jsp">← Volver al menú principal</a>
</div>

</body>
</html>
