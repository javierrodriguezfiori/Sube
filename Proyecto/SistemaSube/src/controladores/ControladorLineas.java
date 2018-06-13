package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.TransportePublico;
import negocio.TransportePublicoABM;

public class ControladorLineas extends HttpServlet {
	
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
			/*String transporteEnTexto = (String) request.getParameter("transportePublico");
			List<TransportePublico> listaTransportes = obtenerTransportes(transporteEnTexto);*/
			List<String> lineasDeTransporte = Arrays.asList("Linea1", "Linea2");//obtenerLineas(listaTransportes);
			request.setAttribute("lineasDeTransporte", lineasDeTransporte);
			request.getRequestDispatcher("lineas.jsp").forward(request, response);
		} catch (Exception ex) {
			
		}
	}
	
	private List<TransportePublico> obtenerTransportes(String transporteEnTexto) {
		return TransportePublicoABM.getInstance().traerTransportesSegunTexto(transporteEnTexto);
	}
	
	private List<String> obtenerLineas(List<TransportePublico> listaTransportes) {
		List<String> listaLineas = null;
		
		for(TransportePublico transporte : listaTransportes) {
			listaLineas.add(transporte.getLinea());
		}
		
		return listaLineas;
	}
}
