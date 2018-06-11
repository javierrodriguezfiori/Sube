package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import datos.Usuario;
import negocio.TarjetaSubeABM;

public class UsuarioDAO extends DAO {
	
	// Singleton
    private static UsuarioDAO instancia = null;
	
	protected UsuarioDAO() {};
	
	public static UsuarioDAO getInstance() {
		if(instancia==null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}
	
	public Usuario traerUsuario(long idUsuario) throws HibernateException {
		Usuario usuario = null;
		
		try {
			iniciaOperacion();
			usuario = (Usuario) session.get(Usuario.class, idUsuario);
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		
		return usuario;
	}
	
	public Usuario traerUsuario(String documento) throws HibernateException {
		Usuario usuario = null;
		
		try {
			iniciaOperacion();
			usuario = (Usuario) session.createQuery("from Usuario u where u.documento like '"+documento+"'").uniqueResult();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		
		return usuario;
	}
	
	public Usuario traerUsuarioConDatos(long idUsuario) throws HibernateException {
		Usuario usuario = null;
		
		try {
			iniciaOperacion();
			usuario = (Usuario) session.createQuery("from Usuario u where u.idUsuario =" + idUsuario)
										.uniqueResult();
			Hibernate.initialize(usuario.getDatosUsuario());
			//Hibernate.initialize(usuario.getDatosUsuario().getContacto());
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> traerUsuario() throws HibernateException {
		List<Usuario> usuarios = null;
		
		try {
			iniciaOperacion();
			usuarios = session.createQuery("from Usuario u order by u.tipoDocumento, u.documento desc").list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		
		return usuarios;
	}
}
