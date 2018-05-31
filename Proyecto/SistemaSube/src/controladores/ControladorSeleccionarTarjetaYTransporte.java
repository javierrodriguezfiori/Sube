package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.TarjetaSube;
import datos.TransportePublico;
import negocio.TarjetaSubeABM;
import negocio.TransportePublicoABM;
import utils.TarjetaSubeInexistenteException;

public class ControladorSeleccionarTarjetaYTransporte extends HttpServlet {
	
	private TarjetaSubeABM tarjetaSubeABM = TarjetaSubeABM.getInstance();
	private TransportePublicoABM transportePublicoABM = TransportePublicoABM.getInstance();
	
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
			int nroTarjeta = Integer.parseInt(request.getParameter("nrotarjeta"));
			TarjetaSube tarjetaSube = tarjetaSubeABM.traerTarjetaSube((long)nroTarjeta);
			
			if (tarjetaSube == null) 
				throw new TarjetaSubeInexistenteException("No se encontró una tarjeta sube con el numero " + nroTarjeta);
			
			String transportePublico = request.getParameter("transporte");
			List<String> listaParadasOTramos = new ArrayList<String>();
			TransportePublico transporte = null;
			
			switch (transportePublico) {
				case "tren":
					transporte = transportePublicoABM.traerTrenYParadas(1l);
					transportePublicoABM.traerTrenYParadas(1l).getParadas().stream().forEach(p -> listaParadasOTramos.add(p.getNombre()));
					break;
				case "subte":
					transporte = transportePublicoABM.traerSubteYParadas(2l);
					transportePublicoABM.traerSubteYParadas(2l).getParadas().stream().forEach(p -> listaParadasOTramos.add(p.getNombre()));
					break;
				case "colectivo":
					transporte = transportePublicoABM.traerColectivoYTramos(3l);
					transportePublicoABM.traerColectivoYTramos(3l).getTramos().stream().forEach(p -> listaParadasOTramos.add(String.valueOf(p.getCosto())));
					break;
				default:
					break;
			}
			
			response.setStatus(200);
			request.setAttribute("transportePublico", transporte);
			request.setAttribute("tarjetaSube", tarjetaSube);
			request.setAttribute("listaParadasTramos", listaParadasOTramos);
			request.getServletContext().getRequestDispatcher("/seleccionarestacionoparada.jsp").forward(request, response);
		} catch (TarjetaSubeInexistenteException ex) {
			response.setStatus(404);
			request.setAttribute("error", ex.getMessage());
			request.getRequestDispatcher("/peticionerronea.jsp").forward(request, response);
		}
		catch (Exception ex) {
			response.setStatus(500);
			request.setAttribute("error", "Ocurrió un error interno en el sistema, por favor vuelva a intentarlo.");
			request.getRequestDispatcher("/peticionerronea.jsp").forward(request, response);
		}
	}
}