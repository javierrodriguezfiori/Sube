package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.HibernateException;

import dao.*;
import datos.*;

public class TransaccionABM {
	
	private static TransaccionABM instancia = null; // Patrón Singleton

	protected TransaccionABM() {}

	public static TransaccionABM getInstance() {
		if (instancia == null)
			instancia = new TransaccionABM();
		return instancia;
	}
	
	
	public long agregarRecarga(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube) {
		Recarga r=new Recarga(monto,fechaHora,tarjetaSube);
		return RecargaDao.getInstance().agregar(r);
	}
	
	public boolean modificarRecarga(Recarga r) {
		return RecargaDao.getInstance().actualizar(r);
	}
	
	public boolean eliminarRecarga(Recarga r) {
		return RecargaDao.getInstance().eliminar(r);
	}
	
	public Transaccion traerTransaccion(int idTransaccion) {
		return TransaccionDao.getInstance().traer(idTransaccion);
	}
	
	public Recarga traerRecarga(int idRecarga) {
		return RecargaDao.getInstance().traerRecarga(idRecarga);
	}
	
	public List<Recarga> traerRecarga() {
		return RecargaDao.getInstance().traerRecarga();
	}
	
	public long agregarViajeTren(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube, TransportePublico tren, Parada origen, Parada destino) {
		ViajeTren vt=new ViajeTren(monto,fechaHora,tarjetaSube,tren,origen,destino);
		return ViajeTrenDao.getInstance().agregar(vt);
	}
	
	public boolean modificarViajeTren(ViajeTren vt) {
		return ViajeTrenDao.getInstance().actualizar(vt);
	}
	
	public boolean eliminarViajeTren(ViajeTren vt) {
		return ViajeTrenDao.getInstance().eliminar(vt);
	}
	
	public long agregarViajeSubte(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube, TransportePublico subte, Parada origen) {
		ViajeSubte vs=new ViajeSubte(monto,fechaHora,tarjetaSube,subte,origen);
		return ViajeSubteDao.getInstance().agregar(vs);
	}
	
	public boolean modificarViajeSubte(ViajeSubte vs) {
		return ViajeSubteDao.getInstance().actualizar(vs);
	}
	
	public boolean eliminarViajeSubte(ViajeSubte vs) {
		return ViajeSubteDao.getInstance().eliminar(vs);
	}
		
	public long agregarViajeColectivo(float monto, GregorianCalendar fechaHora, TarjetaSube tarjetaSube, TransportePublico colectivo, Tramo tramo) {
		ViajeColectivo vc=new ViajeColectivo(monto,fechaHora,tarjetaSube,colectivo,tramo);
		return ViajeColectivoDao.getInstance().agregar(vc);
	}
	
	public boolean modificarViajeColectivo(ViajeColectivo vc) {
		return ViajeColectivoDao.getInstance().actualizar(vc);
	}
	
	public boolean eliminarViajeColectivo(ViajeColectivo vc) {
		return ViajeColectivoDao.getInstance().eliminar(vc);
	}
	
	public List<Transaccion> traer(long nroTarjeta) throws HibernateException {
		return TransaccionDao.getInstance().traer(nroTarjeta);
	}

}
