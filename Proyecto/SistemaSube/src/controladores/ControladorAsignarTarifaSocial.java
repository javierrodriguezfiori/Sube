package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.TarjetaSube;
import negocio.TarjetaSubeABM;
import dao.TarjetaSubeDao;

public class ControladorAsignarTarifaSocial extends HttpServlet {
	
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
			String tarifa = request.getParameter("tarifa");
			
			TarjetaSube tarjeta = TarjetaSubeABM.getInstance().traerTarjetaSube(nroTarjeta);
						
			switch(tarifa) {
				case "sindescuento":
					tarjeta.setEstado(0);
					break;
				case "tarifasocial":
					tarjeta.setEstado(1);
					break;
				case "boletoestudiantil":
					tarjeta.setEstado(2);
					break;
				default:
					tarjeta.setEstado(0);
					break;
			}	
		
			TarjetaSubeDao.getInstance().actualizar(tarjeta);
			tarjeta = TarjetaSubeABM.getInstance().traerTarjetaSube(nroTarjeta);
			request.setAttribute("tarjeta", tarjeta);
			request.getRequestDispatcher("ajaxAsignarTarifaSocial.jsp").forward(request, response);
		}catch(Exception e) {
			response.sendError(500,"El numero de tarjeta es inválido");
		}
	}

}
