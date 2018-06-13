<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datos.Viaje"%>
<%@page import="java.util.List" %>
<%@page import="datos.Transaccion" %>
<%@page import="funciones.Funciones" %>
<%@page import="datos.Subte" %>
<%@page import="datos.ViajeSubte" %>

<table border="1">
<%Subte subte = (Subte)request.getAttribute("subte"); %>
<caption>Viajes de la linea: <%=subte.getLinea() %></caption>
<tr>
 <th>Fecha</th>
 <th>Hora</th>
 <th>Numero Tarjeta</th>
 <th>Estacion Partida</th>
 <th>Monto</th>

<% List<Viaje> viajesSubte = (List)request.getAttribute("viajesSubte");
for(Viaje viaje : viajesSubte){ %>
<tr>
 <td><%= Funciones.traerFechaCorta(viaje.getFechaHora()) %> </td>
 <td><%=Funciones.traerHora(viaje.getFechaHora()) %>
 <td><%= viaje.getTarjetaSube().getNroTarjeta() %> </td>
 <% ViajeSubte viajeSubte = (ViajeSubte)viaje; %>
 <td><%=viajeSubte.getOrigen().getNombre() %></td>
 <td><%= viaje.getMonto() %> </td>
 </tr>
 <%} %>
</table>