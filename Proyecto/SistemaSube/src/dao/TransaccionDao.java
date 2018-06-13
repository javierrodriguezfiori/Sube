package dao;

import java.util.List;

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
	
	@SuppressWarnings("unchecked")
	public List<Transaccion> traer(long nroTarjeta) throws HibernateException {
		List<Transaccion> transacciones = null;
		try {
		iniciaOperacion();
		transacciones = session.createQuery("from Transaccion t where t.tarjetaSube.nroTarjeta="+nroTarjeta + " order by t.fechaHora DESC").list();
		} 
		finally {
		session.close();
		}
		return transacciones;
	}

}
