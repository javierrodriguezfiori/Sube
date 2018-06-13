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
			long idTransporte = Long.parseLong((String) request.getParameter("transporte"));
			TransportePublico transportePublico = TransportePublicoABM.getInstance().traer(idTransporte);
			List<String> estacionesOTramos = obtenerEstacionesOTramos(transportePublico);
			
			request.setAttribute("estacionesOTramos", estacionesOTramos);
			request.getRequestDispatcher("tramosOEstaciones.jsp").forward(request, response);
		} catch (Exception ex) {
			
		}
	}
	
	private List<String> obtenerEstacionesOTramos(TransportePublico transportePublico) {
		List<String> estacionesOTramos = new ArrayList();
		
		if (transportePublico instanceof Tren) {
			for (Parada parada : TransportePublicoABM.getInstance().traerTrenYParadas(transportePublico.getIdTransporte()).getParadas())
				estacionesOTramos.add(parada.getNombre());
		} else if (transportePublico instanceof Subte) {
			for (Parada parada : TransportePublicoABM.getInstance().traerSubteYParadas(transportePublico.getIdTransporte()).getParadas())
				estacionesOTramos.add(parada.getNombre());

		} else if (transportePublico instanceof Colectivo) {
			for (Tramo tramo : TransportePublicoABM.getInstance().traerColectivoYTramos(transportePublico.getIdTransporte()).getTramos())
				estacionesOTramos.add(String.valueOf(tramo.getCosto()));
		}
		
		return estacionesOTramos;
	}
}
