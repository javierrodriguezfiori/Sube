package negocio;

import datos.TarjetaSube;
import negocio.TarjetaSubeABM;

public class TerminalConsulta extends Terminal{
	public double consultarSaldo(TarjetaSube tarjeta) {
		TarjetaSubeABM abm= new TarjetaSubeABM();
		double saldo=0;
		try {
			saldo=abm.traerTarjetaSube(tarjeta.getNroTarjeta()).getSaldo();
		} catch (Exception e) {
			System.out.println(e);
		}
		return saldo; 
	}
}
