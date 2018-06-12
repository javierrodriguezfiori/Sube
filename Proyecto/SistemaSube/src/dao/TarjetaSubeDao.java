package dao;

import org.hibernate.HibernateException;

import datos.TarjetaSube;

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
	
}
