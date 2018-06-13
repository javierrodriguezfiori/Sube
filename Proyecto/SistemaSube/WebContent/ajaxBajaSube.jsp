<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import = "datos.TarjetaSube" %>
<%@page import = "datos.Usuario" %>

<% TarjetaSube tarjeta = (TarjetaSube)request.getAttribute("tarjeta");%>
<% String confirmacion = (String)request.getAttribute("resultado");%>

<BR>
Numero de Tarjeta:
<%= tarjeta.getNroTarjeta() %>
<BR>
Confirmacion:
<%= confirmacion %>
<BR>
