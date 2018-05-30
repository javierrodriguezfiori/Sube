package negocio;

import datos.TarjetaSube;

public abstract class Terminal {
	public boolean actualizarSaldo(TarjetaSube tarjeta) throws Exception{
		TarjetaSubeABM ts=new TarjetaSubeABM();
		ts.modificar(tarjeta);
		return true;
	}
	
	/*public boolean aplicarEstadoSube() {
		TarjetaSubeABM.modificar(tarjeta);
		return true;
	}*/
	
	
}
