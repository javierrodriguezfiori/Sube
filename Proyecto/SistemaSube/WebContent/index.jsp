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
		<link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.css">
		<link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.min.css">
		
	
	</head>
	<body>
		<%@ include file="/header.jsp" %>
		
				<div style="margin-top:10%">
					<form action="/SistemaSube/login.jsp" method="POST" style="display: inline-block; align: center; padding-left: 20%">
						<button type="submit" name="boton-volver" value="Logearse" class="btn btn-primary" style="display: inline-block">Entrar</button>
					</form>				
				
					<form action="/SistemaSube/registrarse.jsp" method="POST" style="display: inline-block; align: center; padding-left: 20%">
						<button type="submit" name="boton-volver" value="Registrarse" class="btn btn-primary" style="display: inline-block">Registrarse</button>
					</form>				
				
				
					<form action="/SistemaSube/cobrarViaje.jsp" method="POST" style="display: inline-block; align: center; padding-left: 20%">
						<button type="submit" name="boton-volver" value="EmitirBoleto" class="btn btn-primary" style="display: inline-block">Realizar viaje</button>
					</form>				
				</div>
			
	</body>
</html>