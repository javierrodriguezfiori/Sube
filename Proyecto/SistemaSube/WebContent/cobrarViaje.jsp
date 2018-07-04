<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="negocio.TarjetaSubeABM" %>
<%@page import="datos.Usuario" %>
<%@page import="datos.TarjetaSube" %>
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
	    <link rel="stylesheet" href="js/datetimepicker-master/build/jquery.datetimepicker.min.css">
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/datetimepicker-master/build/jquery.datetimepicker.full.min.js"></script>
		
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
	      
      		
		.opciones{
			padding-top:50px;
		}
		
		.description {
			display:none;
			border:1px solid #F00;
			width:150px;
		}‹
		
		.button:hover {opacity: 1}
		

		
		.tool:hover .tooltiptext {
			display:block;
		}
		
		.tooltiptext {
			background-color: #6495ED;
			padding: 10px 0;
			border-radius: 6px;
			text-align: center;
			width: 200px;
			display:none;
		    color: white;
		    margin-left: 150px; /* moves the tooltip to the right */
		    margin-top: 5px; /* moves it down */
		    position: absolute;
		    z-index: 1000;
		}
		
		.hidden {
			display:none;
		}
		
		.center-screen {
 			 display: flex;
 			 flex-direction: column;
			 justify-content: center;
 			 align-items: center;
  			 text-align: center;
			}
	
	    </style>
	    
  		<script type="text/javascript">
  			// $("#error").removeClass("hidden"); Como mostrar un elemento del HTML oculto
  			
  			$(document).ready(function(){
  				var usuarioLogeado = $('#usuarioLogeado').val();
  				var retorno = $('#retorno').val();

  				if (usuarioLogeado == "true/")
  					$('#nroTarjetaSube-Logeada').removeClass("hidden");
  				else 
  					$('#nroTarjetaSube-NoLogeada').removeClass("hidden");
  			})
  			
 			$(document).ready(function() {
  				$('#datetime').datetimepicker({
  					format: 'd/m/Y H:i',
  					minDate: '0'
  				});
  			})
  			
  			
  			$(document).ready(function() {
  				$('#datetime').hover(function(e) {
  					$('.description').show();
  				},
  				function(e){
  					$('.description').hide();
  				})
  			})
  			
  			$(document).ready(function() {
  				$('#datetime').datetimepicker({
  					format: 'd/m/Y H:i',
  					minDate: '0'
  				});
  			})
  			
  			// Primer AJAX a ejecutar
  			// Carga las lineas
			$(document).ready(function() { 
				$('input:radio[name=radio-transportes]').change(function() {
					var transportePublico = $('#radio-transportes:checked').val();
					$.ajax({
						method: "POST",
						url: "Lineas",
						data: { transportePublico: transportePublico },
						async: false,
						statusCode: {
							500: function() {
								window.location.href = "peticionerronea.jsp";
							}
						}
					}).done(function(data) {
						$("#response-lineas-de-transporte").html(data);
					})
				});
			});
			
  			// Primer elemento externo cargado, segundo AJAX a ejecutar
  			// Carga las estaciones o tramos
			$(document).on("change", "#lineas", function(event) {
				var idLineaDeTransporte = $('#lineas option:selected').val();
				$.ajax({
					method: "POST",
					url: "TramosEstaciones",
					data: { idLineaDeTransporte: idLineaDeTransporte },
					async: false,
					statusCode: {
						500: function() {
							window.location.href = "peticionerronea.jsp";
						}
					}
				}).done(function(data) {
					$("#response-tramos-o-estaciones").html(data);
				})
			});
  			
 			$(document).on("click", "#emitirBoleto", function(event) {
 				var usuarioLogeado = $('#usuarioLogeado').val();
 				var tienePrivilegios = $('#tienePrivilegios').val();
 				var fecha = $('#datetime').val();
 				if ((usuarioLogeado != "true/") || (tienePrivilegios == "true/")){
 					var tarjetasube = $('#tarjetasube').val();
 					if (tarjetasube == "")
 						alert("Debe insertar una tarjeta sube antes de emitir un viaje.");
 				}
 				
 				var idLineaDeTransporte = $('#lineas option:selected').val();
 				
 				if (idLineaDeTransporte == "undefined" || idLineaDeTransporte == "Selecciona una línea")
				{
 					alert("Debe elegir una linea de transporte publico antes de emitir un viaje.");
 					return;
 				}
 				
 				var tramoOEstacion = $('#tramoOEstacion option:selected').val();
 				
 				if (tramoOEstacion == "undefined" || tramoOEstacion == "Selecciona una parada o tramo")
 				{
 					alert("Debe elegir un tramo o estacion antes de emitir un viaje.");
 					return;
 				}
 				
 				$.ajax({
 					method: "POST",
 					url: "CobrarViaje",
 					data: { tarjetasube: tarjetasube, lineas: idLineaDeTransporte, tramoOEstacion: tramoOEstacion, fecha: fecha },
 					async: false,
					statusCode: {
						404: function() {
							$('#error4041').removeClass("hidden");
							$('#error4042').removeClass("hidden");
						},
						400: function() {
							$('#error4001').removeClass("hidden");
							$('#error4002').removeClass("hidden");
						},
						500: function() {
							window.location.href = "peticionerronea.jsp";
						}
					}
 				}).done(function(data) {
 					$('#formulario1').addClass("hidden");
 					$('#formulario2').addClass("hidden");
 					$("#response-viaje-cobrado").html(data);
 				})
  			});
		</script>
	    
	</head>
	<body class="center-screen">
		<%@ include file="/header.jsp" %>
		<%
		String nroTarjetaSube = "";
		boolean tienePrivilegios = Sesion.obtenerSesionActual().getUsuarioLogeado() != null && Sesion.obtenerSesionActual().tienePrivilegios();
		boolean usuarioLogeado = Sesion.obtenerSesionActual().getUsuarioLogeado() != null && !Sesion.obtenerSesionActual().tienePrivilegios(); 
		if (usuarioLogeado && !Sesion.obtenerSesionActual().tienePrivilegios())
			nroTarjetaSube = String.valueOf(Sesion.obtenerSesionActual().getTarjetaSubeDelUsuario().getNroTarjeta());
		%>
		<% 
		String retorno = "inicio.jsp";
		
		if (Sesion.obtenerSesionActual().getUsuarioLogeado() == null) // Si, ya sé, pero bueno.
			retorno = "index.jsp";			
		%>
		<input type="text" id="usuarioLogeado" style="display:none;" value=<%=usuarioLogeado%>/>
		<input type="text" id="tienePrivilegios" style="display:none;" value=<%=tienePrivilegios%>/>
		<input type="text" id="retorno" style="display:none;" value=<%=retorno%>/>
		<div class="container" id="formulario1">
			<div class="row">
	          	<div class="col-lg-4 hidden" id="nroTarjetaSube-Logeada" style="padding-top:30px;">
	           		<label class="subtitle" style="margin-top:20px; padding-right:20px; color:#787878;"><h4>Tarjeta Sube > <%=nroTarjetaSube%></h4></label> <br>
		         	<label id="error4001" class="hidden">No posee suficiente saldo en la tarjeta para realizar este viaje.</label>
		         	<label id="error4041" class="hidden">La tarjeta sube ingresada no existe.</label>	           		
	         	</div>
	          	<div class="col-lg-4 hidden" id="nroTarjetaSube-NoLogeada" style="padding-top:30px;">
	           		<label class="subtitle" style="margin-top:20px; padding-right:20px; color:#787878;"><h4>Tarjeta Sube > </h4></label><input type="text" name="tarjetasube" id="tarjetasube" class="form-control" style="width: 300px;align:center"> <br>
	           		<label id="error4002" class="hidden">No posee suficiente saldo en la tarjeta para realizar este viaje.</label>
	         		<label id="error4042" class="hidden">La tarjeta sube ingresada no existe.</label>
	         	</div>
			    <div class="col-lg-6" style="padding-top:50px;">
		          	<p class="tool"> <h4>Fecha del viaje:</h4> <input id="datetime" name="fecha" type="text" class="form-control" style="width: 300px;align:center"> 
		          	<span class="tooltiptext">Si no se elige una fecha, se tendrá en cuenta la actual.</span></p>
	        	</div>
			</div>
			<div class="row">
	           <div class="col-lg-3 opciones">
	              <label><h4>¿En qué transporte público viajará?</h4></label> <BR>
	              <input type="radio" name="radio-transportes" id="radio-transportes" value="tren" checked/>
	              <label for="radio" >Tren</label>
	              <input type="radio" name="radio-transportes" id="radio-transportes" value="subte"/>
	              <label for="radio">Subte</label>
	              <input type="radio" name="radio-transportes" id="radio-transportes" value="colectivo"/>
	              <label for="radio">Colectivo</label>
	          </div>
   	          <div class="col-lg-5 opciones" id="response-lineas-de-transporte"></div>
   	          <div class="col-lg-4 opciones" id="response-tramos-o-estaciones"></div>
   	          
        	</div>
        </div>	
        	<div class="row">
        		<div id="response-viaje-cobrado"></div>
        		<div class="col-lg-4" align="center" style="padding-top:50px;display:inline-block">
  						<form action="<%=retorno%>" method="POST">
						<button type="submit" name="boton-volver" value="Volver" class="btn btn-primary">Volver</button>
					</form>
        		</div>  
	        	<div id="formulario2">          	
	       			<div align="center" style="padding-top:50px;display:inline-block">
		          		<input type="submit" value="Emitir boleto" id="emitirBoleto" class="btn btn-primary">
		          	</div>        	    		
	        	</div>
		</div>
	</body>
</html>