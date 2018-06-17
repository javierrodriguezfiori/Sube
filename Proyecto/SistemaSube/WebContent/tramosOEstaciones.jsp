<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>

<%
	List<String> tramosOEstaciones = (List) request.getAttribute("tramosOEstaciones");
%> 
 
<label class="subtitle">Seleccione la estación o el tramo</label> <BR>
<select id="tramoOEstacion" name="tramoOEstacion" style="width:200px; align:center;">
	<option values="0">Selecciona una parada o tramo</option>
	<% for (String tramoOEstacion : tramosOEstaciones) { %>
	<option value="<%=tramoOEstacion%>"><%=tramoOEstacion%></option>
	<% } %>
</select>