<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import = "datos.TarjetaSube" %>

<% TarjetaSube tarjeta = (TarjetaSube)request.getAttribute("tarjeta");%>

<BR>
Numero de Tarjeta:
<%= tarjeta.getNroTarjeta() %>
<BR>
Nuevo monto:
<%= tarjeta.getSaldo() %>
<BR>
