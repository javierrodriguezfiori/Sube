<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="datos.TransportePublico" %>

<script>
	$(document).ready(function() { 
		$('#list').change(function() {
			var transporte = $('#list option:selected').val();
			$.ajax({
				method: "POST",
				url: "TramosEstaciones",
				data: { transporte: transporte },
				async: false,
				statusCode: {
					404: function() {
						$("#error").removeClass("hidden");
					},
					500: function() {
						window.location.href = "peticionerronea.jsp";
					}
				}
			}).done(function(data) {
				$("#response-estacionestramos").html(data);
			})
		});
	});
</script>

<%
	List<TransportePublico> transportes = (List) request.getAttribute("transportes");
%> 
 
<label class="subtitle">Seleccione la línea del transporte en la que viajará</label> <BR>
<select name="tramoOParada" style="width:200px; align:center;" id="list">
	<option values="0">Selecciona una línea</option>
	<% for (TransportePublico transporte : transportes) { %>
	<option value="<%=transporte.getIdTransporte()%>"><%=transporte.getLinea()%></option>
	<% } %>
</select>

<div id="response-estacionestramos"></div>