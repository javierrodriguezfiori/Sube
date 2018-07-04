<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datos.Viaje"%>
<%@page import="java.util.List" %>
<%@page import="datos.Transaccion" %>
<%@page import="funciones.Funciones" %>
<%@page import="datos.Tren" %>
<%@page import="datos.ViajeTren" %>

<%Tren tren = (Tren)request.getAttribute("tren"); %>
<h4>Viajes de la linea: <%=tren.getLinea() %></h4>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Fecha</th>
 	  <th scope="col">Hora</th>
 	  <th scope="col">Numero Tarjeta</th>
 	  <th scope="col">Estacion Origen</th>
 	  <th scope="col">Estacion Destino</th>
 	  <th scope="col"><th>Monto</th>
    </tr>
  </thead>
  <tbody>
  	<% List<Viaje> viajesTren = (List)request.getAttribute("viajesTren");
	for(Viaje viaje : viajesTren){ %>
    <tr class="table-light">
 		<td><%= Funciones.traerFechaCorta(viaje.getFechaHora()) %> </td>
 		<td><%=Funciones.traerHora(viaje.getFechaHora()) %>
 		<td><%= viaje.getTarjetaSube().getNroTarjeta() %> </td>
 			<% ViajeTren viajeTren = (ViajeTren)viaje; %>
 		<td><%=viajeTren.getOrigen().getNombre() %></td>
		 <td><%if(viajeTren.getDestino()!=null)%><%=viajeTren.getDestino().getNombre() %></td>
 		<td><%= viaje.getMonto() %> </td>
 	</tr>
 </tbody>
 <%} %>
</table>
