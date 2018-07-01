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
      		<form method="POST" action="/SistemaSube/CobrarViaje">
		        <div class="row">
		          <div class="col-lg-6" style="padding-top:50px;">
		           	Tarjeta Sube >  <input type="text" name="tarjetasube" id="tarjetasube"/>
		          </div>
		          <div class="col-lg-6" style="padding-top:50px;">
		          	<p class="tool"> Fecha del viaje: <input id="datetime" name="fecha" type="text"> 
		          	<span class="tooltiptext">Si no se elige una fecha, se tendrá en cuenta la actual.</span></p>
		          </div>
		        </div>
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
	       			<div class="col-lg-12" style="padding-top:50px; padding-left:1000px; align:right;">
		          		<input type="submit" value="Emitir boleto" class="button">
		          	</div>
	        	</div>
        	</form>
        </div>
	</body>
</html>