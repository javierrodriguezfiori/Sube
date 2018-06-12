package dao;

import org.hibernate.HibernateException;

import datos.TarjetaSube;
import datos.Usuario;
import funciones.Funciones;

    public class TarjetaSubeDao extends DAO{

    private static TarjetaSubeDao instancia = null;
	
	protected TarjetaSubeDao() {};
	
	public static TarjetaSubeDao getInstance() {
		if(instancia==null) {
			instancia = new TarjetaSubeDao();
		}
		return instancia;
	}
	
	public TarjetaSube traerTarjetaSube(long nroTarjeta) throws HibernateException {
		TarjetaSube objeto = null ;
		try {
			iniciaOperacion();
			objeto = (TarjetaSube)session.get(TarjetaSube.class , nroTarjeta);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public TarjetaSube traerTarjetaSube(Usuario usuario) throws HibernateException {
		TarjetaSube tarjeta = null;
		try {
			iniciaOperacion();
			String hql = "from TarjetaSube ts where ts.usuario=" + usuario.getIdUsuario();
			tarjeta = (TarjetaSube) session.createQuery(hql).uniqueResult();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		
		return tarjeta;
	}
	
}
