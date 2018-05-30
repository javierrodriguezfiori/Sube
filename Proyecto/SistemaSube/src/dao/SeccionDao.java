package dao;
import datos.Seccion;
public class SeccionDao extends DAO {
	
	
	public Seccion traer(long idSeccion) {
		Seccion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Seccion) session.createQuery("from Seccion s where s.idSeccion="+idSeccion).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}

}
