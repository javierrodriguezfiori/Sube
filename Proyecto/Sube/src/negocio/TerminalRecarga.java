package negocio;

import datos.TarjetaSube;
import datos.Recarga;

public class TerminalRecarga extends Terminal{
	public boolean registrarRecarga(TarjetaSube tarjeta, Recarga recarga) throws Exception{
		TransaccionABM.getInstance().agregarRecarga(recarga.getMonto(),recarga.getFechaHora(),tarjeta);
		tarjeta.setSaldo((float)(tarjeta.getSaldo()+recarga.getMonto()));
		return actualizarSaldo(tarjeta);
	}
}
