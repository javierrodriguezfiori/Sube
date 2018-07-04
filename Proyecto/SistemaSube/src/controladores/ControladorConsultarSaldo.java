package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Sesion;
import datos.TarjetaSube;
import negocio.TarjetaSubeABM;
import utils.SaldoInsuficienteException;
import utils.TarjetaSubeInexistenteException;

public class ControladorConsultarSaldo extends HttpServlet {
	
	private TarjetaSubeABM tarjetaSubeABM = TarjetaSubeABM.getInstance();
	
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
			String nroTarjeta = (String) request.getParameter("nroTarjeta");
			
			TarjetaSube tarjetaSube = validarTarjetaSube(nroTarjeta);

			request.setAttribute("tarjeta", tarjetaSube);
			request.getRequestDispatcher("ajaxsaldo.jsp").forward(request, response);
		} catch (TarjetaSubeInexistenteException ex) {
			response.sendError(404);
		} catch (Exception ex) {
			response.setStatus(500);
			request.setAttribute("error", "Ocurrió un error interno en el sistema, por favor vuelva a intentarlo.");
			request.getRequestDispatcher("/peticionerronea.jsp").forward(request, response);
		}
	}
	
	private TarjetaSube validarTarjetaSube(String nroTarjeta) throws TarjetaSubeInexistenteException {
		TarjetaSube tarjetaSube = tarjetaSubeABM.validarTarjetaSube(nroTarjeta);
		
		if (tarjetaSube == null)
		{
			if (Sesion.obtenerSesionActual().getUsuarioLogeado() != null)
				throw new TarjetaSubeInexistenteException("Debe registrar una tarjeta sube antes de realizar un viaje.");
			else
				throw new TarjetaSubeInexistenteException("Debe ingresar una tarjeta sube para realizar un viaje.");
		}
		
		return tarjetaSube;
	}

}
