package dao;
import datos.Tramo;
public class TramoDao extends DAO {
	
	private static TramoDao instance = null;
	
	protected TramoDao() {}
	
	public static TramoDao getInstance() {
		if(instance==null) {
			instance = new TramoDao();
		}
		return instance;
	}
	
	public Tramo traer(long idTramo) {
		Tramo objeto = null;
		try {
			iniciaOperacion();
			objeto = (Tramo) session.createQuery("from Tramo t where t.idTramo="+idTramo).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}

}
