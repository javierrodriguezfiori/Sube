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
	    <meta http-equiv="cache-control" content="max-age=0" />
		<meta http-equiv="cache-control" content="no-cache" />
		
	    <link rel="icon" type="image/png" href="http://lametro.edu.ec/wp-content/uploads/2017/03/favicon.png">
	    <link rel="stylesheet" href="https://gla2imagenes.blob.core.windows.net/constanciadigitalresources/resources/js/plugins/bootstrap/dist/css/bootstrap.min.css?sv=2017-04-17&si=constanciadigitalresourcesro-1602180B752&sr=c&sig=I4p4EsqgDQCjnWb3e5TJDSaW5iBsit%2FwVoCr4lHZBpQ%3D">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.css">
		<link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.min.css">
		<link rel="stylesheet" href="WEB-INF/lib/font-awesome-4.7.0/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<style>
		      body {
	        background-color: white;
	        font-family: 'Roboto';
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
	</style>
	
	</head>
	<body>
		<%@ include file="/header.jsp" %>
		<div style="margin-top:10%;">
			<form action="/SistemaSube/login.jsp" method="POST" style="display: inline-block; align: center; padding-left: 20%">
				<p class="tool"><button type="submit" class="btn" style="display: inline-block;"><i class="fa fa-sign-in fa-5x" aria-hidden="true"></i></button>
				<span class="tooltiptext">Entrar</span></p>
			</form>				
		
			<form action="/SistemaSube/registrarse.jsp" method="POST" style="display: inline-block; align: center; padding-left: 20%">
				<p class="tool"><button type="submit" class="btn" style="display: inline-block"><i class="fa fa-registered fa-5x" aria-hidden="true"></i></button>
				<span class="tooltiptext">Registrarse</span></p>
			</form>				
		
			<form action="/SistemaSube/cobrarViaje.jsp" method="POST" style="display: inline-block; align: center; padding-left: 20%">
				<p class="tool"><button type="submit" class="btn" style="display: inline-block"><i class="fa fa-train fa-5x" aria-hidden="true"></i></button>
				<span class="tooltiptext" style="width: 120px;">Realizar un viaje</span></p>
			</form>				
		</div>
	</body>
</html>