package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Sesion;
import datos.Usuario;
import negocio.UsuarioABM;
import utils.UsuarioInvalidoException;

public class ControladorLogin extends HttpServlet implements LoginValidable{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			Usuario usuario = traerUsuario(request.getParameter("documento"));
			String password = request.getParameter("password");
			
			if (usuario == null)
				throw new UsuarioInvalidoException("Usuario o clave incorrecta.");
			
			if (!usuario.esClaveCorrecta(password))
				throw new UsuarioInvalidoException("Usuario o clave incorrecta.");
			
			setearUsuarioLogeado(usuario);
			response.setStatus(200);
			request.setAttribute("usuario", usuario);
		} catch (UsuarioInvalidoException ex) {
			response.sendError(404);
		} catch (Exception ex) {
			response.sendError(500);
		}
		
	}
	
	private Usuario traerUsuario(String documento) throws UsuarioInvalidoException {
		return UsuarioABM.getInstance().traerUsuario(documento);
	}
	
	private void setearUsuarioLogeado(Usuario usuario) {
		Sesion.obtenerSesionActual().setUsuarioLogeado(usuario);
	}
}
