package controladores;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Transaccion;
import negocio.TransaccionABM;



public class ControladorMostrarTransaccionesPorNroTarjeta extends HttpServlet{
	
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
			long nroTarjeta = Integer.parseInt(request.getParameter("nroTarjeta1"));
			List<Transaccion> transacciones = TransaccionABM.getInstance().traer(nroTarjeta);
			request.setAttribute("transacciones", transacciones);
			request.getRequestDispatcher("ajaxtransaccionesporusuario.jsp").forward(request, response);
		}catch(Exception e) {
			response.sendError(500," ");
		}
		}

}
