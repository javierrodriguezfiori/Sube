<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import = "datos.TarjetaSube" %>
<%@page import = "datos.Usuario" %>

<% TarjetaSube tarjeta = (TarjetaSube)request.getAttribute("tarjeta");%>
<% Usuario usuario = (Usuario)request.getAttribute("usuario");%>

<BR>
Numero de Tarjeta:
<%= tarjeta.getNroTarjeta() %>
<BR>
Usuario:
<%= tarjeta.getUsuario()%>
<BR>
