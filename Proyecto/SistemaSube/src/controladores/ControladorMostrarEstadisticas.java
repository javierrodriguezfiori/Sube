package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import funciones.Funciones;
import java.util.GregorianCalendar;

import negocio.Muestra;
import negocio.TransportePublicoABM;
import negocio.ViajeABM;
import datos.Colectivo;
import datos.Subte;
import datos.TransportePublico;
import datos.Tren;
import datos.Viaje;
import datos.ViajeColectivo;
import datos.ViajeSubte;
import datos.ViajeTren;

public class ControladorMostrarEstadisticas extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			
			String fechaInicio = (String) request.getParameter("fechaInicio");
			String fechaFin = (String) request.getParameter("fechaFin");
			
			GregorianCalendar fechaHoraInicio = parsearFechaEnTexto(fechaInicio);
			GregorianCalendar fechaHoraFin = parsearFechaEnTexto(fechaFin);
			
			long idTransporte = Long.parseLong((String) request.getParameter("idLineaDeTransporte"));
		
			TransportePublico transportePublico = TransportePublicoABM.getInstance().traer(idTransporte);
			
			List<Muestra> estadistica = null;
			
			if(transportePublico instanceof Tren) {
				estadistica = ViajeABM.getInstance().estadisticaViajesTren(fechaHoraInicio, fechaHoraFin, transportePublico.getIdTransporte()).getMuestras();			
			}
			
			if(transportePublico instanceof Colectivo) {
				estadistica = ViajeABM.getInstance().estadisticaViajesColectivo(fechaHoraInicio, fechaHoraFin, transportePublico.getIdTransporte()).getMuestras();			
			}
			
			if(transportePublico instanceof Subte) {
				estadistica = ViajeABM.getInstance().estadisticaViajesSubte(fechaHoraInicio, fechaHoraFin, transportePublico.getIdTransporte()).getMuestras();
			}
		
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(estadistica));
			
		}catch(Exception e) {
			response.sendError(500,"Fecha Incorrecta");
		}
		}
	
	private GregorianCalendar parsearFechaEnTexto(String fechaEnTexto) {
		GregorianCalendar fechaFormateada = null;
		
		if (fechaEnTexto.isEmpty())
			fechaFormateada = new GregorianCalendar();
		else {
			int dia = Integer.parseInt(fechaEnTexto.substring(0, 2));
			int mes = Integer.parseInt(fechaEnTexto.substring(3, 5));
			int anio = Integer.parseInt(fechaEnTexto.substring(6, 10));
			int hora = Integer.parseInt(fechaEnTexto.substring(11, 13));
			int minutos = Integer.parseInt(fechaEnTexto.substring(14, 16));
			fechaFormateada = new GregorianCalendar(anio, mes - 1, dia, hora, minutos);
		}
		
		return fechaFormateada;	
	}

}
