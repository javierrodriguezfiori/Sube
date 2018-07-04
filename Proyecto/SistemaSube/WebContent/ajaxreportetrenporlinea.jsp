<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datos.Viaje"%>
<%@page import="java.util.List" %>
<%@page import="datos.Transaccion" %>
<%@page import="funciones.Funciones" %>
<%@page import="datos.Tren" %>
<%@page import="datos.ViajeTren" %>

<table border="1">
<%Tren tren = (Tren)request.getAttribute("tren"); %>
<caption>Viajes de la linea: <%=tren.getLinea() %></caption>
<tr>
 <th>Fecha</th>
 <th>Hora</th>
 <th>Numero Tarjeta</th>
 <th>Estacion Origen</th>
 <th>Estacion Destino</th>
 <th>Monto</th>

<% List<Viaje> viajesTren = (List)request.getAttribute("viajesTren");
for(Viaje viaje : viajesTren){ %>
<tr>
 <td><%= Funciones.traerFechaCorta(viaje.getFechaHora()) %> </td>
 <td><%=Funciones.traerHora(viaje.getFechaHora()) %>
 <td><%= viaje.getTarjetaSube().getNroTarjeta() %> </td>
 <% ViajeTren viajeTren = (ViajeTren)viaje; %>
 <td><%=viajeTren.getOrigen().getNombre() %></td>
 <td><%if(viajeTren.getDestino()!=null)%><%=viajeTren.getDestino().getNombre() %></td>
 <td><%= viaje.getMonto() %> </td>
 </tr>
 <%} %>
</table>