package dao;

import org.hibernate.HibernateException;

import datos.TarjetaSube;

public class TarjetaSubeDao extends DAO{

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
	
	
}
