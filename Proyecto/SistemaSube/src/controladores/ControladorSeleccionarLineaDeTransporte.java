package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ViajeDao;
import datos.TarjetaSube;
import datos.TransportePublico;
import negocio.TarjetaSubeABM;
import negocio.TransportePublicoABM;
import utils.TarjetaSubeInexistenteException;

public class ControladorSeleccionarLineaDeTransporte extends HttpServlet {
	
	
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
			
			
			String transporteEnTexto = (String) request.getParameter("transportePublico");
			List<TransportePublico> listaTransportes = obtenerTransportes(transporteEnTexto);
			
			request.setAttribute("transportesPublicos", listaTransportes);
			response.setStatus(200);
			request.getRequestDispatcher("lineasreportes.jsp").forward(request, response);
			
			
			
			
			
		}catch(Exception e) {
			response.sendError(500,"Fecha Incorrecta");
		}
		}
	private List<TransportePublico> obtenerTransportes(String transporteEnTexto) {
		return TransportePublicoABM.getInstance().traerTransportesSegunTexto(transporteEnTexto);
	}

}