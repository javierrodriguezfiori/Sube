<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tarifa Sube ABM</title>
</head>
<body>
<%@ include file="/header.jsp" %>
	    <form method="POST" action="/SistemaSube/SeleccionarTarifa">
	      <div class="container">
	        <div class="row" id="responseviaje">
	           <div class="col-lg-4" style="padding-top:50px;">
	              <label class="subtitle">¿Qué tarifa desea tramitar?</label> <BR>
	              <input type="radio" name="tarifa" id="radio" value="tarifasocial" checked/>
	              <label for="radio" class="radio-option">Tarifa Social</label>
	              <input type="radio" name="tarifa" id="radio" value="boletoestudiantil"/>
	              <label for="radio" class="radio-option">Boleto Estudiantil</label>
	              <input type="radio" name="tarifa" id="radio" value="sindescuento"/>
	              <label for="radio" class="radio-option">Sin Descuento</label>
	          </div>
	          <div class="col-lg-4" style="padding:50px; align:right;">
	          	<input type="submit" value="Avanzar" class="button">
	          </div>
	        </div>
	      </div>
	    </form>
</body>
</html>