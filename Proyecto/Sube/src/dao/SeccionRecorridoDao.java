package dao;
import datos.Parada;
import java.util.List;
import org.hibernate.HibernateException;

import datos.SeccionRecorrido;
public class SeccionRecorridoDao extends DAO {
	
	
	
	public SeccionRecorrido traer(long idSeccionRecorrido)throws HibernateException {
		SeccionRecorrido objeto = null;
		try {
			iniciaOperacion();
			objeto =(SeccionRecorrido) session.createQuery("from SeccionRecorrido sr where sr.idSeccionRecorrido=" + idSeccionRecorrido).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}
	
	public SeccionRecorrido traer(Parada origen,Parada destino)throws HibernateException {
		SeccionRecorrido objeto=null;
		try {
			iniciaOperacion();
			objeto = (SeccionRecorrido) session.createQuery("from SeccionRecorrido sr where sr.origen.idParada="+ origen.getIdParada() +" and sr.destino.idParada="+destino.getIdParada()).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<SeccionRecorrido> traer()throws HibernateException{
		List<SeccionRecorrido> lista=null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from SeccionRecorrido sr order by sr.idSeccionRecorrido asc").list();
		}finally {
			session.close();
		}
		return lista;
	}

}
