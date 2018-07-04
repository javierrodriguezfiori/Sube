<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datos.Viaje" %>
<%@page import="datos.Sesion" %>

<div class="container" style="padding-top:30px; margin-top:60px; border:1px solid black; width:700px; height:150px; background-color:Gainsboro;">
	<div class="row">
		<h4 style="margin:10px;">Viaje realizado - Boleto</h4>
		<div class="col-lg-6" ">
			Monto: ${monto} <br>
			Transporte: ${linea} <br>
		</div>
		<div class="col-lg-6" ">
			Fecha y hora: ${fechaYHora} <br>
			Nuevo saldo de la tarjeta: ${saldo} <br>
		</div>
	</div>
</div>
