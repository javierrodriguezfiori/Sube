package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.TarjetaSube;
import negocio.TarjetaSubeABM;
import negocio.TerminalRecarga;
import datos.Recarga;

public class ControladorRecargarSube extends HttpServlet {
	
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
			
			long nroTarjeta = Integer.parseInt(request.getParameter("nroTarjeta"));
			double monto = Double.parseDouble(request.getParameter("monto"));	
			TarjetaSube tarjeta = TarjetaSubeABM.getInstance().traerTarjetaSube(nroTarjeta);
			Recarga recarga = new Recarga((float)monto, new GregorianCalendar(), tarjeta);
			TerminalRecarga.getInstance().registrarRecarga(tarjeta, recarga);
			request.setAttribute("tarjeta", tarjeta);
			request.getRequestDispatcher("ajaxRecargarSube.jsp").forward(request, response);
		}catch(Exception e) {
			response.sendError(500,"El numero de tarjeta es inválido");
		}
	}

}
