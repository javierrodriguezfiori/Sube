package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.ViajeDao;
import dao.ViajeSubteDao;
import dao.ViajeColectivoDao;
import dao.ViajeTrenDao;
import datos.Viaje;
import datos.ViajeColectivo;
import datos.ViajeSubte;
import datos.ViajeTren;
import funciones.Funciones;


public class ViajeABM {
	private static ViajeABM instance = null;
	
	protected ViajeABM() {}
	
	public static ViajeABM getInstance() {
		if(instance==null) {
			instance = new ViajeABM();
		}
		return instance;
	}
	
	public Viaje traerUltimoViaje(long nroTarjeta) {
		
		return ViajeDao.getInstance().traerUltimoViaje(nroTarjeta);
	}
	
	
	
	public List<Viaje> traerViajesTren(GregorianCalendar ini,GregorianCalendar fin){
		return ViajeDao.getInstance().traerViajesTren(ini, fin);
	}
	
	
	public List<Viaje> traerViajesColectivo(GregorianCalendar ini,GregorianCalendar fin){
		
		return ViajeDao.getInstance().traerViajesColectivo(ini, fin);
	}
	
	
	public List<Viaje> traerViajesSubte(GregorianCalendar ini,GregorianCalendar fin){
		return ViajeDao.getInstance().traerViajesSubte(ini, fin);
	}
	
	public List<ViajeSubte> traerViajesSubte(GregorianCalendar ini,GregorianCalendar fin,long idTransporte){
		return ViajeSubteDao.getInstance().traerViajesSubte(ini, fin, idTransporte);
	}
	
	public List<ViajeColectivo> traerViajesColectivo(GregorianCalendar ini,GregorianCalendar fin,long idTransporte){
		return ViajeColectivoDao.getInstance().traerViajesColectivo(ini, fin, idTransporte);
	}
	
	public List<ViajeTren> traerViajesTren(GregorianCalendar ini,GregorianCalendar fin,long idTransporte){
		return ViajeTrenDao.getInstance().traerViajesTren(ini, fin, idTransporte);
	}
	
	public Estadistica estadisticaViajesColectivo(GregorianCalendar ini,GregorianCalendar fin,long idTransporte){
		Estadistica estadistica = new Estadistica();
		List<ViajeColectivo> viajesColectivos = ViajeColectivoDao.getInstance().traerViajesColectivo(ini, fin, idTransporte);
		for(ViajeColectivo viaje : viajesColectivos) {
			Muestra muestra = estadistica.traerMuestra((int) viaje.getTramo().getIdTramo());
			if(muestra==null) {
				estadistica.add(new Muestra((int)viaje.getTramo().getIdTramo(),viaje.getTramo().getDistancia(),1,viaje.getMonto()));
			}else {
				muestra.setCant(muestra.getCant()+1);
				muestra.setSum(muestra.getSum() + viaje.getMonto());
			}
		}
		
		return estadistica;
		
	}
	
	public Estadistica estadisticaViajesSubte(GregorianCalendar ini,GregorianCalendar fin,long idTransporte){
		Estadistica estadistica = new Estadistica();
		List<ViajeSubte> viajeSubte = ViajeSubteDao.getInstance().traerViajesSubte(ini, fin, idTransporte);
		for(ViajeSubte viaje : viajeSubte) {
			Muestra muestra = estadistica.traerMuestra((int) viaje.getOrigen().getIdParada());
			if(muestra==null) {
				estadistica.add(new Muestra((int)viaje.getOrigen().getIdParada(),viaje.getOrigen().getNombre(),1,viaje.getMonto()));
			}else {
				muestra.setCant(muestra.getCant()+1);
				muestra.setSum(muestra.getSum() + viaje.getMonto());
			}
		}
		
		return estadistica;
		
	}
	
	public Estadistica estadisticaViajesTren(GregorianCalendar ini,GregorianCalendar fin,long idTransporte){
		Estadistica estadistica = new Estadistica();
		List<ViajeTren> viajeTren = ViajeTrenDao.getInstance().traerViajesTren(ini, fin, idTransporte);
		for(ViajeTren viaje : viajeTren) {
			if(viaje.getDestino()!=null) {
			Muestra muestra = estadistica.traerMuestra((int) viaje.getOrigen().getIdParada(),(int) viaje.getDestino().getIdParada());
		
			
			if(muestra==null) {
				estadistica.add(new Muestra((int)viaje.getOrigen().getIdParada(),(int) viaje.getDestino().getIdParada(),viaje.getOrigen().getNombre(),viaje.getDestino().getNombre(),1,viaje.getMonto()));
			}else {
				muestra.setCant(muestra.getCant()+1);
				muestra.setSum(muestra.getSum() + viaje.getMonto());
			}
		  }
		}
		
		return estadistica;
		
	}
	
	
	
	
	

}
