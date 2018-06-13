package dao;

import java.util.List;

import org.hibernate.HibernateException;

import datos.Devolucion;

public class DevolucionDao extends DAO{
	
	private static DevolucionDao instancia = null; // Patrón Singleton

	protected DevolucionDao() {}

	public static DevolucionDao getInstance() {
		if (instancia == null)
			instancia = new DevolucionDao();
		return instancia;
	}

	public Devolucion traerDevolucion(int idDevolucion) throws HibernateException {
		Devolucion objeto = null;
		try {
		iniciaOperacion();
		objeto = (Devolucion)session.createQuery("from Recarga r where r.idRecarga="+idDevolucion).uniqueResult();
		} 
		finally {
		session.close();
		}
		return objeto;
	}
		
	@SuppressWarnings ("unchecked")
	public List<Devolucion> traerDevolucion() throws HibernateException {
		List<Devolucion> lista= null;
		try {
		iniciaOperacion();
		lista=session.createQuery("from Devolucion d order by d.idDevolucion asc").list();
		} 
		finally {
		session.close();
		}
		return lista;
	}
	
}
