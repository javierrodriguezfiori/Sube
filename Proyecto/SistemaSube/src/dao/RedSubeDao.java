package dao;

import datos.RedSube;

public class RedSubeDao extends DAO{
	
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
