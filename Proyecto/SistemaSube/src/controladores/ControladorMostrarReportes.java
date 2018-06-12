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
			
			
			GregorianCalendar fechaHoraInicio = Funciones.traerFecha(fechaInicio, horaInicio);
			GregorianCalendar fechaHoraFin = Funciones.traerFecha(fechaFin,horaFin);
			
			
			List<Viaje> viajes = ViajeDao.getInstance().traer(fechaHoraInicio, fechaHoraFin);
			System.out.println(Funciones.imprimirLista(viajes));
			request.setAttribute("viajes", viajes);
			request.getRequestDispatcher("ajaxreportes.jsp").forward(request, response);;
			
		}catch(Exception e) {
			response.sendError(500,"Fecha Incorrecta");
		}
		}

}
