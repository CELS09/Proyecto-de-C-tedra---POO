<%--
  Created by IntelliJ IDEA.
  User: caedl
  Date: 14/5/2025
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Registrar Actividad</title></head>
<body>
<h2>Registrar Nueva Actividad</h2>
<form action="../../actividad" method="post">
    Título Actividad: <input type="text" name="tituloActividad"><br>
    Trabajador Asignado: <input type="text" name="trabajadorAsignado"><br>
    Área Asignada: <input type="text" name="areaAsignada"><br>
    Costo por Hora: <input type="number" step="0.01" name="costoPorHora"><br>
    Fecha Inicio: <input type="datetime-local" name="fechaHoraInicio"><br>
    Fecha Fin: <input type="datetime-local" name="fechaHoraFin"><br>
    Cantidad Horas Aproximadas: <input type="number" name="cantidadHorasAproximadas"><br>
    Costo Base: <input type="number" step="0.01" name="costoBase"><br>
    Incremento Extra: <input type="number" step="0.01" name="incrementoExtra"><br>
    <br>
    <input type="submit" value="Registrar">
</form>
<a href="listarActividades.jsp">← Ver actividades registradas</a>
</body>
</html>
