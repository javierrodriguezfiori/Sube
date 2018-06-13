
package controladores;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import funciones.Funciones;
import java.util.GregorianCalendar;
import dao.ViajeDao;
import datos.Viaje;

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
			
			
			String fechaInicio = request.getParameter("fechaInicio");
			String horaInicio = request.getParameter("horaInicio");
			String fechaFin = request.getParameter("fechaFin");
			String horaFin = request.getParameter("horaFin");
			String linea = request.getParameter("linea");
			
			
			
			
			
		}catch(Exception e) {
			response.sendError(500,"Fecha Incorrecta");
		}
		}

}
