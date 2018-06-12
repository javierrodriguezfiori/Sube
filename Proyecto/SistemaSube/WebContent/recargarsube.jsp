<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript">
		
		$(document).ready(function(){
			$('#recargarsube').click(function(){
				var nroTarjeta = $('#nroTarjeta').val();
				var monto = $('#monto').val();
				$.ajax({
					method: "POST",
					url: "RecargarSube",
					data: {nroTarjeta: nroTarjeta, monto: monto},
					async: false
				}).done(function(data){
					$("#responseRecargarSube").html(data);
				})
			});
		});
		</script>
		<title>Recargar Sube</title>
	</head>
	
	<body>
		<%@include file="/header.jsp" %>
		<h1>Recargar Sube</h1>
		
		<form class="navbar-form navbar-right">
		
		<label for="nroTarjeta">Numero Tarjeta:</label>
		<INPUT id="nroTarjeta" name="nroTarjeta">
		
		<label for="nroTarjeta">Monto a recargar:</label>
		<INPUT id="monto" name="monto">
		
		<INPUT id="recargarsube" type="button" class="btn btn-success" value="RecargarSube"/>
		
		</form>
		<form action="/SistemaSube/seleccionartarjetaytransporte.jsp" method="POST">
					<button type="submit" name="boton-volver" value="Volver" class="button" style="padding:20px; maring:30px;">Volver</button>
				</form>
		
		<div id="responseRecargarSube"></div>
	</body>
</html>