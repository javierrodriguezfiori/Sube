package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Sesion;
import datos.Usuario;
import datos.TarjetaSube;
import negocio.TarjetaSubeABM;
import utils.UsuarioInvalido;

public class ControladorSeleccionarTarifa extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			if(Sesion.obtenerSesionActual().getUsuarioLogeado()==null){
				throw new Exception("ERROR: El usuario no esta logeado.");
			}
			TarjetaSube sube=TarjetaSubeABM.getInstance().traerTarjetaSube(Sesion.obtenerSesionActual().getUsuarioLogeado());
			String tarifa = request.getParameter("tarifa");
			switch (tarifa) {
			case "tarifasocial":
				sube.setEstado(1);
				TarjetaSubeABM.getInstance().modificar(sube);
				break;
			case "boletoestudiantil":
				sube.setEstado(2);
				TarjetaSubeABM.getInstance().modificar(sube);
				break;
			case "sindescuento":
				sube.setEstado(0);
				TarjetaSubeABM.getInstance().modificar(sube);
				break;
			default:
				break;
		}
			response.setStatus(200);
		} catch (UsuarioInvalido ex) {
			response.sendError(404);
		} catch (Exception ex) {
			response.sendError(500);
		}
		
	}
	
	

}
