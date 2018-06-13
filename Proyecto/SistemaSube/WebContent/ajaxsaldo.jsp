<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import = "datos.TarjetaSube" %>
<% TarjetaSube tarjeta = (TarjetaSube)request.getAttribute("tarjeta");%>
<table border="1">
<caption>Saldo</caption>
<tr>
 <th>Numero de Tarjeta</th>
 <th>Saldo</th>
 
<tr>
 <td><%= tarjeta.getNroTarjeta() %> </td>
 <td><%= tarjeta.getSaldo() %> </td>
 
 </tr>
 
</table>