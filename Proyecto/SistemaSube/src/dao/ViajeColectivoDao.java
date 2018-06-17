package dao;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Viaje;
import datos.ViajeColectivo;
import funciones.Funciones;

public class ViajeColectivoDao extends DAO{
	
	private static ViajeColectivoDao instancia = null; // Patrón Singleton

	protected ViajeColectivoDao() {}

	public static ViajeColectivoDao getInstance() {
		if (instancia == null)
			instancia = new ViajeColectivoDao();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<ViajeColectivo> traerViajesColectivo(GregorianCalendar ini,GregorianCalendar fin,long idTransporte){
		List<ViajeColectivo> viajes;
		try {
			iniciaOperacion();
			String sql= "from ViajeColectivo v where v.fechaHora>='" + Funciones.traerFechaCortaHora(ini) + "' and v.fechaHora<='" + Funciones.traerFechaCortaHora(fin)+"'" + 
			" and v.transporte.idTransporte="+idTransporte+ " order by v.fechaHora ASC";
			viajes = session.createQuery(sql).list();
		}finally {
			session.close();
		}
		return viajes;
	}
	
	

}
