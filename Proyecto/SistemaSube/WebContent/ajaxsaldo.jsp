<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import = "datos.TarjetaSube" %>
<% TarjetaSube tarjeta = (TarjetaSube)request.getAttribute("tarjeta");%>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Numero de Tarjeta</th>
 	  <th scope="col">Saldo</th>
    </tr>
  </thead>
  <tbody>
    <tr class="table-light">
      <td><%= tarjeta.getNroTarjeta() %> </td>
 	  <td><%= tarjeta.getSaldo() %> </td>
    </tr>
  </tbody>
</table>