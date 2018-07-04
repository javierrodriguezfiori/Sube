<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datos.Viaje"%>
<%@page import="java.util.List" %>
<%@page import="datos.Transaccion" %>
<%@page import="funciones.Funciones" %>


<table class="table table-hover">
  <thead>
  <caption>Viajes de Colectivos</caption>
    <tr>
      <th scope="col">Fecha</th>
 	  <th scope="col">Hora</th>
 	  <th scope="col">Numero Tarjeta</th>
 	  <th scope="col">Monto</th>
    </tr>
  </thead>
  <tbody>
  	<% List<Viaje> viajesColectivo = (List)request.getAttribute("viajesColectivo");
	for(Viaje viaje : viajesColectivo){ %>
	<tr class="table-light">
 		<td><%= Funciones.traerFechaCorta(viaje.getFechaHora()) %> </td>
 		<td><%=Funciones.traerHora(viaje.getFechaHora()) %>
 		<td><%= viaje.getTarjetaSube().getNroTarjeta() %> </td>
 		<td><%= viaje.getMonto() %> </td>
 	</tr>
 </tbody>
 <%} %>
</table>



