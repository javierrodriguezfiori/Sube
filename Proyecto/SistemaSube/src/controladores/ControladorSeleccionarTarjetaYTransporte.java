package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Colectivo;
import datos.Subte;
import datos.TarjetaSube;
import datos.TransportePublico;
import datos.Tren;
import negocio.TarjetaSubeABM;
import negocio.TransportePublicoABM;

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
			String transportePublico = request.getParameter("transporte");
			List<String> listaParadasOTramos = new ArrayList<String>();
			TransportePublico transporte = null;
			
			switch (transportePublico) {
				case "tren":
					transporte = transportePublicoABM.traerTrenYParadas(1l);
					transportePublicoABM.traerTrenYParadas(1l).getParadas().stream().forEach(p -> listaParadasOTramos.add(p.getNombre()));
					break;
				case "subte":
					transporte = transportePublicoABM.traerSubteYParadas(1l);
					transportePublicoABM.traerSubteYParadas(1l).getParadas().stream().forEach(p -> listaParadasOTramos.add(p.getNombre()));
					break;
				case "colectivo":
					transporte = transportePublicoABM.traerColectivoYTramos(1l);
					transportePublicoABM.traerColectivoYTramos(1l).getTramos().stream().forEach(p -> listaParadasOTramos.add(String.valueOf(p.getCosto())));
					break;
				default:
					break;
			}
			
			response.setStatus(200);
			request.setAttribute("transportePublico", transporte);
			request.setAttribute("tarjetaSube", tarjetaSube);
			request.setAttribute("listaParadasTramos", listaParadasOTramos);
			request.getRequestDispatcher("/seleccionarestacionoparada.jsp").forward(request, response);
		} catch (Exception ex) {
			response.sendError(500,"FALLO");
		}
	}
}