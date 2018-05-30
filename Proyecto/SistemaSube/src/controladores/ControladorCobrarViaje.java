package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Colectivo;
import datos.Subte;
import datos.TarjetaSube;
import datos.TransportePublico;
import datos.Tren;
import datos.Viaje;
import datos.ViajeColectivo;
import datos.ViajeSubte;
import datos.ViajeTren;
import negocio.TerminalViaje;
import negocio.TransportePublicoABM;

public class ControladorCobrarViaje extends HttpServlet {
	
	TerminalViaje terminalViaje = new TerminalViaje();
	
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
			String prueba = (String) request.getParameter("prueba");
			TransportePublico transportePublico = (TransportePublico) request.getAttribute("transportePublico");
			TarjetaSube tarjetaSube = (TarjetaSube) request.getAttribute("tarjetaSube");
			String estacion = (String) request.getAttribute("estacion");
			Viaje viaje = null;
			
			//TODO: traer estaciones/tramos correspondientes segun estacion
			if (transportePublico instanceof Tren)
				viaje = new ViajeTren(0.0f, new GregorianCalendar(), tarjetaSube, transportePublico,
						TransportePublicoABM.getInstance().traerEstacionOTramoSegunNombre(transportePublico, estacion), null);
			else if (transportePublico instanceof Colectivo)
				viaje = new ViajeColectivo(0.0f, new GregorianCalendar(), tarjetaSube,
						transportePublico, TransportePublicoABM.getInstance().traerEstacionOTramoSegunNombre(transportePublico, estacion));
			else if (transportePublico instanceof Subte)
				viaje = new ViajeSubte(0.0f, new GregorianCalendar(), tarjetaSube,
						transportePublico, TransportePublicoABM.getInstance().traerEstacionOTramoSegunNombre(transportePublico, estacion));

			//terminalViaje.cobrarViaje(viaje);
			System.out.println(viaje);
			response.setStatus(200);
		} catch (Exception ex) {
			
		}
	}
}
