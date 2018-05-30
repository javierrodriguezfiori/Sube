package dao;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import java.util.List;

import datos.TransportePublico;
import datos.Subte;
import datos.Colectivo;
import datos.Tren;
public class TransportePublicoDao extends DAO {
	
	private static TransportePublicoDao instancia = null;
	protected TransportePublicoDao() {}
	
	public static TransportePublicoDao getInstance() {
		if(instancia==null) {
			instancia = new TransportePublicoDao();
		}
		return instancia;
	}
	public TransportePublico traerTransportePublico(long idTransporte)throws HibernateException {
		TransportePublico objeto;
		try {
			iniciaOperacion();
			objeto = (TransportePublico) session.createQuery("from TransportePublico t where t.idTransporte="+idTransporte).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<TransportePublico> traer()throws HibernateException{
		List<TransportePublico> lista;
		try {
			iniciaOperacion();
			lista = session.createQuery("from TransportePublico").list();
		}finally {
			session.close();
		}
		return lista;
	}
	
	public TransportePublico traerTransportePublico(String linea)throws HibernateException{
		TransportePublico objeto = null;;
		try {
			iniciaOperacion();
			objeto = (TransportePublico) session.createQuery("from TransportePublico t where t.linea like '" + linea + "'").uniqueResult();
		}finally {
			session.close();
			}
		return objeto;
	}
	
	public Subte traerSubteYParadas(long idSubte) {
		Subte objeto = null;
		try {
			iniciaOperacion();
			objeto = (Subte) session.createQuery("from Subte s where s.idTransporte="+idSubte).uniqueResult();
			Hibernate.initialize(objeto.getParadas());
		}finally {
			session.close();
		}
		return objeto;
	}
	
	public Colectivo traerColectivoYTramos(long idColectivo) {
		Colectivo objeto=null;
		try {
			iniciaOperacion();
			objeto = (Colectivo) session.createQuery("from Colectivo c where c.idTransporte="+idColectivo).uniqueResult();
			Hibernate.initialize(objeto.getTramos());
		}finally {
			session.close();
		}
		return objeto;
	}
	
	public Tren traerTrenYParadas(long idTren) {
		Tren objeto = null;
		try {
			iniciaOperacion();
			objeto = (Tren) session.createQuery("from Tren t where t.idTransporte="+idTren).uniqueResult();
			Hibernate.initialize(objeto.getParadas());
		}finally {
			session.close();
		}
		return objeto;
	}

}
