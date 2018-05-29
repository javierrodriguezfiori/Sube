package negocio;

public abstract class Terminal {
	public boolean actualizarSaldo(TarjetaSube tarjeta) {
		TarjetaSubeABM.modificar(tarjeta);
		return true;
	}
	
	public boolean aplicarEstadoSube() {
		TarjetaSubeABM.modificar(tarjeta);
		return true;
	}
	
	
}
