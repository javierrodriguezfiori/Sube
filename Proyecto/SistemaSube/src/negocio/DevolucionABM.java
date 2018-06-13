package negocio;

import datos.Devolucion;
import datos.TarjetaSube;

public class DevolucionABM {
	public static DevolucionABM instance = null;
	
	protected DevolucionABM() {}
	
	public static DevolucionABM getInstance() {
		if(instance==null) {
			instance = new DevolucionABM();
		}
		return instance;
	}
	
	public boolean registrarDevolucion(TarjetaSube tarjeta, Devolucion devolucion) throws Exception{
		TransaccionABM.getInstance().agregarDevolucion(devolucion.getMonto(),devolucion.getFechaHora(),tarjeta);
		tarjeta.setSaldo((float)(tarjeta.getSaldo()+devolucion.getMonto()));
		return TerminalViaje.getInstance().actualizarSaldo(tarjeta);
	}
}
