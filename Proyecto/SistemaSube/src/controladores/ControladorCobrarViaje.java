package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Colectivo;
import datos.Parada;
import datos.Sesion;
import datos.Subte;
import datos.TarjetaSube;
import datos.Tramo;
import datos.TransportePublico;
import datos.Tren;
import datos.Viaje;
import datos.ViajeColectivo;
import datos.ViajeSubte;
import datos.ViajeTren;
import funciones.Funciones;
import negocio.TarjetaSubeABM;
import negocio.TerminalViaje;
import negocio.TransportePublicoABM;
import utils.SaldoInsuficienteException;
import utils.TarjetaSubeInexistenteException;
import utils.UsuarioInvalidoException;

public class ControladorCobrarViaje extends HttpServlet implements LoginValidable {
	
	TerminalViaje terminalViaje = new TerminalViaje();
	TarjetaSubeABM tarjetaSubeABM = TarjetaSubeABM.getInstance();
	TransportePublicoABM transportePublicoABM = TransportePublicoABM.getInstance();
	
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
			String transportePublico = (String)request.getParameter("transportePublico");
			String linea = (String) request.getParameter("linea");
			String estacion = (String) request.getParameter("tramoOEstacion");
			
			if (!existeUsuarioLogeado())
				throw new UsuarioInvalidoException("No existe un usuario logeado.");
			
			if(!usuarioTieneTarjetaSube())
				throw new TarjetaSubeInexistenteException("No existe una tarjeta sube registrada en este usuario.");
		} catch (SaldoInsuficienteException ex) {
			response.setStatus(400);
			request.setAttribute("error", "Saldo insuficiente.");
			request.getRequestDispatcher("/peticionerronea.jsp").forward(request, response);
		} catch (Exception ex) {
			response.setStatus(500);
			request.setAttribute("error", "Ocurrió un error interno en el sistema, por favor vuelva a intentarlo.");
			request.getRequestDispatcher("/peticionerronea.jsp").forward(request, response);
		}
	}
}
