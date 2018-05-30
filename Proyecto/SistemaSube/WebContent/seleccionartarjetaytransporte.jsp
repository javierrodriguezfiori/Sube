<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
		<script src="WEB-INF/lib/jquery-3.3.1.js"></script>
		
		<script type="text/javascript">
			/*$(document).ready(function ()) {
				$('#radio').click(function ()) {
					var tipoDeTransporte = $('#radio').val();
					$.ajax({
						method: "POST",
						url: "ControladorCobrarViaje",
						data: { tipoDeTransporte = tipoDeTransporte },
						async: false
					}).done(function (data) ){
						$("#responseviaje").html(data);
					})
				});
			});*/
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
	
	    </style>
	</head>
	<body>
		<%@ include file="/header.jsp" %>
	    <form method="POST" action="/SistemaSube/ControladorSeleccionarTarjetaYTransporte">
	      <div class="container">
	        <div class="row">
	          <div class="col-lg-6" style="padding-top:30px;">
	            <label class="subtitle" style="margin-top:20px; padding-right:20px;">Numero de tarjeta sube</label>
	            <input name="nrotarjeta" style="margin-top:22px; width:300px;">
	          </div>
	        </div>
	        <div class="row" id="responseviaje">
	          <div class="col-lg-4" style="padding-top:50px;">
	              <label class="subtitle">¿En qué transporte público viajará?</label> <BR>
	              <input type="radio" name="transporte[]" id="radio" value="tren" checked/>
	              <label for="radio" class="radio-option">Tren</label>
	              <input type="radio" name="transporte[]" id="radio" value="subte"/>
	              <label for="radio" class="radio-option">Subte</label>
	              <input type="radio" name="transporte[]" id="radio" value="colectivo"/>
	              <label for="radio" class="radio-option">Colectivo</label>
	          </div>
	          <div class="col-lg-4">
	          	<input type="submit" value="TipoDeTransporte">
	          </div>
	        </div>
	      </div>
	    </form>
	</body>
</html>