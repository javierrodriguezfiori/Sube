<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datos.Viaje"%>
<%@page import="java.util.List" %>
<%@page import="datos.Transaccion" %>
<%@page import="negocio.Muestra" %>
<%@page import="funciones.Funciones" %>
<%@page import="datos.TransportePublico" %>
<%@page import="datos.Tren" %>
<%@page import="datos.Colectivo" %>
<%@page import="datos.Subte" %>


<%Tren tren = (Tren)request.getAttribute("tren"); %>
<table border="1">
<caption>Estadistica Tren : <%=tren.getLinea() %> </caption>
<tr>
 <th>Origen</th>
 <th>Destino</th>
 <th>Cantidad de Viajes</th>
 <th>Total</th>

<% List<Muestra> cant = (List)request.getAttribute("estadistica");
for(Muestra muestra : cant){ %>
<tr>
 <td><%= muestra.getNombre() %> </td>
 <td><%= muestra.getNombre2() %>
 <td><%= muestra.getCant() %> </td>
 <td><%= muestra.getSum() %> 
 
 </tr>
 <%} %>
</table>

<script type="text/javascript">
	$(document).ready(function(){
		google.charts.load('current', {'packages': ['corechart']});
		google.charts.setOnLoadCallback(function() { drawChart();});
		
		function drawChart(result){
			var data= new google.visualization.DataTable();
			data.addColumn('string', 'Nombre');
			data.addColumn('number', 'Cantidad');
			
			var dataArray = [];
			
	 		data.addRows([
		          ['Mushrooms', 3],
		          ['Onions', 1],
		          ['Olives', 1],
		          ['Zucchini', 1],
		          ['Pepperoni', 2]
		    ]);
	 		
			data.addRows(dataArray);
			
			var piechart_options = {
				title : 'Grafico circular',
				width : 400,
				height : 300,
			};
			
			var piechart = new google.visualization.PieChart(document.getElementById('piechart_div'));
			piechart.draw(data, piechart_options);
		}
	});
</script>

<table class="columns">
	<tr>
		<td><div id="piechart_div"></div></td>
	</tr>
</table>









