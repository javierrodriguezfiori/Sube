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
		<script src="js/jquery-3.3.1.min.js"></script>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$('#registrarse').click(function() {
					var tipoDocumento = $('#radio-tipodocumento:checked').val();
					
					var documento = $('#documento').val();
					if (documento == "")
					{
						emptyValue("documento");						
						return;
					}
					
					var tarjetasube = $('#tarjetasube').val();
					if (tarjetasube == "")
					{
						emptyValue("tarjetasube");						
						return;
					}
						
					
					var nombre = $('#nombre').val();
					if (nombre == "")
					{
						emptyValue("nombre");
						return;
					}
					
					
					var apellido = $('#apellido').val();
					if (apellido == "")
					{
						emptyValue("apellido");
						return;
					}
					
					
					var clave = $('#clave').val();
					if (clave == "")
					{
						emptyValue("clave");
						return;
					}
						
					
					var genero = $('#radio-genero:checked').val();
					
					var mail = $('#mail').val();
					var movil = $('#movil').val();
					var telefonoFijo = $('#telefonofijo').val();
					
					$.ajax({
						method: "POST",
						url: "Registro",
						data: { tipoDocumento: tipoDocumento, documento: documento, tarjetasube: tarjetasube, nombre: nombre, apellido: apellido,
							clave: clave, genero: genero, mail: mail, movil: movil, telefonoFijo: telefonoFijo},
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
						window.location.href = "peticioncorrecta.jsp";
					})
				});
			});
			
			function emptyValue(field) {
				alert("Se debe completar el campo " + field);
			};
		</script>
		<style>
			p.hidden {
				display: none
			}
			
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
		</style>
		
	</head>
	<body>
		<%@ include file="/header.jsp" %>
		
			<div class="container">
				<div class="row">
					<div class="col-lg-3" style="padding-top:25px;">
		              	<label class="subtitle">Tipo de Documento</label> <BR>
		              	<input type="radio" name="radio-tipodocumento" id="radio-tipodocumento" value="Nacional" checked/>
		              	<label for="radio" >Nacional</label>
		              	<input type="radio" name="radio-tipodocumento" id="radio-tipodocumento" value="Extranjero"/>
		            	<label for="radio">Extranjero</label>
					</div>
					<div class="col-lg-5" style="padding-top:25px;">
    					<label for="documento" style="padding:35px;">Numero de documento: </label>
						<input id="documento" name="documento">
					</div>
					<div class="col-lg-4" style="padding-top:25px;">
    					<label for="tarjetasube" style="padding:35px;">Tarjeta sube: </label>
						<input id="tarjetasube" name="tarjetasube">
					</div>
					<div class="col-lg-12" style="padding-top:25px;">
						<label for="nombre" style="padding:35px;">Nombre: </label>
						<input id="nombre" name="nombre">
						<label for="apellido" style="padding:35px;">Apellido: </label>
						<input id="apellido" name="apellido">
						<label for="clave" style="padding:35px;">Clave: </label>
						<input id="clave" name="clave" type="password">						
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12"> 
		              	<label class="subtitle">Género</label> <BR>
		              	<input type="radio" name="radio-genero" id="radio-genero" value="masculino" checked/>
		              	<label for="radio" >Masculino</label>
		              	<input type="radio" name="radio-genero" id="radio-genero" value="femenino"/>
		            	<label for="radio">Femenino</label>
		            	<input type="radio" name="radio-genero" id="radio-genero" value="indefinido"/>
		            	<label for="radio">Indefinido</label>					
					</div>			
					<div class="col-lg-12">
						<label for="mail" style="padding:35px;">Mail: </label>
						<input id="mail" name="mail">
						<label for="movil" style="padding:35px;">Movil: </label>
						<input id="movil" name="movil">
						<label for="telefonofijo" style="padding:35px;">Teléfono fijo: </label>
						<input id="telefonofijo" name="telefonofijo">					
					</div>							
				</div>
				<div class="row">
					<div class="col-lg-6">
						<input id="registrarse" type="button" align="right" class="btn btn-succes;" value="Registrarse"/>
					</div>
	     		<div class="col-lg-4">
					<form action="/SistemaSube/index.jsp" method="POST">
						<button type="submit" name="boton-volver" value="Volver" class="button" style="padding:20px; maring:30px;">Volver</button>
					</form>
	     		</div>	  					
				</div>
			</div>
		</form>
	</body>
</html>