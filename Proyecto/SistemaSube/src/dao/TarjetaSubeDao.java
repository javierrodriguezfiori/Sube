package dao;

import org.hibernate.HibernateException;

import datos.TarjetaSube;

public class TarjetaSubeDao extends DAO{

	public TarjetaSube traerTarjetaSube(long nroTarjeta) throws HibernateException {
		TarjetaSube objeto = null ;
		try {
			iniciaOperacion();
			objeto = (TarjetaSube)session.get(TarjetaSube.class , nroTarjeta);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
	
}
