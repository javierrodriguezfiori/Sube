<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="datos.Sesion" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#consultarsaldo').click(function(){
			var nroTarjeta = $('#tarjetasube').val();
			$.ajax({
				method: "POST",
				url: "ConsultarSaldo",
				data: {nroTarjeta: nroTarjeta},
				async: false,
				statusCode: {
					404:function() {
						$('#error404').removeClass("hidden");
					}
				}
			}).done(function(data){
				$('#error404').addClass("hidden");
				$("#responsesaldo").html(data);
			})
		});
	});

	$(document).ready(function(){
		$('#consultartransacciones').click(function(){
			var nroTarjeta = $('#tarjetasube').val();
			$.ajax({
				method: "POST",
				url: "MostrarTransaccionesPorNroTarjeta",
				data: {nroTarjeta: nroTarjeta},
				async: false,
				statusCode: {
					404:function() {
						$('#error404').removeClass("hidden");
					}
				}
			}).done(function(data){
				$('#error404').addClass("hidden");
				$("#responsetransacciones").html(data);
			})
		});
	});

	$(document).ready(function(){
			var usuarioLogeado = $('#usuarioLogeado').val();

			if (usuarioLogeado == "true/")
				$('#nroTarjetaSube-Logeada').removeClass("hidden");
			else 
				$('#nroTarjetaSube-NoLogeada').removeClass("hidden");
		})

</script>

	
	
		<% 
		String retorno = "home.jsp";
		
		if (Sesion.obtenerSesionActual().getUsuarioLogeado() != null) // Si, ya s�, pero bueno.
		{
			if (Sesion.obtenerSesionActual().tienePrivilegios())
				retorno = "homeAdmin.jsp";
		} else
			retorno = "index.jsp";
		%>




<title>Consultar Saldo</title>
</head>

	<body>
		<%@include file="/header.jsp" %>
		
		<%
		String nroTarjetaSube = "";
		boolean tienePrivilegios = Sesion.obtenerSesionActual().getUsuarioLogeado() != null && Sesion.obtenerSesionActual().tienePrivilegios();
		boolean usuarioLogeado = Sesion.obtenerSesionActual().getUsuarioLogeado() != null && !Sesion.obtenerSesionActual().tienePrivilegios(); 
		if (usuarioLogeado && !Sesion.obtenerSesionActual().tienePrivilegios())
			nroTarjetaSube = String.valueOf(Sesion.obtenerSesionActual().getTarjetaSubeDelUsuario().getNroTarjeta());
		%>		
		<input type="text" id="usuarioLogeado" style="display:none;" value=<%=usuarioLogeado%>/>
		<input type="text" id="tienePrivilegios" style="display:none;" value=<%=tienePrivilegios%>/>
		
		<h1>Consultas</h1>
		<div class="container">
			<div class="row">
	          	<div class="col-lg-4 hidden" id="nroTarjetaSube-Logeada" style="padding-top:30px;">
	           		<label style="margin-top:20px; padding-right:20px; color:#787878;"><h4>Tarjeta Sube > <%=nroTarjetaSube%></h4></label> <br>        		
	         	</div>
	          	<div class="col-lg-4 hidden" id="nroTarjetaSube-NoLogeada" style="padding-top:30px;">
	           		<label class="subtitle" style="margin-top:20px; padding-right:20px; color:#787878;">Tarjeta Sube > </label><input type="text" name="tarjetasube" id="tarjetasube"> <br>
	           		<label id="error404" class="hidden">La tarjeta sube ingresada no existe.</label>
	         	</div>
	     	</div>
	     	
	     		<div style="padding-right: 200px;display:inline-block">
	     			<INPUT id="consultartransacciones" type="button" class="btn btn-primary" value="Consultar transacciones" style="display:inline-block"/>
	     		</div>
	     		<div style="padding-right: 200px;display:inline-block">
	     			<INPUT id="consultarsaldo" type="button" class="btn btn-primary" value="Consultar saldo" style="display:inline-block"/>
	     		</div>
	     		<div style="padding-right: 200px;display:inline-block">
					<form action="inicio.jsp" method="POST">
						<button type="submit" name="boton-volver" value="Volver" class="btn btn-primary" style="display:inline-block">Volver</button>
					</form>
	     		</div>	     		
	     	
	     </div>		
		<div id="responsesaldo"></div>
		<div id="responsetransacciones"></div>
	</body>
</html>