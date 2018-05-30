package dao;

import org.hibernate.HibernateException;

import datos.Transaccion;

public class TransaccionDao extends DAO{
	
	private static TransaccionDao instancia = null; // Patrón Singleton

	protected TransaccionDao() {}

	public static TransaccionDao getInstance() {
		if (instancia == null)
			instancia = new TransaccionDao();
		return instancia;
	}
	
	public Transaccion traer(int idTransaccion) throws HibernateException {
		Transaccion objeto = null;
		try {
		iniciaOperacion();
		objeto = (Transaccion)session.createQuery("from Transaccion t where t.idTransaccion="+idTransaccion).uniqueResult();
		} 
		finally {
		session.close();
		}
		return objeto;
	}

}
