<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.TransportePublico" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reportes</title>
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
		}�
		
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
$(document).ready(function(){
	$('#reporte').click(function(){
		var fechaInicio = $('#datetimeInicio').val();
		
		var fechaFin = $('#datetimeFin').val();
		
		var idLineaDeTransporte = $('#lineas option:selected').val();
		var transportePublico = $('#radio-transportes:checked').val();
		$.ajax({
			method: "POST",
			url: "MostrarReportes",
			data: {fechaInicio: fechaInicio,
			       
			       fechaFin: fechaFin,
			       
			       idLineaDeTransporte: idLineaDeTransporte,
			       transportePublico: transportePublico 
			       },
			async: false
		}).done(function(data){
			$("#responsereporte").html(data);
		})
	});
});





$(document).ready(function() { 
	$('input:radio[name=radio-transportes]').change(function() {
		var transportePublico = $('#radio-transportes:checked').val();
		$.ajax({
			method: "POST",
			url: "SeleccionarLineaTransporte",
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


$(document).ready(function() {
		$('#datetimeInicio').hover(function(e) {
			$('.description').show();
		},
		function(e){
			$('.description').hide();
		})
	})
	
	$(document).ready(function() {
		$('#datetimeInicio').datetimepicker({
			format: 'd/m/Y H:i'
			
		});
	})

$(document).ready(function() {
		$('#datetimeFin').hover(function(e) {
			$('.description').show();
		},
		function(e){
			$('.description').hide();
		})
	})
	
	$(document).ready(function() {
		$('#datetimeFin').datetimepicker({
			format: 'd/m/Y H:i'
			
		});
	})

</script>



</head>
<body>
<%@include file="/header.jsp" %>
<h1>Reportes</h1>

	<div class="row">
		<div class="col-lg-3">
			<p class="tool"> Fecha de Inicio: <input id="datetimeInicio" name="fecha" type="text"> 
		</div>
		<div class="col-lg-3">
			<p class="tool"> Fecha de Fin: <input id="datetimeFin" name="fecha" type="text"> 
		</div>
		<div class="col-lg-3">
			<label class="subtitle">Seleccione un Transporte Publico</label> <BR>
			<input type="radio" name="radio-transportes" id="radio-transportes" value="tren"/>
			<label for="radio" >Tren</label>
			<input type="radio" name="radio-transportes" id="radio-transportes" value="subte"/>
			<label for="radio">Subte</label>
			<input type="radio" name="radio-transportes" id="radio-transportes" value="colectivo"/>
			<label for="radio">Colectivo</label>
		</div>
		<div class="col-lg-3">
			<div id="response-lineas-de-transporte"></div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div id="responsereporte"></div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6">
			<INPUT id="reporte"  type="button" class="btn btn-succes" value="Reporte"/>
		</div>
		<div class="col-lg-6" style="padding-top:50px;">
			<form action="inicio.jsp" method="POST">
				<button type="submit" name="boton-volver" value="Volver" class="btn btn-primary">Volver</button>
			</form>
		</div>	
	</div>
</body>
</html>