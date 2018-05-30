package dao;

import datos.RedSube;

public class RedSubeDao extends DAO{
	
	public static RedSubeDao instance = null;
	protected RedSubeDao() {}
	
	public static RedSubeDao getInstance() {
		if(instance==null) {
			instance = new RedSubeDao();
		}
		return instance;
	}
	
	public RedSube traerRedSube(long idRedSube) {
		RedSube objeto = null;
		try {
			iniciaOperacion();
			objeto = (RedSube)session.get(RedSube.class , idRedSube);
		} finally {
			session.close();
		}
		return objeto;
	}
}
