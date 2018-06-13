package controladores;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import funciones.Funciones;
import java.util.GregorianCalendar;
import dao.ViajeDao;
import datos.Viaje;

public class ControladorMostrarReportes extends HttpServlet {
	
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
			
			String fechaInicio = request.getParameter("fechaInicio");
			String horaInicio = request.getParameter("horaInicio");
			String fechaFin = request.getParameter("fechaFin");
			String horaFin = request.getParameter("horaFin");
			int opcion = Integer.parseInt(request.getParameter("Transporte"));
			GregorianCalendar fechaHoraInicio = Funciones.traerFecha(fechaInicio, horaInicio);
			GregorianCalendar fechaHoraFin = Funciones.traerFecha(fechaFin,horaFin);
			
			if(opcion==1) {
				
				
				
				List<Viaje> viajesTren = ViajeDao.getInstance().traerViajesTren(fechaHoraInicio, fechaHoraFin);
				List<Viaje> viajesColectivo = ViajeDao.getInstance().traerViajesColectivo(fechaHoraInicio, fechaHoraFin);
				List<Viaje> viajesSubte = ViajeDao.getInstance().traerViajesSubte(fechaHoraInicio, fechaHoraFin);
				
				request.setAttribute("viajesTren", viajesTren);
				request.setAttribute("viajesColectivo", viajesColectivo);
				request.setAttribute("viajesSubte", viajesSubte);
				
				request.getRequestDispatcher("ajaxreportes.jsp").forward(request, response);
				
				
			}
			
			if(opcion==2){
				List<Viaje> viajesTren = ViajeDao.getInstance().traerViajesTren(fechaHoraInicio, fechaHoraFin);
				request.setAttribute("viajesTren", viajesTren);
				request.getRequestDispatcher("ajaxreportetren.jsp").forward(request, response);
				
			}
			

			if(opcion==3){
				List<Viaje> viajesColectivo = ViajeDao.getInstance().traerViajesColectivo(fechaHoraInicio, fechaHoraFin);
				request.setAttribute("viajesColectivo", viajesColectivo);
				request.getRequestDispatcher("ajaxreportecolectivo.jsp").forward(request, response);
				
			}

			if(opcion==4){
				List<Viaje> viajesSubte = ViajeDao.getInstance().traerViajesSubte(fechaHoraInicio, fechaHoraFin);
				request.setAttribute("viajesSubte", viajesSubte);
				request.getRequestDispatcher("ajaxreportesubte.jsp").forward(request, response);
				
			}
			
			
			
			
			

			
		}catch(Exception e) {
			response.sendError(500,"Fecha Incorrecta");
		}
		}

}
