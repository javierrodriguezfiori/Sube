<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Sesion" %>
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
		<script src="js/jquery-3.3.1.min.js"></script>
		
		<script type="text/javascript">

		$(document).ready(function() {
			var privilegios = $('#privilegios').val();
			if (privilegios == "true/")
				window.location.href = "homeAdmin.jsp";
		});
		</script>

		
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
	      
	      .btn-link{
			  border:none;
			  outline:none;
			  background:none;
			  cursor:pointer;
			  color:#0000EE;
			  padding:0;
			  text-decoration:underline;
			  font-family:inherit;
			  font-size:inherit;
			}
			
		.button {
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
	    </style>
	</head>
	<body>
		<%@ include file="/header.jsp" %>
		
		<% boolean tienePrivilegios = Sesion.obtenerSesionActual().tienePrivilegios(); %>
		<input type="text" id="privilegios" style="display:none;" value=<%=tienePrivilegios%>/>
		
		<div class= "container">
			<div class="row">
				<div class="col-lg-4">
					<form action="/SistemaSube/LogOut" method="POST">
						<button type="submit" name="boton-volver" value="Salir" class="button">Salir</button>
					</form>				
				</div>
				<div class="col-lg-4">
					<form action="/SistemaSube/consultarsaldo.jsp" method="POST">
						<button type="submit" name="boton-volver" value="Reportes" class="button">Consultas</button>
					</form>				
				</div>
				<div class="col-lg-4">
					<form action="/SistemaSube/cobrarViaje.jsp" method="POST">
						<button type="submit" name="boton-volver" value="EmitirBoleto" class="button">Realizar viaje</button>
					</form>				
				</div>
			</div>
		</div>
	</body>
</html>