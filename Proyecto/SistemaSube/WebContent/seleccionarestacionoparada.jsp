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
	      
     		.button {
		    background-color: #f44336;
		    border: none;
		    color: white;
		    padding: 15px 32px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 12px;
		    border-radius: 8px;
		    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
		    opacity: 0.6;
		}
		
		     		.button-avanzar {
		    background-color: #008CBA;
		    border: none;
		    color: white;
		    padding: 15px 32px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 12px;
		    border-radius: 8px;
		    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
		    opacity: 0.6;
		}
		
		.button:hover {opacity: 1}
		.button-avanzar:hover {opacity: 1}
			
	
	    </style>
	</head>
	<body>
		<%@ include file="/header.jsp" %>
		<%
			List<String> paradasTramos = (List) request.getAttribute("listaParadasTramos");
			TarjetaSube tarjetaSube = (TarjetaSube) request.getAttribute("tarjetaSube");
			TransportePublico transportePublico = (TransportePublico) request.getAttribute("transportePublico");
		%>
		<form method="POST" action="/SistemaSube/CobrarViaje">
			<div class="container">
				<div class="row">
					<div class="col-lg-8" style="padding-top:50px;">

					</div>
				</div>
			</div>
	       	<div class="col-lg-4" style="align:right; padding:20px;">
	          	<input type="submit" value="Cobrar viaje" class="button-avanzar">
		    </div>
            <input type="hidden" name="tarjetaSubeNro" value="<%= Long.valueOf(tarjetaSube.getNroTarjeta()) %>">
            <input type="hidden" name="transportePublicoId" value="<%= Long.valueOf(transportePublico.getIdTransporte()) %>">
	    </form>
		<form action="/SistemaSube/seleccionartarjetaytransporte.jsp" method="POST">
			<button type="submit" name="boton-volver" value="Volver" class="button" style="padding:20px; maring:30px;">Volver</button>
		</form>
	</body>
</html>