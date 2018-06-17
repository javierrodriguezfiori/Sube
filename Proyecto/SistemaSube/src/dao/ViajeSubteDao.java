package dao;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Viaje;
import datos.ViajeSubte;
import funciones.Funciones;

public class ViajeSubteDao extends DAO{
	
	private static ViajeSubteDao instancia = null; // Patrón Singleton

	protected ViajeSubteDao() {}

	public static ViajeSubteDao getInstance() {
		if (instancia == null)
			instancia = new ViajeSubteDao();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<ViajeSubte> traerViajesSubte(GregorianCalendar ini,GregorianCalendar fin,long idTransporte){
		List<ViajeSubte> viajes;
		try {
			iniciaOperacion();
			String sql= "from ViajeSubte v where v.fechaHora>='" + Funciones.traerFechaCortaHora(ini) + "' and v.fechaHora<='" + Funciones.traerFechaCortaHora(fin)+"'" + 
			" and v.transporte.idTransporte="+idTransporte+ " order by v.fechaHora ASC";
			viajes = session.createQuery(sql).list();
		}finally {
			session.close();
		}
		return viajes;
	}
	
	
	
	

}
