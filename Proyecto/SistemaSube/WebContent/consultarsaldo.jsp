<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#consultarsaldo').click(function(){
		var nroTarjeta = $('#nroTarjeta').val();
		$.ajax({
			method: "POST",
			url: "ConsultarSaldo",
			data: {nroTarjeta: nroTarjeta},
			async: false
		}).done(function(data){
			$("#responsesaldo").html(data);
		})
	});
});
</script>


<title>Consultar Saldo</title>
</head>

<body>
<%@include file="/header.jsp" %>
<h1>Consultar Saldo</h1>

<form class="navbar-form navbar-right">

<label for="nroTarjeta">Numero Tarjeta:</label>
<INPUT id="nroTarjeta" name="nroTarjeta">

<INPUT id="consultarsaldo" type="button" class="btn btn-success" value="ConsultarSaldo"/>
</form>
<form action="/SistemaSube/seleccionartarjetaytransporte.jsp" method="POST">
			<button type="submit" name="boton-volver" value="Volver" class="button" style="padding:20px; maring:30px;">Volver</button>
		</form>

<div id="responsesaldo"></div>
</body>
</html>