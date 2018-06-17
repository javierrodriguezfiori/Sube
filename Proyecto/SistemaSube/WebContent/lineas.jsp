<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="datos.TransportePublico" %>

<%
	List<TransportePublico> transportesPublicos = (List) request.getAttribute("transportesPublicos");
%> 
 
<label class="subtitle">Seleccione la l�nea del transporte en la que viajar�</label> <BR>
<select id="lineas" name="lineas" style="width:200px; align:center;">
	<option values="0">Selecciona una l�nea</option>
	<% for (TransportePublico transporte : transportesPublicos) { %>
	<option value="<%=transporte.getIdTransporte()%>"><%=transporte.getLinea()%></option>
	<% } %>
</select>