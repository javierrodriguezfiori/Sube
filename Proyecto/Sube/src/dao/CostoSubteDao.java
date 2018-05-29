package dao;
import datos.CostoSubte;
public class CostoSubteDao extends DAO {
	
	public CostoSubte traer() {
		CostoSubte objeto = null;
		try {
			iniciaOperacion();
			objeto = (CostoSubte) session.createQuery("from CostoSubte c where c.idCostoSubte=1").uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}

}
