package dao;
import datos.Parada;
public class ParadaDao extends DAO {
	
	private static ParadaDao instancia = null;
	
	protected ParadaDao() {};
	
	public static ParadaDao getInstance() {
		if(instancia==null) {
			instancia = new ParadaDao();
		}
		return instancia;
	}
	
	public Parada traer(long idParada) {
		Parada objeto=null;
		try {
			iniciaOperacion();
			objeto = (Parada) session.createQuery("from Parada p where p.idParada="+idParada).uniqueResult();
			
		}finally {
			session.close();
		}
		return objeto;
	}

}
