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
		
		.button:hover {opacity: 1}
	
	    </style>
	</head>
	<body>
		<%@ include file="/header.jsp" %>
	    <form method="POST" action="/SistemaSube/SeleccionarTarjetaYTransporte">
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
	              <input type="radio" name="transporte" id="radio" value="tren" checked/>
	              <label for="radio" class="radio-option">Tren</label>
	              <input type="radio" name="transporte" id="radio" value="subte"/>
	              <label for="radio" class="radio-option">Subte</label>
	              <input type="radio" name="transporte" id="radio" value="colectivo"/>
	              <label for="radio" class="radio-option">Colectivo</label>
	          </div>
	          <div class="col-lg-4" style="padding:50px; align:right;">
	          	<input type="submit" value="Avanzar" class="button">
	          </div>
	        </div>
	      </div>
	    </form>
	    <form action="/SistemaSube/consultarsaldo.jsp" method="POST">
			<button type="submit" name="boton-consultarsaldo" value="ConsultarSaldo" class="button" style="padding:20px; maring:30px;">ConsultarSaldo</button>
		</form> 
		
		<form action="/SistemaSube/registrarsube.jsp" method="POST">
			<button type="submit" name="boton-registrarsube" value="RegistrarSube" class="button" style="padding:20px; maring:30px;">RegistrarSube</button>
		</form> 
		
		<form action="/SistemaSube/bajasube.jsp" method="POST">
			<button type="submit" name="boton-bajasube" value="BajaSube" class="button" style="padding:20px; maring:30px;">BajaSube</button>
		</form> 
		
		<form action="/SistemaSube/recargarsube.jsp" method="POST">
			<button type="submit" name="boton-recargarsube" value="RecargarSube" class="button" style="padding:20px; maring:30px;">RecargarSube</button>
		</form> 
		
		<form action="/SistemaSube/asignartarifasocial.jsp" method="POST">
			<button type="submit" name="boton-selecciontarifas" value="SeleccionarTarifa" class="button" style="padding:20px; maring:30px;">AsignarTarifaSocial</button>
		</form> 
		
		<form action="SeleccionarLineaTransporte" method="POST">
			<button type="submit" name="boton-reportes" value="Reportes" class="button" style="padding:20px; maring:30px;">Reportes</button>
		</form> 
	</body>

</html>