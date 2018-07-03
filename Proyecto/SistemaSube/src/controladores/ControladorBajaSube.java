package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.TarjetaSube;
import negocio.TarjetaSubeABM;

public class ControladorBajaSube extends HttpServlet {
	
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
			TarjetaSube tarjeta = TarjetaSubeABM.getInstance().traerTarjetaSube(nroTarjeta);
			TarjetaSubeABM.getInstance().desasociarDeUsuario(nroTarjeta);
			tarjeta=TarjetaSubeABM.getInstance().traerTarjetaSube(nroTarjeta);
			request.setAttribute("tarjeta", tarjeta);
			request.getRequestDispatcher("ajaxBajaSube.jsp").forward(request, response);
		} catch(Exception e) {
			response.sendError(500);
		}
	}

}
