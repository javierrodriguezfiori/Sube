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
			
			
			List<TransportePublico> trenes = TransportePublicoABM.getInstance().traerTrenes();
			List<TransportePublico> colectivos = TransportePublicoABM.getInstance().traerColectivos();
			List<TransportePublico> subtes = TransportePublicoABM.getInstance().traerSubtes();
			
			request.setAttribute("trenes", trenes);
			request.setAttribute("colectivos", colectivos);
			request.setAttribute("subtes", subtes);
			
			request.getRequestDispatcher("reportes.jsp").forward(request, response);
			
			
			
			
			
		}catch(Exception e) {
			response.sendError(500,"Fecha Incorrecta");
		}
		}

}