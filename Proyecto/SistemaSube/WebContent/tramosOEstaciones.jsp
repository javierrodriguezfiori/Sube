<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>

<%
	List<String> paradasTramos = (List) request.getAttribute("listaParadasTramos");
%> 
 
<label class="subtitle">Seleccione la estación o el tramo</label> <BR>
<select name="tramoOParada" style="width:200px; align:center;">
	<option values="0">Selecciona una parada o tramo</option>
	<% for (String tramoOParada : paradasTramos) { %>
	<option value="<%=tramoOParada%>"><%=tramoOParada%></option>
	<% } %>
</select>