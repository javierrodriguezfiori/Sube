<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datos.Viaje"%>
<%@page import="java.util.List" %>
<%@page import="datos.Transaccion" %>
<%@page import="funciones.Funciones" %>



 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
			$.ajax({
				url:"ChartController",
				dataType: "JSON",
				success: function(result){
					google.charts.load('current', {
						'packages': ['corechart']
					});
					google.charts.setOnLoadCallback(function() {
						drawChart(result);
					});
				}
			});
			
			function drawChart(result){
				var data= new google.visualization.DataTable();
				data.addColumn('string', 'Parada');
				data.addColumn('number', 'Cantidad');
				var dataArray = [];
				$.each(result, function(i, obj){
					dataArray.push([obj.nombre, obj.muestra]);
				});
				
				data.addRows(dataArray);
				
				var piechart_options = {
					title : 'Pie Chart: How much products sold by last night',
					width : 400,
					height : 300,
				};
				
				var piechart = new google.visualization.PieChart(document.getElementById('piechart_div'));
				piechart.draw(data, piechart_options);
				
				var barchart_options = {
						title : 'Barchart: how much products sold by last night',
						width : 400,
						height : 300,
						legend : 'none'
				};
				
				var barchart = new google.visualization.Barchart(document.getElementById('barchart_div'));
				barchart.draw(data, barchart_options);
			}
		});
	</script>

	<table class="columns">
		<tr>
			<td><div id="piechart_div" style="border: 1px solid #ccc"></div></td>
			<td><div id="barchart_div" style="border: 1px solid #ccc"></div></td>
		</tr>
	</table>



