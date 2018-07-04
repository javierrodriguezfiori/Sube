package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Contacto;
import datos.DatosUsuario;
import datos.Sesion;
import datos.TarjetaSube;
import negocio.TarjetaSubeABM;
import negocio.UsuarioABM;
import utils.RegistroInvalidoException;
import utils.UsuarioInvalidoException;

public class ControladorRegistro extends HttpServlet {
	
	private UsuarioABM usuarioABM = UsuarioABM.getInstance();
	private TarjetaSubeABM tarjetaSubeABM = TarjetaSubeABM.getInstance();
	
	private Map<String, String> generos = new HashMap<String, String>() {
		{
			put("masculino", "m");
			put("femenino", "f");
			put("indefinido", "x");
		}
	};
	
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
			String tipoDocumento = (String) request.getParameter("tipoDocumento");
			String documento = (String) request.getParameter("documento");
			
			if(existeUsuario(documento))
				throw new RegistroInvalidoException("Ya se ha registrado un usuario con este documento.");
			
			String nroTarjeta = (String) request.getParameter("tarjetasube");		
			TarjetaSube tarjetaSube = tarjetaSubeABM.traerTarjetaSube(Long.parseLong(nroTarjeta));
			verificarTarjetaSube(tarjetaSube);
			
			String mail = (String) request.getParameter("mail");
			String movil = (String) request.getParameter("movil");
			String telefonoFijo = (String) request.getParameter("telefonoFijo");
			Contacto contacto = new Contacto(mail, movil, telefonoFijo);
			
			String nombre = (String) request.getParameter("nombre");
			String apellido = (String) request.getParameter("apellido");
			String genero = (String) request.getParameter("genero");
			DatosUsuario datosUsuario = new DatosUsuario(nombre, apellido, generos.get(genero).charAt(0), contacto);
			
			String clave = (String) request.getParameter("clave");
			usuarioABM.agregar(tipoDocumento, documento, clave, new GregorianCalendar(), datosUsuario);
			tarjetaSubeABM.asociarAUsuario(Long.parseLong(nroTarjeta), documento);
			Sesion.obtenerSesionActual().setUsuarioLogeado(usuarioABM.traerUsuario(documento));
			response.setStatus(200);
		} catch (RegistroInvalidoException ex) {
			response.setStatus(400);
			request.setAttribute("error", ex.getMessage());
			request.getRequestDispatcher("/peticionerronea.jsp").forward(request, response);
		} catch (Exception ex) {
			response.setStatus(500);
			request.setAttribute("error", "Ocurrió un error interno en el sistema, por favor vuelva a intentarlo.");
			request.getRequestDispatcher("/peticionerronea.jsp").forward(request, response);
		}
	}
	
	private boolean existeUsuario(String documento) {
		return usuarioABM.traerUsuario(documento) != null;
	}
	
	private void verificarTarjetaSube(TarjetaSube tarjetaSube) throws RegistroInvalidoException {
		
		if (tarjetaSube == null)
			throw new RegistroInvalidoException("No existe una tarjeta sube registrada con ese numero.");
		
		if (tarjetaSube.getUsuario() != null)
			throw new RegistroInvalidoException("La tarjeta sube ya esta registrada a un usuario.");
	}
}
