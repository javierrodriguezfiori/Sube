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
import dao.ViajeSubteDao;
import datos.Subte;
import datos.Viaje;
import datos.ViajeSubte;
import negocio.TransportePublicoABM;
public class ControladorMostrarReportesSubte extends HttpServlet {
	
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
			
			
			String fechaInicio = request.getParameter("fechaInicio2");
			String horaInicio = request.getParameter("horaInicio2");
			String fechaFin = request.getParameter("fechaFin2");
			String horaFin = request.getParameter("horaFin2");
			String linea = request.getParameter("lineaSubte");
			
			GregorianCalendar fechaHoraInicio = Funciones.traerFecha(fechaInicio, horaInicio);
			GregorianCalendar fechaHoraFin = Funciones.traerFecha(fechaFin,horaFin);
			Subte subte = (Subte)TransportePublicoABM.getInstance().traerTransportePublico(linea);
			List<ViajeSubte> viajesSubte = ViajeSubteDao.getInstance().traerViajesSubte(fechaHoraInicio, fechaHoraFin, subte.getIdTransporte());
			
			request.setAttribute("viajesSubte", viajesSubte);
			request.setAttribute("subte", subte);
			
			
			
			request.getRequestDispatcher("ajaxreportesubteporlinea.jsp").forward(request, response);
			
			
			
			
		}catch(Exception e) {
			response.sendError(500,"Fecha Incorrecta");
		}
		}

}
