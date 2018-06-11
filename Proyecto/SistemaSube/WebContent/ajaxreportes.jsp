<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datos.Viaje"%>
<%@page import="java.util.List" %>
<%@page import="datos.Transaccion" %>
<%@page import="funciones.Funciones" %>
<table border="1">
<tr>
 <th>FechaHora</th>
 <th>Numero Tarjeta</th>
 <th>Monto</th>

<% List<Viaje> viajes = (List)request.getAttribute("viajes");
for(Viaje viaje : viajes){ %>
<tr>
 <td><%= Funciones.traerFechaCortaHora(viaje.getFechaHora()) %> </td>
 <td><%= viaje.getTarjetaSube().getNroTarjeta() %> </td>
 <td><%= viaje.getMonto() %> </td>
 </tr>
 <%} %>
</table>

