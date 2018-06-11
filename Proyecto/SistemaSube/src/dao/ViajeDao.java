package dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import datos.Viaje;

public class ViajeDao extends DAO{
	
	public Viaje traerUltimoViaje(long nroTarjeta)throws HibernateException {
		Viaje objeto = null;
		try {
			iniciaOperacion();
			Query query = session.createQuery("from Viaje v where v.tarjetaSube.nroTarjeta="+nroTarjeta + " order by v.idTransaccion DESC");
		    query.setMaxResults(1);
		    objeto = (Viaje) query.uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}

}
