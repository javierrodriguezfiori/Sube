<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>

<%
	List<String> lineas = (List) request.getAttribute("lineasDeTransporte");
%> 
 
<label class="subtitle">Seleccione la línea del transporte en la que viajará</label> <BR>
<select name="tramoOParada" style="width:200px; align:center;">
	<option values="0">Selecciona una línea</option>
	<% for (String linea : lineas) { %>
	<option value="<%=linea%>"><%=linea%></option>
	<% } %>
</select>