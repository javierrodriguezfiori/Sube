<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Google Chart</title>
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
				data.addColumn('string', 'Name');
				data.addColumn('number', 'Quantity');
				var dataArray = [];
				$.each(result, function(i, obj){
					dataArray.push([obj.name, obj.quantity]);
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
</head>
<body>
	<table class="columns">
		<tr>
			<td><div id="piechart_div" style="border: 1px solid #ccc"></div></td>
			<td><div id="barchart_div" style="border: 1px solid #ccc"></div></td>
		</tr>
	</table>
</body>
</html>