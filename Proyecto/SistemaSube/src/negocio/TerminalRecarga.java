package negocio;

import datos.TarjetaSube;
import datos.Recarga;

public class TerminalRecarga extends Terminal{
	public static TerminalRecarga instance = null;
	
	protected TerminalRecarga() {}
	
	public static TerminalRecarga getInstance() {
		if(instance==null) {
			instance = new TerminalRecarga();
		}
		return instance;
	}
	
	public boolean registrarRecarga(TarjetaSube tarjeta, Recarga recarga) throws Exception{
		TransaccionABM.getInstance().agregarRecarga(recarga.getMonto(),recarga.getFechaHora(),tarjeta);
		tarjeta.setSaldo((float)(tarjeta.getSaldo()+recarga.getMonto()));
		return actualizarSaldo(tarjeta);
	}
}
