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
		<style>
		.center-screen {
 			 display: flex;
 			 flex-direction: column;
			 justify-content: center;
 			 align-items: center;
  			 text-align: center;
			}
		</style>
		<title>Asignar Tarifa Social</title>
	</head>
	
	<body class="center-screen">
		<%@include file="/header.jsp" %>
		<h1>Asignar Tarifa Social</h1>
		
		<form class="navbar-form navbar-right">
		
		<label for="nroTarjeta"><h4>Numero Tarjeta:</h4></label>
		<INPUT id="nroTarjeta" name="nroTarjeta" class="form-control" style="width: 300px">
		
		<div class="col-lg-4" style="padding-top:50px;">
           <label class="subtitle"><h4>¿Qué tarifa desea tramitar?</h4></label> <BR>
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
	    <div style="padding-top:30px">
		<INPUT id="asignartarifasocial" type="button" class="btn btn-primary" value="AsignarTarifaSocial"/>
		</div>
		</form>
				<form action="/SistemaSube/inicio.jsp" method="POST" style="padding-top: 30px">
					<button type="submit" name="boton-volver" value="Volver" class="btn btn-primary">Volver</button>
				</form>
		
		<div id="responseAsignarTarifaSocial"></div>
	</body>
</html>