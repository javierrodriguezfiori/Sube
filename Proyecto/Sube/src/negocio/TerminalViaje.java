package negocio;
import datos.Viaje;
import datos.TarjetaSube;
import datos.Recarga;
import datos.ViajeTren;
import datos.ViajeSubte;
import datos.ViajeColectivo;
import java.util.GregorianCalendar;

public class TerminalViaje extends Terminal{
	
	public boolean cobrarViaje(TarjetaSube tarjeta, Viaje viaje) throws Exception{
		boolean cobrado=false;
		ViajeABM vabm=new ViajeABM();
		Viaje ultimo=vabm.traerUltimoViaje(tarjeta.getNroTarjeta());
		float precio=0;
		float diferencia=0;
		if( ultimo instanceof ViajeTren && viaje instanceof ViajeTren){
			ViajeTren ultimoT=(ViajeTren)ultimo;
			ViajeTren viajeT=(ViajeTren)viaje;
			if(ultimoT.getDestino() == null) {
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
	    }
		else{
			precio  = (float)viaje.getTransporte().calcularCostoDeViaje(viaje);
			System.out.println(RedSubeABM.getInstance().calcularDescuento(tarjeta.getNroTarjeta(),"160", viaje.getFechaHora()));
			System.out.println(TarjetaSubeABM.getInstance().calcularDescuento(tarjeta));
			precio=(float)(precio*TarjetaSubeABM.getInstance().calcularDescuento(tarjeta)*RedSubeABM.getInstance().calcularDescuento(tarjeta.getNroTarjeta(),viaje.getTransporte().getLinea(), viaje.getFechaHora()));
			viaje.setMonto(precio);
			if((tarjeta.getSaldo()-precio)<(-20)) throw new Exception ("ERROR: Saldo insuficiente.");
			cobrado=registrarViaje(tarjeta,viaje);
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
