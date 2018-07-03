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
		<link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.css">
		<link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.min.css">
		
		<style>
	      
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
		</script>
	    
	</head>
	<body>
		<%@ include file="/header.jsp" %>
      	<div class="container">
      		<form method="POST" action="/SistemaSube/CobrarViaje" class="center-screen">
      		<div class="form-group" style="padding-top:50px;">
  				<label class="col-form-label" for="tarjetasube">Tarjeta Sube</label>
  				<input type="text" class="form-control" placeholder="Tarjeta Sube" name="tarjetasube" id="tarjetasube" style="width:200px"/>
			</div>
			<div class="form-group" style="padding-top:50px;">
  				<p class="tool"> Fecha del viaje: <input id="datetime" name="fecha" type="text" class="form-control" style="width:200px"> 
		          	<span class="tooltiptext">Si no se elige una fecha, se tendrá en cuenta la actual.</span></p>
			</div>
		    <div class="form-group">
		    <div class="row">
		           <div class="col-lg-3 opciones">
		              <label class="subtitle">¿En qué transporte público viajará?</label> <BR>
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
	   	        <div class="row">
	       			<button type="submit" name="boton-volver" value="Emitir boleto" class="btn btn-primary">Emitir boleto</button>     	
    			</div>   		        
        	</form>
        </div>
	</body>
</html>