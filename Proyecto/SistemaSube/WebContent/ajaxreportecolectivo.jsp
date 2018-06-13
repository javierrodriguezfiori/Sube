<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datos.Viaje"%>
<%@page import="java.util.List" %>
<%@page import="datos.Transaccion" %>
<%@page import="funciones.Funciones" %>


<table border="1">
<caption>Viajes de Colectivos</caption>
<tr>
 <th>Fecha</th>
 <th>Hora</th>
 <th>Numero Tarjeta</th>
 <th>Monto</th>

<% List<Viaje> viajesColectivo = (List)request.getAttribute("viajesColectivo");
for(Viaje viaje : viajesColectivo){ %>
<tr>
 <td><%= Funciones.traerFechaCorta(viaje.getFechaHora()) %> </td>
 <td><%=Funciones.traerHora(viaje.getFechaHora()) %>
 <td><%= viaje.getTarjetaSube().getNroTarjeta() %> </td>
 <td><%= viaje.getMonto() %> </td>
 </tr>
 <%} %>
</table>




