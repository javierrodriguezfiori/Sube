package negocio;

import datos.Viaje;
import datos.TarjetaSube;
import datos.Devolucion;
import datos.ViajeTren;
import utils.SaldoInsuficienteException;
import datos.ViajeSubte;
import datos.ViajeColectivo;
import datos.RedSube;

public class TerminalViaje extends Terminal{
	public static TerminalViaje instance = null;
	
	protected TerminalViaje() {}
	
	public static TerminalViaje getInstance() {
		if(instance==null) {
			instance = new TerminalViaje();
		}
		return instance;
	}
	
	public boolean cobrarViaje(Viaje viaje) throws Exception{
		boolean cobrado=false;
		
		TarjetaSube tarjeta=viaje.getTarjetaSube();		
		Viaje ultimo=ViajeABM.getInstance().traerUltimoViaje(tarjeta.getNroTarjeta());
		
		float precio=0;
		float diferencia=0;
		boolean cobrarNormal=false;
		
		// Evaluar si el ultimo Viaje fue en tren
		if( ultimo instanceof ViajeTren && viaje instanceof ViajeTren){
			ViajeTren ultimoT=(ViajeTren)ultimo;
			ViajeTren viajeT=(ViajeTren)viaje;
			if(ultimoT.getDestino() == null) {
				ultimoT.setDestino(viajeT.getOrigen());
				// Si el origen del ultimo viaje es distinto al origen del actual, se procede a devolver el dinero. Sino se cierra el ultimo viaje sin devolucion
				if(ultimoT.getOrigen().getIdParada() != ultimoT.getDestino().getIdParada()) {
					precio=(float)ultimoT.getTransporte().calcularCostoDeViaje(ultimoT);
				    precio=(float)(precio*TarjetaSubeABM.getInstance().calcularDescuento(tarjeta)*RedSubeABM.getInstance().calcularDescuento(viaje));
				    diferencia=ultimoT.getMonto()-precio;
					viaje.setMonto(precio);
				    Devolucion devolucion=new Devolucion(diferencia,viaje.getFechaHora(),tarjeta);
				    TransaccionABM.getInstance().modificarViajeTren(ultimoT);
				    cobrado=DevolucionABM.getInstance().registrarDevolucion(tarjeta,devolucion);
				} 
				else 
					TransaccionABM.getInstance().modificarViajeTren(ultimoT);	    	
			} 
			else 
				cobrarNormal=true;
	    }
		else 
			cobrarNormal=true;
		
		if(cobrarNormal) {
			// 
			if(ultimo instanceof ViajeTren) {
				ViajeTren ultimoT= (ViajeTren) ultimo;
				ultimoT.setDestino(ultimoT.getOrigen());
				TransaccionABM.getInstance().modificarViajeTren(ultimoT); 
			}
			// Traer costo desde TransportePublico
			precio  = (float)viaje.getTransporte().calcularCostoDeViaje(viaje);
			// Calcular descuento TarjetaSube y RedSube
			double descuentoTarjetaSube = TarjetaSubeABM.getInstance().calcularDescuento(tarjeta);
			double descuentoRedSube = RedSubeABM.getInstance().calcularDescuento(viaje);
			// Calcular precio final y actualizarlo en el Viaje
			precio=(float)(precio*descuentoTarjetaSube*descuentoRedSube);
			viaje.setMonto(precio);
			// Evaluar si el saldo es insuficiente y tirar excepcion
			if((tarjeta.getSaldo()-precio)<(-20)) throw new SaldoInsuficienteException ("Saldo insuficiente.");
			// Cobrar viaje
			cobrado=registrarViaje(tarjeta,viaje);
			// Resetear RedSube si no hubo descuento
			if(descuentoRedSube==1) {
				RedSubeABM.getInstance().resetearRedSube(viaje);
			}	
			else {
				// Actualizar RedSube para contabilizar este ultimo viaje
				RedSube redSube= RedSubeABM.getInstance().traerRedSube(viaje.getTarjetaSube().getNroTarjeta());
				redSube.setContador(redSube.getContador()+1);
				redSube.setLinea(viaje.getTransporte().getLinea());
				RedSubeABM.getInstance().modificar(redSube);
			}
		}
		
		return cobrado;
	}
	
	public boolean registrarViaje(TarjetaSube tarjeta, Viaje viaje) throws Exception {
		if(viaje instanceof ViajeTren) {
			TransaccionABM.getInstance().agregarViajeTren(viaje.getMonto(),viaje.getFechaHora(),tarjeta,viaje.getTransporte(),((ViajeTren)viaje).getOrigen(),((ViajeTren)viaje).getDestino());
		}
		if(viaje instanceof ViajeSubte) {
			TransaccionABM.getInstance().agregarViajeSubte(viaje.getMonto(),viaje.getFechaHora(),tarjeta,viaje.getTransporte(),((ViajeSubte)viaje).getOrigen());
		}
		if(viaje instanceof ViajeColectivo) {
			TransaccionABM.getInstance().agregarViajeColectivo(viaje.getMonto(),viaje.getFechaHora(),tarjeta,viaje.getTransporte(),((ViajeColectivo)viaje).getTramo());
		}
		tarjeta.setSaldo((float)(tarjeta.getSaldo()-viaje.getMonto()));
		return actualizarSaldo(tarjeta);
	}
		
}
