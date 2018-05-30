package dao;

import java.util.List;

import org.hibernate.HibernateException;

import datos.Recarga;

public class RecargaDao extends DAO{
	
	private static RecargaDao instancia = null; // Patrón Singleton

	protected RecargaDao() {}

	public static RecargaDao getInstance() {
		if (instancia == null)
			instancia = new RecargaDao();
		return instancia;
	}

	public Recarga traerRecarga(int idRecarga) throws HibernateException {
		Recarga objeto = null;
		try {
		iniciaOperacion();
		objeto = (Recarga)session.createQuery("from Recarga r where r.idRecarga="+idRecarga).uniqueResult();
		} 
		finally {
		session.close();
		}
		return objeto;
	}
		
	@SuppressWarnings ("unchecked")
	public List<Recarga> traerRecarga() throws HibernateException {
		List<Recarga> lista= null;
		try {
		iniciaOperacion();
		lista=session.createQuery("from Recarga r order by r.idRecarga asc").list();
		} 
		finally {
		session.close();
		}
		return lista;
	}
	
}
