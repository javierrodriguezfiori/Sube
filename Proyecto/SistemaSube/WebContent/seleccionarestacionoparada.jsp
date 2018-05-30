<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.TarjetaSube" %>
<%@page import="datos.TransportePublico" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Sistema SUBE</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		
	    <link rel="icon" type="image/png" href="http://lametro.edu.ec/wp-content/uploads/2017/03/favicon.png">
	    <link rel="stylesheet" href="https://gla2imagenes.blob.core.windows.net/constanciadigitalresources/resources/js/plugins/bootstrap/dist/css/bootstrap.min.css?sv=2017-04-17&si=constanciadigitalresourcesro-1602180B752&sr=c&sig=I4p4EsqgDQCjnWb3e5TJDSaW5iBsit%2FwVoCr4lHZBpQ%3D">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<style>
	      body {
	        background-color: white;
	        font-family: 'Roboto';
	      }
	
	      .formulario {
	          background: gainsboro;
	      }
	
	      .subtitle {
	        font-size: 16px;
	      }
	
	      .radio-option {
	        padding-right: 10px;
	      }
	
	    </style>
	</head>
	<body>
			<%@ include file="/header.jsp" %>
		<form method="POST" action="/SistemaSube/CobrarViaje">
	        <div class="col-lg-8" style="padding-top:50px;">
	            <label class="subtitle">Seleccione la estación o el tramo</label> <BR>
	            <% List<String> estaciones = (List) request.getAttribute("listaParadasTramos"); %>
	            <select name="estacion" style="width:200px; align:center;">
					<option value="0">Selecciona un tramo/estacion</option>
					<% for(String estacion : estaciones) { %>
					<option value="<%=estacion%>"><%= estacion %></option>
					<% } %>
	            </select>
	            <% TarjetaSube tarjetaSube = (TarjetaSube) request.getAttribute("tarjetaSube"); %>
	            <% TransportePublico transportePublico = (TransportePublico) request.getAttribute("transportePublico"); %>
	            <input type="hidden" name="tarjetaSube" value="<%= tarjetaSube %>">
	            <input type="hidden" name="transportePublico" value="<%= transportePublico %>">
	            <% tarjetaSube.getNroTarjeta(); %>
	            <% transportePublico.getLinea(); %>
	        </div>
	       	<div class="col-lg-4" style="align:right;">
		          	<input type="submit" value="Cobrar">
		    </div>
	    </form>
        <a href="/SistemaSube/seleccionartarjetaytransporte.jsp" style="align:left;">Volver..</a> 
	</body>
</html>