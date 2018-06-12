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
		<script src="js/jquery-3.3.1.min.js"></script>
		
		<script type="text/javascript">
		
			$(document).ready(function() {
				$('#login').click(function() {
					var usuario = $('#usuario').val();
					var password = $('#password').val();
					$.ajax({
						method: "POST",
						url: "Login",
						data: { usuario: usuario, pasword: password},
						async: false,
						statusCode: {
							404: function() {
								$("#error").removeClass("hidden");
							},
						}
					}).done(function(data) {
						$("#responselogin").html(data);
					})
				});
			});
		</script>
		<style>
			p.hidden {
				display: none
			}
			
				      body {
	        background-color: white;
	        font-family: 'Roboto';
	      }
	
	      .formulario {
	          background: gainsboro;
	      }
	
	      .subtitle {
	        font-size: 16px;
	      }
	
	      .radio-option {
	        padding-right: 10px;
	      }
	      
      		.button {
		   	background-color: #008CBA;
		    border: none;
		    color: white;
		    padding: 15px 32px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 12px;
		    border-radius: 8px;
		    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
		    opacity: 0.6;
		}
		</style>
		
	</head>
	<body>
		<%@ include file="/header.jsp" %>
		<form>
			<div class="container">
				<div class="row">
					<div class="col-lg-4" style="padding-top:25px;">
						<label for="usuario" style="padding:35px;">Usuario: </label>
						<input id="usuario" name="usuario">
						<label for="password" style="padding:25px;">Password: </label>
						<input id="password" name="password"> <p id="error" class="hidden">Usuario inexistente, vuelva a intentar.</p>
						
					</div>
					<div class="col-lg-4" style="padding-top:170px;">
						<input id="login" type="button" class="btn btn-succes;" value="login"/>
					</div>

				</div>
			</div>
		</form>
	</body>
</html>