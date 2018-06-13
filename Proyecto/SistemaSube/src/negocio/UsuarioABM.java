package negocio;

import java.util.GregorianCalendar;

import dao.TarjetaSubeDao;
import dao.UsuarioDAO;
import datos.DatosUsuario;
import datos.Usuario;
import utils.UsuarioInvalidoException;

public class UsuarioABM {
	
	// Singleton
    private static UsuarioABM instancia = null;
	
	protected UsuarioABM() {};
	
	public static UsuarioABM getInstance() {
		if(instancia==null) {
			instancia = new UsuarioABM();
		}
		return instancia;
	}
	
	public Usuario traerUsuario(int idUsuario) throws Exception{
		Usuario user= UsuarioDAO.getInstance().traerUsuario(idUsuario);
		// Si el usuario no existe tirar error
		if(user==null)
			throw new UsuarioInvalidoException("El usuario no existe");
		return user;
	}
	
	public Usuario traerUsuario(String documento) throws UsuarioInvalidoException{
		Usuario user= UsuarioDAO.getInstance().traerUsuario(documento);
		// Si el usuario no existe tirar error
		if(user==null)
			throw new UsuarioInvalidoException("El usuario no existe");
		return user;
	}
	
	public long agregar(String tipoDocumento, String documento, String clave, GregorianCalendar fechaAlta, DatosUsuario datosUsuario) throws Exception{
		Usuario user = new Usuario(tipoDocumento, documento, clave, fechaAlta, datosUsuario);
		return TarjetaSubeDao.getInstance().agregar(user);
	}
	
	public void eliminar(long idUsuario) throws Exception{ 
			Usuario user= UsuarioDAO.getInstance().traerUsuario(idUsuario);
			if(user==null)
				throw new Exception("El usuario no existe.");  
			else
				TarjetaSubeDao.getInstance().eliminar(user);
	}
	
	public void modificar(Usuario usuario) throws Exception{
		TarjetaSubeDao.getInstance().actualizar(usuario);
	}
}
