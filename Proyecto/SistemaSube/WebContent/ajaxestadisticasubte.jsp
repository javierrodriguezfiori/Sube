<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datos.Viaje"%>
<%@page import="java.util.List" %>
<%@page import="datos.Transaccion" %>
<%@page import="negocio.Muestra" %>
<%@page import="funciones.Funciones" %>
<%@page import="datos.TransportePublico" %>
<%@page import="datos.Tren" %>
<%@page import="datos.Colectivo" %>
<%@page import="datos.Subte" %>


<%Subte subte = (Subte)request.getAttribute("subte"); %>

<table border="1">
<caption>Estadistica Subte : <%=subte.getLinea() %></caption>
<tr>
 <th>Origen</th>

 <th>Cantidad de Viajes</th>
 <th>Total</th>
 

<% List<Muestra> cant = (List)request.getAttribute("estadistica");
for(Muestra muestra : cant){ %>
<tr>
 <td><%= muestra.getNombre() %> </td>

 <td><%= muestra.getCant() %> </td>
 <td><%= muestra.getSum() %>
 
 </tr>
 <%} %>
</table>


 




