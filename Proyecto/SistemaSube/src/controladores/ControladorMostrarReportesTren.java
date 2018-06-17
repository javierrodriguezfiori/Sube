
package controladores;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import funciones.Funciones;
import negocio.TransportePublicoABM;

import java.util.GregorianCalendar;
import dao.ViajeDao;
import dao.ViajeTrenDao;
import datos.Tren;
import datos.Viaje;
import datos.ViajeTren;

public class ControladorMostrarReportesTren extends HttpServlet {
	
	
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
			
			
			String fechaInicio = request.getParameter("fechaInicio3");
			String horaInicio = request.getParameter("horaInicio3");
			String fechaFin = request.getParameter("fechaFin3");
			String horaFin = request.getParameter("horaFin3");
			String linea = request.getParameter("lineaTren");
			
			GregorianCalendar fechaHoraInicio = Funciones.traerFecha(fechaInicio, horaInicio);
			GregorianCalendar fechaHoraFin = Funciones.traerFecha(fechaFin,horaFin);
			Tren tren = (Tren)TransportePublicoABM.getInstance().traerTransportePublico(linea);
			List<ViajeTren> viajesTren = ViajeTrenDao.getInstance().traerViajesTren(fechaHoraInicio, fechaHoraFin, tren.getIdTransporte());
			
			request.setAttribute("viajesTren", viajesTren);
			request.setAttribute("tren", tren);
			
			
			
			request.getRequestDispatcher("ajaxreportetrenporlinea.jsp").forward(request, response);
			
			
			
			
			
		}catch(Exception e) {
			response.sendError(500,"Fecha Incorrecta");
		}
		}

}
