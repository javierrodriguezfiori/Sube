package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.TarjetaSube;
import negocio.TarjetaSubeABM;
import utils.TarjetaInvalidaException;
import utils.TarjetaSinUsuarioException;

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
			String confirmacion = null;
			long nroTarjeta = Integer.parseInt(request.getParameter("nroTarjeta"));	
			TarjetaSube tarjeta = TarjetaSubeABM.getInstance().traerTarjetaSube(nroTarjeta);
			if(tarjeta==null) 
				throw new TarjetaInvalidaException("ERROR: La tarjeta indicada no existe");
			else {
				if(tarjeta.getUsuario()!=null) {
					TarjetaSubeABM.getInstance().desasociar(nroTarjeta);
					request.setAttribute("tarjeta", tarjeta);
					tarjeta=TarjetaSubeABM.getInstance().traerTarjetaSube(nroTarjeta);
					request.getRequestDispatcher("ajaxBajaSube.jsp").forward(request, response);
				} else
					throw new TarjetaSinUsuarioException("ERROR: La tarjeta indicada no tiene un usuario asociado");
			}	
		} catch(TarjetaInvalidaException ti) {
			response.sendError(404);
		} catch(TarjetaSinUsuarioException tsu) {
			response.sendError(404);
		} catch(Exception e) {
			response.sendError(500);
		}
	}

}
