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
	
	TarjetaSubeABM tarjetaSubeABM = TarjetaSubeABM.getInstance();
	TerminalViaje terminalViaje = TerminalViaje.getInstance();
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
			String nroTarjeta = (String) request.getParameter("tarjetasube");
			
			TarjetaSube tarjetaSube = validarTarjetaSube(nroTarjeta);
			
			String linea = (String) request.getParameter("lineas");
			String tramoOEstacion = (String) request.getParameter("tramoOEstacion");
			String fechaEnTexto = (String) request.getParameter("fecha");
			
			TransportePublico transportePublico = TransportePublicoABM.getInstance().traer(Long.parseLong(linea));
			GregorianCalendar fechaDeViaje = parsearFechaEnTexto(fechaEnTexto);
			
			Viaje viaje = crearViaje(transportePublico, tramoOEstacion, fechaDeViaje, tarjetaSube);
			terminalViaje.cobrarViaje(viaje);
			request.setAttribute("linea", viaje.getTransporte().getLinea());
			request.setAttribute("monto", String.valueOf(viaje.getMonto()));
			request.setAttribute("fechaYHora", Funciones.traerFechaCortaHora(viaje.getFechaHora()));
			request.setAttribute("saldo", String.valueOf(viaje.getTarjetaSube().getSaldo()));
			response.setStatus(200);
			request.getRequestDispatcher("mostrarviajecobrado.jsp").forward(request, response);
		} catch (TarjetaSubeInexistenteException ex) {
			response.sendError(404);
		} catch (SaldoInsuficienteException ex) {
			response.sendError(400);
		} catch (Exception ex) {
			response.setStatus(500);
			request.setAttribute("error", "Ocurrió un error interno en el sistema, por favor vuelva a intentarlo.");
			request.getRequestDispatcher("/peticionerronea.jsp").forward(request, response);
		}
	}
	
	private GregorianCalendar parsearFechaEnTexto(String fechaEnTexto) {
		GregorianCalendar fechaFormateada = null;
		
		if (fechaEnTexto.isEmpty())
			fechaFormateada = new GregorianCalendar();
		else {
			int dia = Integer.parseInt(fechaEnTexto.substring(0, 2));
			int mes = Integer.parseInt(fechaEnTexto.substring(3, 5));
			int anio = Integer.parseInt(fechaEnTexto.substring(6, 10));
			int hora = Integer.parseInt(fechaEnTexto.substring(11, 13));
			int minutos = Integer.parseInt(fechaEnTexto.substring(14, 16));
			fechaFormateada = new GregorianCalendar(anio, mes - 1, dia, hora, minutos);
		}
		
		return fechaFormateada;	
	}
	
	private Viaje crearViaje(TransportePublico transportePublico, String tramoOEstacion, GregorianCalendar fechaDeViaje, TarjetaSube tarjetaSube) throws Exception {
		Viaje viaje = null;
		
		if (transportePublico instanceof Tren) {
			Parada paradaTren = (Parada) transportePublicoABM
					.traerTrenYParadas(transportePublico.getIdTransporte())
					.getParadas()
					.stream()
					.filter(p -> p.getNombre().equals(tramoOEstacion))
					.findFirst()
					.get();
			viaje = new ViajeTren(0.0f, fechaDeViaje, tarjetaSube, transportePublico, paradaTren, null);
			
		} else if (transportePublico instanceof Colectivo) {
			Tramo tramoColectivo = (Tramo) transportePublicoABM
					.traerColectivoYTramos(transportePublico.getIdTransporte())
					.getTramos()
					.stream()
					.filter(t -> t.getCosto() == Float.parseFloat(tramoOEstacion))
					.findFirst()
					.get();
			viaje = new ViajeColectivo(0.0f, fechaDeViaje, tarjetaSube, transportePublico, tramoColectivo);
			
		} else if (transportePublico instanceof Subte) {
			Parada paradaSubte = (Parada) transportePublicoABM.traerSubteYParadas(transportePublico.getIdTransporte())
					.getParadas()
					.stream()
					.filter(p -> p.getNombre().equals(tramoOEstacion))
					.findFirst()
					.get();
			viaje = new ViajeSubte(0.0f, fechaDeViaje, tarjetaSube, transportePublico, paradaSubte);
		}
		
		return viaje;
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
