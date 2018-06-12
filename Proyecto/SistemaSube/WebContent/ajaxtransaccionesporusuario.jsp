<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import= "datos.Transaccion"%>
<%@page import= "java.util.List" %>
<%@page import= "funciones.Funciones" %>
<%@page import= "datos.Viaje" %>
<%@page import= "datos.ViajeColectivo" %>
<%@page import= "datos.ViajeTren" %>
<%@page import= "datos.ViajeSubte" %>
<%@page import= "datos.Recarga" %>
<table border="1">
<caption>Historial Transacciones</caption>
<tr>
 <th>Fecha</th>
 <th>Hora</th>
 <th>Monto</th>
 <th>Tipo de Transaccion</th>
 <th>Detalle</th>

<% String detalle = new String();
List<Transaccion> transacciones = (List)request.getAttribute("transacciones");
for(Transaccion transaccion : transacciones){ %>
<tr>
 <td><%= Funciones.traerFechaCorta(transaccion.getFechaHora()) %> </td>
 <td><%=Funciones.traerHora(transaccion.getFechaHora()) %>
 <td><%= transaccion.getMonto() %> </td>
 <td><%= transaccion.getClass().getSimpleName() %> </td>
 
 <%if (transaccion instanceof Recarga)detalle=" " ;%>
 
 <%if (transaccion instanceof ViajeColectivo){ViajeColectivo viaje =(ViajeColectivo)transaccion;
 detalle="Linea: " + viaje.getTransporte().getLinea() + " ,Tramo: " + viaje.getTramo().getDistancia();} %>
 
 <%if (transaccion instanceof ViajeSubte){ViajeSubte viaje =(ViajeSubte)transaccion;
 detalle="Linea: " + viaje.getTransporte().getLinea() + " ,Estacion: " + viaje.getOrigen().getNombre();} %>
 
 <%if (transaccion instanceof ViajeTren){ViajeTren viaje =(ViajeTren)transaccion;
 detalle="Linea: " + viaje.getTransporte().getLinea() + " ,Origen: " + viaje.getOrigen().getNombre() 
		+ " ,Destino " + viaje.getDestino().getNombre() ;} %>
 
 <td><%= detalle.toString() %> </td>
 </tr>
 <%} %>
</table>