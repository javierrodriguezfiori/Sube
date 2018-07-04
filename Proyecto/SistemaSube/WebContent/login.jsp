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
		<link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.css">
		<link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.min.css">
		<script src="js/jquery-3.3.1.min.js"></script>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$('#login').click(function() {
					var documento = $('#documento').val();
					var password = $('#password').val();
					$.ajax({
						method: "POST",
						url: "Login",
						data: { documento: documento, password: password},
						async: false,
						statusCode: {
							404: function() {
								alert("Documento o clave incorrecta, vuelva a intentar.");
							},
							500: function() {
								window.location.href = "peticionerronea.jsp";
							}
						}
					}).done(function(data) {
						window.location.href = "inicio.jsp";
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
		
	</head>
	<body>
		<%@ include file="/header.jsp" %>	
		<div class="center-screen">
			<h4>Inicio</h4>
    		<div class="form-group">
     			<label for="documento" style="padding:35px">Documento: </label>
				<input id="documento" name="documento" class="form-control" placeholder="Documento" style="width:200px">
      			<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    		</div>
    		<div class="form-group">
    			<label for="password" style="padding:25px">Password: </label>
				<input id="password" name="password" type="password" class="form-control" placeholder="Password" style="width:200px"> <p id="error" class="hidden">Documento o clave incorrecto, vuelva a intentar.</p>
   			</div>
<<<<<<< HEAD
   			<input type="submit" id="login" class="btn btn-primary" value="Entrar">
		</form>
=======
    		<button type="submit" id="login" class="btn btn-primary" value="Entrar">Entrar</button>
		</div>
>>>>>>> master
	</body>
</html>