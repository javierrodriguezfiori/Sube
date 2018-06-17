package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Colectivo;
import datos.Parada;
import datos.Subte;
import datos.Tramo;
import datos.TransportePublico;
import datos.Tren;
import negocio.TransportePublicoABM;
import utils.LineaSinTramosOEstacionesException;

public class ControladorTramosYEstaciones extends HttpServlet {
	
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
			long idTransporte = Long.parseLong((String) request.getParameter("idLineaDeTransporte"));
			TransportePublico transportePublico = TransportePublicoABM.getInstance().traer(idTransporte);
			List<String> tramosOEstaciones = obtenerTramosOEstaciones(transportePublico);
			
			if (tramosOEstaciones.isEmpty())
				throw new LineaSinTramosOEstacionesException("La linea " + transportePublico.getLinea() + " no tiene tramos o estaciones asociados.");
			
			request.setAttribute("tramosOEstaciones", tramosOEstaciones);
			response.setStatus(200);
			request.getRequestDispatcher("tramosOEstaciones.jsp").forward(request, response);
		} catch (LineaSinTramosOEstacionesException ex) {
			response.sendError(404);
		} catch (Exception ex) {
			response.sendError(500);
		}
	}
	
	private List<String> obtenerTramosOEstaciones(TransportePublico transportePublico) {
		List<String> tramosOEstaciones = new ArrayList();
		
		if (transportePublico instanceof Tren) {
			for (Parada parada : TransportePublicoABM.getInstance().traerTrenYParadas(transportePublico.getIdTransporte()).getParadas())
				tramosOEstaciones.add(parada.getNombre());
		} else if (transportePublico instanceof Subte) {
			for (Parada parada : TransportePublicoABM.getInstance().traerSubteYParadas(transportePublico.getIdTransporte()).getParadas())
				tramosOEstaciones.add(parada.getNombre());
		} else if (transportePublico instanceof Colectivo) {
			for (Tramo tramo : TransportePublicoABM.getInstance().traerColectivoYTramos(transportePublico.getIdTransporte()).getTramos())
				tramosOEstaciones.add(String.valueOf(tramo.getCosto()));
		}
		
		return tramosOEstaciones;
	}
}
