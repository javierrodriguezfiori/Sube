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

public class ControladorCobrarViaje extends HttpServlet {
	
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
			TransportePublico transportePublico = transportePublicoABM.traer(Long.parseLong((String)request.getParameter("transportePublicoId")));
			TarjetaSube tarjetaSube = tarjetaSubeABM.traerTarjetaSube(Long.parseLong((String)request.getParameter("tarjetaSubeNro")));
			String estacion = (String) request.getParameter("tramoOParada");

			Viaje viaje = null;
			
			if (transportePublico instanceof Tren) {
				Parada paradaTren = (Parada) transportePublicoABM
						.traerTrenYParadas(transportePublico.getIdTransporte())
						.getParadas()
						.stream()
						.filter(p -> p.getNombre().equals(estacion))
						.findFirst()
						.get();
				
				viaje = new ViajeTren(0.0f, new GregorianCalendar(), tarjetaSube, transportePublico, paradaTren, null);
			} else if (transportePublico instanceof Colectivo) {
				Tramo tramoColectivo = (Tramo) transportePublicoABM
						.traerColectivoYTramos(transportePublico.getIdTransporte())
						.getTramos()
						.stream()
						.filter(t -> t.getCosto() == Float.parseFloat(estacion))
						.findFirst()
						.get();
				
				viaje = new ViajeColectivo(0.0f, new GregorianCalendar(), tarjetaSube, transportePublico, tramoColectivo);
			} else if (transportePublico instanceof Subte) {
				Parada paradaSubte = (Parada) transportePublicoABM.traerSubteYParadas(transportePublico.getIdTransporte())
						.getParadas()
						.stream()
						.filter(p -> p.getNombre().equals(estacion))
						.findFirst()
						.get();
				viaje = new ViajeSubte(0.0f, new GregorianCalendar(), tarjetaSube, transportePublico, paradaSubte);
			}
				
			terminalViaje.cobrarViaje(viaje);
			request.setAttribute("transporte", viaje.getTransporte().getLinea());
			request.setAttribute("monto", String.valueOf(viaje.getMonto()));
			request.setAttribute("fechaYHora", Funciones.traerFechaCortaHora(viaje.getFechaHora()));
			request.setAttribute("saldo", String.valueOf(viaje.getTarjetaSube().getSaldo()));
			response.setStatus(200);
			request.getRequestDispatcher("mostrarviajecobrado.jsp").forward(request, response);
		} catch (SaldoInsuficienteException ex) {
			response.setStatus(400);
			request.setAttribute("error", "Saldo insuficiente.");
			request.getRequestDispatcher("/peticionerronea.jsp").forward(request, response);
		} catch (Exception ex) {
			response.setStatus(500);
			request.setAttribute("error", "Ocurri� un error interno en el sistema, por favor vuelva a intentarlo.");
			request.getRequestDispatcher("/peticionerronea.jsp").forward(request, response);
		}
	}
}
