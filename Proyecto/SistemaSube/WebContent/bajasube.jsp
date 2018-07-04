<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript">
		
		$(document).ready(function(){
			$('#bajasube').click(function(){
				var nroTarjeta = $('#nroTarjeta').val();
				$.ajax({
					method: "POST",
					url: "BajaSube",
					data: {nroTarjeta: nroTarjeta},
					async: false
				}).done(function(data){
					$("#responseBajaSube").html(data);
				})
			});
		});
		</script>
		<title>Baja Sube</title>
	</head>
	
	<body>
		<%@include file="/header.jsp" %>
		<h1>Baja Sube</h1>
		
		<form class="navbar-form navbar-right">
		
		<label for="nroTarjeta">Numero Tarjeta:</label>
		<INPUT id="nroTarjeta" name="nroTarjeta">
		
		<INPUT id="bajasube" type="button" class="btn btn-success" value="BajaSube"/>
		
		</form>
		<form action="/SistemaSube/inicio.jsp" method="POST">
			<button type="submit" name="boton-volver" value="Volver" class="button" style="padding:20px; maring:30px;">Volver</button>
		</form>
		
		<div id="responseBajaSube"></div>
	</body>
</html>