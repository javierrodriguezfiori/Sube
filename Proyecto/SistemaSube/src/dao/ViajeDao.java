package dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import java.util.GregorianCalendar;

import datos.TransportePublico;
import datos.Viaje;
import funciones.Funciones;

import java.util.List;

public class ViajeDao extends DAO{
	public static ViajeDao instance = null;
	
	protected ViajeDao() {}
	
	public static ViajeDao getInstance() {
		if(instance==null) {
			instance = new ViajeDao();
		}
		return instance;
	}
	
	public Viaje traerUltimoViaje(long nroTarjeta)throws HibernateException {
		Viaje objeto = null;
		
		try {
			iniciaOperacion();
			Query query = session.createQuery("from Viaje v where v.tarjetaSube.nroTarjeta="+nroTarjeta + " order by v.idTransaccion DESC");
		    query.setMaxResults(1);
		    objeto = (Viaje) query.uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viaje> traer(GregorianCalendar ini,GregorianCalendar fin){
		List<Viaje> viajes;
		try {
			iniciaOperacion();
			String sql= "from Viaje v where v.fechaHora>='" + Funciones.traerFechaCortaHora(ini) + "' and v.fechaHora<='" + Funciones.traerFechaCortaHora(fin)+"' order by v.fechaHora asc";
			viajes = session.createQuery(sql).list();
		}finally {
			session.close();
		}
		return viajes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viaje> traer(GregorianCalendar ini,GregorianCalendar fin,TransportePublico transporte){
		List<Viaje> viajes;
		try {
			iniciaOperacion();
			String sql= "from Viaje v where v.fechaHora>='" + Funciones.traerFechaCortaHora(ini) + "' and v.fechaHora<='" 
			+ Funciones.traerFechaCortaHora(fin)+"' and v.transporte.idTransporte=" + transporte.getIdTransporte()+" order by v.fechaHora asc";
			viajes = session.createQuery(sql).list();
		}finally {
			session.close();
		}
		return viajes;
	}

}
