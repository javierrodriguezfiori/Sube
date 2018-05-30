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
import datos.TarjetaSube;
import datos.TransportePublico;
import datos.Tren;
import negocio.TarjetaSubeABM;
import negocio.TransportePublicoABM;



public class ControladorSeleccionarTarjetaYTransporte extends HttpServlet {
	
	private TarjetaSubeABM tarjetaSubeABM = new TarjetaSubeABM();
	private TransportePublicoABM transportePublicoABM = TransportePublicoABM.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Entro");
		System.out.println(request.getParameter("transporte"));
		response.setContentType("text/html;charset=UTF-8");
		try {
			System.out.println("Siguio");
			int nroTarjeta = Integer.parseInt(request.getParameter("nrotarjeta"));
			System.out.println("Entro");
			System.out.println(String.valueOf(nroTarjeta));
			TarjetaSube tarjetaSube = tarjetaSubeABM.traerTarjetaSube((long)nroTarjeta);
			String transportePublico = request.getParameter("transporte");
			List<String> listaParadasOTramos = new ArrayList<String>();
			
			switch (transportePublico) {
				case "tren":
					transportePublicoABM.traerTrenYParadas(1l).getParadas().stream().forEach(p -> listaParadasOTramos.add(p.getNombre()));
					break;
				case "subte":
					transportePublicoABM.traerSubteYParadas(1l).getParadas().stream().forEach(p -> listaParadasOTramos.add(p.getNombre()));
					break;
				case "colectivo":
					transportePublicoABM.traerColectivoYTramos(1l).getTramos().stream().forEach(p -> listaParadasOTramos.add(String.valueOf(p.getCosto())));
					break;
				default:
					break;
			}
			
			request.setAttribute("tarjetaSube", tarjetaSube);
			request.setAttribute("listaParadasTramos", listaParadasOTramos);
			request.getRequestDispatcher("/seleccionarestacionoparada.jsp").forward(request, response);
		} catch (Exception ex) {
			response.sendError(500,"FALLO");
		}
	}
}
