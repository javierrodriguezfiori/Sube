<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.TransportePublico" %>
<%@page import="java.util.List" %>
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
		var Transporte = $('#Transporte').val()
		$.ajax({
			method: "POST",
			url: "MostrarReportes",
			data: {fechaInicio: fechaInicio,
			       horaInicio: horaInicio,
			       fechaFin: fechaFin,
			       horaFin: horaFin,
			       Transporte: Transporte,
			       },
			async: false
		}).done(function(data){
			$("#responsereporte").html(data);
		})
	});
});
</script>


<script type="text/javascript">
$(document).ready(function(){
	$('#reportecolectivos').click(function(){
		var fechaInicio1 = $('#fechaInicio1').val();
		var horaInicio1 = $('#horaInicio1').val();
		var fechaFin1 = $('#fechaFin1').val();
		var horaFin1 = $('#horaFin1').val();
		var lineaColectivo = $('#lineaColectivo').val()
		$.ajax({
			method: "POST",
			url: "MostrarReportesPorColectivo",
			data: {fechaInicio1: fechaInicio1,
			       horaInicio1: horaInicio1,
			       fechaFin1: fechaFin1,
			       horaFin1: horaFin1,
			       lineaColectivo: lineaColectivo,
			       },
			async: false
		}).done(function(data){
			$("#responsereportecolectivos").html(data);
		})
	});
});
</script>


<script type="text/javascript">
$(document).ready(function(){
	$('#reportesubtes').click(function(){
		var fechaInicio2 = $('#fechaInicio2').val();
		var horaInicio2 = $('#horaInicio2').val();
		var fechaFin2 = $('#fechaFin2').val();
		var horaFin2 = $('#horaFin2').val();
		var lineaSubte = $('#lineaSubte').val()
		$.ajax({
			method: "POST",
			url: "MostrarReportesPorSubte",
			data: {fechaInicio2: fechaInicio2,
			       horaInicio2: horaInicio2,
			       fechaFin2: fechaFin2,
			       horaFin2: horaFin2,
			       lineaSubte: lineaSubte,
			       },
			async: false
		}).done(function(data){
			$("#responsereportesubtes").html(data);
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
<INPUT id="fechaInicio" value="05/05/2018" name="fechaInicio">

<label for="horaInicio">hora Inicio</label>
<INPUT id="horaInicio" value="00:00:00" name="horaInicio">

<label for="fechaFin">fecha Fin</label>
<INPUT id="fechaFin" value="11/06/2018" name="fechaFin">

<label for="horaFin">hora Fin</label>
<INPUT id="horaFin" value="00:00:00" name="horaFin">
<label class="subtitle">Seleccione tipo de Transporte</label> <BR>
<select id="Transporte" name="Transporte">
 <option value="1">Todos</option>
 <option value="2">Tren</option>
 <option value="3">Colectivo</option>
 <option value="4">Subte</option>
</select>

<INPUT id="reporte"  type="button" class="btn btn-succes" value="Reporte"/>
</form>





<form class="navbar-form navbar-right">
<label for="fechaInicio1">fecha Inicio</label>
<INPUT id="fechaInicio1" value="05/05/2018" name="fechaInicio">

<label for="horaInicio1">hora Inicio</label>
<INPUT id="horaInicio1" value="00:00:00" name="horaInicio">

<label for="fechaFin1">fecha Fin</label>
<INPUT id="fechaFin1" value="11/06/2018" name="fechaFin">

<label for="horaFin1">hora Fin</label>
<INPUT id="horaFin1" value="00:00:00" name="horaFin">
<% List<TransportePublico> lineasColectivo = (List) request.getAttribute("colectivos"); %>
                        <label class="subtitle">Seleccione la linea de Colectivo</label> <BR>
						<select id="lineaColectivo" name="lineaColectivo" style="width:200px; align:center;">
							<option values="0">Selecciona una linea</option>
							<% for (TransportePublico colectivo : lineasColectivo) { %>
							<%String linea = colectivo.getLinea();%>
							<option value="<%=linea%>"><%=linea%></option>
							<% } %>
						</select>

<INPUT id="reportecolectivos"  type="button" class="btn btn-succes" value="ReporteColectivo"/>
</form>



<form class="navbar-form navbar-right">
<label for="fechaInicio2">fecha Inicio</label>
<INPUT id="fechaInicio2" value="05/05/2018" name="fechaInicio">

<label for="horaInicio2">hora Inicio</label>
<INPUT id="horaInicio2" value="00:00:00" name="horaInicio">

<label for="fechaFin2">fecha Fin</label>
<INPUT id="fechaFin2" value="11/06/2018" name="fechaFin">

<label for="horaFin2">hora Fin</label>
<INPUT id="horaFin2" value="00:00:00" name="horaFin">
<% List<TransportePublico> lineasSubtes = (List) request.getAttribute("subtes"); %>
                        <label class="subtitle">Seleccione la linea de Subte</label> 
						<select id="lineaSubte" name="lineaSubte" style="width:200px; align:center;">
							<option values="0">Selecciona una linea</option>
							<% for (TransportePublico subte : lineasSubtes) { %>
							<%String linea = subte.getLinea();%>
							<option value="<%=linea%>"><%=linea%></option>
							<% } %>
						</select>

<INPUT id="reportesubtes"  type="button" class="btn btn-succes" value="ReporteSubte"/>
</form>


<div id="responsereporte"></div>
<div id="responsereportecolectivos"></div>
<div id="responsereportesubtes"></div>
</body>
</html>