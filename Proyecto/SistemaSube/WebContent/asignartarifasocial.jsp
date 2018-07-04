<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript">
		
		$(document).ready(function(){
			$('#asignartarifasocial').click(function(){
				var nroTarjeta = $('#nroTarjeta').val();
				var tarifa = $('.radio-option:checked').val();
				$.ajax({
					method: "POST",
					url: "AsignarTarifaSocial",
					data: {nroTarjeta: nroTarjeta, tarifa: tarifa},
					async: false
				}).done(function(data){
					$("#responseAsignarTarifaSocial").html(data);
				})
			});
		});
		</script>
		<title>Asignar Tarifa Social</title>
	</head>
	
	<body>
		<%@include file="/header.jsp" %>
		<h1>Asignar Tarifa Social</h1>
		
		<form class="navbar-form navbar-right">
		
		<label for="nroTarjeta">Numero Tarjeta:</label>
		<INPUT id="nroTarjeta" name="nroTarjeta">
		
		<div class="col-lg-4" style="padding-top:50px;">
           <label class="subtitle">¿Qué tarifa desea tramitar?</label> <BR>
           <input type="radio" class="radio-option" name="tarifa" value="tarifasocial" checked/>
           <label for="radio" >Tarifa Social</label>
           <input type="radio" class="radio-option" name="tarifa" value="boletoestudiantil"/>
           <label for="radio" >Boleto Estudiantil</label>
           <input type="radio" class="radio-option" name="tarifa" value="sindescuento"/>
           <label for="radio" >Sin Descuento</label>
           <!--  <select id="tarifa" name="tarifa">
           <option value="sindescuentos">Sin Descuentos</option>
           <option value="tarifasocial">Tarifasocial</option>
           <option value="boletoestudiantil">Boleto Estudiantil</option>-->
           
           </select>
	    </div>
		<INPUT id="asignartarifasocial" type="button" class="btn btn-success" value="AsignarTarifaSocial"/>
		
		</form>
				<form action="/SistemaSube/inicio.jsp" method="POST">
					<button type="submit" name="boton-volver" value="Volver" class="button" style="padding:20px; maring:30px;">Volver</button>
				</form>
		
		<div id="responseAsignarTarifaSocial"></div>
	</body>
</html>