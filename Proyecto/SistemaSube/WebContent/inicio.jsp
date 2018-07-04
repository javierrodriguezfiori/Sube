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
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
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
	      
		.btn {
		background:transparent;
	    border: none; /* Remove borders */
	    color: DodgerBlue; /* White text */
	    padding: 12px 16px; /* Some padding */
	    font-size: 500px; /* Set a font size */
	    cursor: pointer; /* Mouse pointer on hover */
		}
		
		.btn:hover {
			background:transparent;
		}
	
			.tool:hover .tooltiptext {
			display:block;
		}
		
		.tooltiptext {
			background-color: DodgerBlue;
			font-size:15px;
			padding: 10px 0;
			border-radius: 6px;
			text-align: center;
			width: 100px;
			display:none;
		    color: white;
		    margin-left: 10px; /* moves the tooltip to the right */
		    margin-top: 7px; /* moves it down */
		    position: absolute;
		    z-index: 1000;
		}
		
		.hidden {
			display:none;
		}
		
		.col-lg-4 {
			padding-top:20px;
		}
	    </style>
   		<script src="js/jquery-3.3.1.min.js"></script>
	    <script type="text/javascript">
  			$(document).ready(function(){
  				var tienePrivilegios = $('#tienePrivilegios').val();

  				if (tienePrivilegios == "true/")
  				{
  					$('#asignartarifa').removeClass("hidden");	
  					$('#bajarsube').removeClass("hidden");	
  				}
  			})
  		</script>
	</head>
	<body>
		<%@ include file="/header.jsp" %>
		<% boolean tienePrivilegios = Sesion.obtenerSesionActual().getUsuarioLogeado() != null && Sesion.obtenerSesionActual().tienePrivilegios(); %>
		<input type="text" id="tienePrivilegios" style="display:none;" value=<%=tienePrivilegios%>/>
		<div class= "container" style="margin-top:10%;">
			<div class="row">
				<div class="col-lg-3">
					<form action="/SistemaSube/reportes.jsp" method="POST">
						<p class="tool"><button type="submit" value="Reportes" class="btn"><i class="fa fa-bars fa-5x" aria-hidden="true"></i></button>
						<span class="tooltiptext">Reportes</span></p>
					</form>				
				</div>
				<div class="col-lg-3">
					<form action="/SistemaSube/estadisticas.jsp" method="POST">
						<p class="tool"><button type="submit" value="Reportes" class="btn"><i class="fa fa-pie-chart fa-5x" aria-hidden="true"></i></button>
						<span class="tooltiptext">Estadisticas</span></p>
					</form>				
				</div>
				<div class="col-lg-3">
					<form action="/SistemaSube/cobrarViaje.jsp" method="POST">
						<p class="tool"><button type="submit" value="EmitirBoleto" class="btn"><i class="fa fa-train fa-5x" aria-hidden="true"></i></button>
						<span class="tooltiptext">Realizar un viaje</span></p>
					</form>				
				</div>
				<div class="col-lg-3 hidden" id="asignartarifa">
					<form action="/SistemaSube/asignartarifasocial.jsp" method="POST">
						<p class="tool"><button type="submit" value="AsignarTarifaSocial" class="btn"><i class="fa fa-handshake-o fa-5x" aria-hidden="true"></i></button>
						<span class="tooltiptext">Asignar tarifa social</span></p>
					</form>				
				</div>				
				<div class="col-lg-3 hidden" id="bajarsube">
					<form action="/SistemaSube/bajasube.jsp" method="POST">
						<p class="tool"><button type="submit" value="DeshabilitarTarjta" class="btn"><i class="fa fa-ban fa-5x" aria-hidden="true"></i></button>
						<span class="tooltiptext">Deshabilitar tarjetas</span></p>
					</form>				
				</div>	
				<div class="col-lg-3" style="padding-top:30px;">
					<form action="/SistemaSube/LogOut" method="POST">
						<p class="tool"><button type="submit" value="Salir" class="btn"><i class="fa fa-sign-out fa-5x" aria-hidden="true"></i></button>
						<span class="tooltiptext">Salir</span></p>
					</form>				
				</div>									
			</div>
		</div>
	</body>
</html>