package dao;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Viaje;
import datos.ViajeTren;
import funciones.Funciones;

public class ViajeTrenDao extends DAO{
	
	private static ViajeTrenDao instancia = null; // Patrón Singleton

	protected ViajeTrenDao() {}

	public static ViajeTrenDao getInstance() {
		if (instancia == null)
			instancia = new ViajeTrenDao();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Viaje> traerViajesTren(GregorianCalendar ini,GregorianCalendar fin,long idTransporte){
		List<Viaje> viajes;
		try {
			iniciaOperacion();
			String sql= "from ViajeTren v where v.fechaHora>='" + Funciones.traerFechaCortaHora(ini) + "' and v.fechaHora<='" + Funciones.traerFechaCortaHora(fin)+"'" + 
			" and v.transporte.idTransporte="+idTransporte+ " order by v.fechaHora ASC";
			viajes = session.createQuery(sql).list();
		}finally {
			session.close();
		}
		return viajes;
	}
	

}
