<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reportes</title>
<script src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#reporte').click(function(){
		var fechaInicio = $('#fechaInicio').val();
		var horaInicio = $('#horaInicio').val();
		var fechaFin = $('#fechaFin').val();
		var horaFin = $('#horaFin').val();
		$.ajax({
			method: "POST",
			url: "MostrarReportes",
			data: {fechaInicio: fechaInicio,
			       horaInicio: horaInicio,
			       fechaFin: fechaFin,
			       horaFin: horaFin},
			async: false
		}).done(function(data){
			$("#responsereporte").html(data);
		})
	});
});
</script>
</head>
<body>
<%@include file="/header.jsp" %>
<h1>Reportes</h1>
<form class="navbar-form navbar-right">
<label for="fechaInicio">fecha Inicio</label>
<INPUT id="fechaInicio" value="DD/MM/AAAA" name="fechaInicio">

<label for="horaInicio">hora Inicio</label>
<INPUT id="horaInicio" value="HH:MM:SS" name="horaInicio">

<label for="fechaFin">fecha Fin</label>
<INPUT id="fechaFin" value="DD/MM/AAAA" name="fechaFin">

<label for="horaFin">hora Fin</label>
<INPUT id="horaFin" value="HH:MM:SS" name="horaFin">

<INPUT id="reporte"  type="button" class="btn btn-succes" value="Reporte"/>
</form>

<div id="responsereporte"></div>
</body>
</html>