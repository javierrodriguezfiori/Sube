package negocio;

import datos.TarjetaSube;
import negocio.TarjetaSubeABM;

public abstract class Terminal {
	public boolean actualizarSaldo(TarjetaSube tarjeta, double valor) {
		boolean resultado=false;
		
		TarjetaSubeABM tarjetaABM= new TarjetaSubeABM();
		try{
			tarjeta.setSaldo(tarjeta.getSaldo()+valor);
			tarjetaABM.modificar(tarjeta);
			resultado=true;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return resultado;
	}
	
	public boolean aplicarEstadoSube(TarjetaSube tarjeta, int estado) {
		// Estados posibles: 0-Sin Descuentos, 1-Tarifa Social, 2-Boleto Estudiantil
		
		boolean resultado=false;
		
		TarjetaSubeABM tarjetaABM= new TarjetaSubeABM();
		try{
			tarjeta.setEstado(estado);;
			tarjetaABM.modificar(tarjeta);
			resultado=true;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return resultado;
	}
}
