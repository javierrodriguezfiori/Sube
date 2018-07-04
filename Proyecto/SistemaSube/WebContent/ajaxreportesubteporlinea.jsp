<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datos.Viaje"%>
<%@page import="java.util.List" %>
<%@page import="datos.Transaccion" %>
<%@page import="funciones.Funciones" %>
<%@page import="datos.Subte" %>
<%@page import="datos.ViajeSubte" %>


<table class="table table-hover">
<%Subte subte = (Subte)request.getAttribute("subte"); %>
<caption>Viajes de la linea: <%=subte.getLinea() %></caption>
  <thead>
    <tr>
        <th scope="col">Fecha</th>
 		<th scope="col">Hora</th>
 		<th scope="col">Numero Tarjeta</th>
 		<th scope="col">Estacion Partida</th>
 		<th scope="col">Monto</th>
    </tr>
  </thead>
  <tbody>
  	<% List<Viaje> viajesSubte = (List)request.getAttribute("viajesSubte");
	for(Viaje viaje : viajesSubte){ %>
	<tr class="table-light">
 		<td><%= Funciones.traerFechaCorta(viaje.getFechaHora()) %> </td>
 		<td><%=Funciones.traerHora(viaje.getFechaHora()) %>
 		<td><%= viaje.getTarjetaSube().getNroTarjeta() %> </td>
 		<% ViajeSubte viajeSubte = (ViajeSubte)viaje; %>
 		<td><%=viajeSubte.getOrigen().getNombre() %></td>
 		<td><%= viaje.getMonto() %> </td>
 	</tr>
 </tbody>
 <%} %>
</table>