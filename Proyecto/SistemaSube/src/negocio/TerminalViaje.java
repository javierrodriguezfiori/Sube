package negocio;

import datos.Viaje;
import datos.TarjetaSube;
import datos.Recarga;
import datos.ViajeTren;
import datos.ViajeSubte;
import datos.ViajeColectivo;
import datos.RedSube;

public class TerminalViaje extends Terminal{
	
	public boolean cobrarViaje(Viaje viaje) throws Exception{
		boolean cobrado=false;
		
		TarjetaSube tarjeta=viaje.getTarjetaSube();
		
		ViajeABM vabm=new ViajeABM();
		Viaje ultimo=vabm.traerUltimoViaje(tarjeta.getNroTarjeta());
		
		float precio=0;
		float diferencia=0;
		
		boolean cobrarNormal=false;
		// Evaluar si el ultimo Viaje fue en tren y no pasaron 2 horas
		if( ultimo instanceof ViajeTren && viaje instanceof ViajeTren){
			ViajeTren ultimoT=(ViajeTren)ultimo;
			ViajeTren viajeT=(ViajeTren)viaje;
			float horario= (viajeT.getFechaHora().getTimeInMillis()-ultimoT.getFechaHora().getTimeInMillis())/1000/60;
			if(ultimoT.getDestino() == null && horario<=120) {
				 ultimoT.setDestino(viajeT.getOrigen());
			     precio=(float)ultimoT.getTransporte().calcularCostoDeViaje(ultimoT);
			     precio=(float)(precio*TarjetaSubeABM.getInstance().calcularDescuento(tarjeta)*RedSubeABM.getInstance().calcularDescuento(tarjeta.getNroTarjeta(),viaje.getTransporte().getLinea(), viaje.getFechaHora()));
			     diferencia=ultimoT.getMonto()-precio;
				 viaje.setMonto(precio);
			     Recarga recarga=new Recarga(diferencia,viaje.getFechaHora(),tarjeta);
			     TerminalRecarga tr=new TerminalRecarga();
			     TransaccionABM.getInstance().modificarViajeTren(ultimoT);
			     cobrado=tr.registrarRecarga(tarjeta,recarga);
			} 
			else {
				cobrarNormal=true;
			}
	    }
		else {
			cobrarNormal=true;
		}
		
		if(cobrarNormal) {
			// Traer costo desde TransportePublico
			precio  = (float)viaje.getTransporte().calcularCostoDeViaje(viaje);
			// Calcular descuento TarjetaSube y RedSube
			double descuentoTarjetaSube = TarjetaSubeABM.getInstance().calcularDescuento(tarjeta);
			double descuentoRedSube = RedSubeABM.getInstance().calcularDescuento(tarjeta.getNroTarjeta(),viaje.getTransporte().getLinea(), viaje.getFechaHora());
			// Calcular precio final y actualizarlo en el Viaje
			precio=(float)(precio*descuentoTarjetaSube*descuentoRedSube);
			viaje.setMonto(precio);
			// Evaluar si el saldo es insuficiente y tirar excepcion
			if((tarjeta.getSaldo()-precio)<(-20)) throw new Exception ("ERROR: Saldo insuficiente.");
			// Cobrar viaje
			cobrado=registrarViaje(tarjeta,viaje);
			// Resetear RedSube si no hubo descuento
			if(descuentoRedSube==1) {
				RedSubeABM.getInstance().resetearRedSube(viaje.getTarjetaSube().getNroTarjeta(), viaje.getFechaHora(), viaje.getTransporte().getLinea());
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
