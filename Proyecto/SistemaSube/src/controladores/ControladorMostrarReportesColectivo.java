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
import dao.ViajeColectivoDao;
import datos.Colectivo;
import datos.Viaje;
import datos.ViajeColectivo;
import negocio.TransportePublicoABM;

public class ControladorMostrarReportesColectivo extends HttpServlet {
	
	
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
			
			
			String fechaInicio = request.getParameter("fechaInicio1");
			String horaInicio = request.getParameter("horaInicio1");
			String fechaFin = request.getParameter("fechaFin1");
			String horaFin = request.getParameter("horaFin1");
			String linea = request.getParameter("lineaColectivo");
			System.out.println(linea);
			GregorianCalendar fechaHoraInicio = Funciones.traerFecha(fechaInicio, horaInicio);
			GregorianCalendar fechaHoraFin = Funciones.traerFecha(fechaFin,horaFin);
			Colectivo colectivo = (Colectivo)TransportePublicoABM.getInstance().traerTransportePublico(linea);
			List<ViajeColectivo> viajesColectivo = ViajeColectivoDao.getInstance().traerViajesColectivo(fechaHoraInicio, fechaHoraFin, colectivo.getIdTransporte());
			
			request.setAttribute("viajesColectivo", viajesColectivo);
			request.setAttribute("colectivo", colectivo);
			
			
			request.getRequestDispatcher("ajaxreportecolectivoporlinea.jsp").forward(request, response);
			
			
			
			
		}catch(Exception e) {
			response.sendError(500,"Fecha Incorrecta");
		}
		}

}



