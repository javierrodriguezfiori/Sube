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
		<script src="js/jquery-3.3.1.min.js"></script>
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
		
		.rad { }
		
		.button:hover {opacity: 1}
	
	    </style>
	    
  		<script type="text/javascript">
			$(document).ready(function() { 
				$(".rad").change(function() {
					var transportePublico = $('input[name=transporte]:checked').val();
					$.ajax({
						method: "POST",
						url: "Lineas",
						data: { transportePublico: transportePublico },
						async: false,
						statusCode: {
							404: function() {
								$("#error").removeClass("hidden");
							},
							500: function() {
								window.location.href = "peticionerronea.jsp";
							}
						}
					}).done(function(data) {
						$("#response").html(data);
					})
				});
			});
		</script>
	    
	</head>
	<body>
		<%@ include file="/header.jsp" %>
		<% 
			TarjetaSubeABM abmSube = TarjetaSubeABM.getInstance();
			Usuario usuarioLogeado = Sesion.obtenerSesionActual().getUsuarioLogeado();
			TarjetaSube tarjetaDeUsuario = abmSube.traerTarjetaSube(usuarioLogeado);
		%>
      	<div class="container">
	        <div class="row">
	          <div class="col-lg-6" style="padding-top:30px;">
	            <label class="subtitle" style="margin-top:20px; padding-right:20px; color:#787878;">Tarjeta Sube > <%=tarjetaDeUsuario.getNroTarjeta() %></label>
	          </div>
	        </div>
	        <div class="row">
	           <div class="col-lg-3" style="padding-top:50px;">
	              <label class="subtitle">¿En qué transporte público viajará?</label> <BR>
	              <input type="radio" name="transporte" value="tren" class="rad" checked/>
	              <label for="radio" class="radio-option">Tren</label>
	              <input type="radio" name="transporte" value="subte" class="rad"/>
	              <label for="radio" class="radio-option">Subte</label>
	              <input type="radio" name="transporte" value="colectivo" class="rad"/>
	              <label for="radio" class="radio-option">Colectivo</label>
	          </div>
   	          <div class="col-lg-5" style="padding:20px; align:right; padding-top:50px;" id="response"></div>
        	</div>
        	<div class="row">
       			<div class="col-lg-12" style="padding-top:50px; padding-left:1000px; align:right;">
	          		<input type="submit" value="Avanzar" class="button">
	          	</div>
        	</div>
        </div>
        <div id="response"></div>
	</body>
</html>