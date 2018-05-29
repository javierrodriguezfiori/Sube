package negocio;

public abstract class Terminal {
	public boolean actualizarSaldo() {	
		return true;
	}
	
	public boolean aplicarEstadoSube() {
		// Estados posibles: 0-Sin Descuentos, 1-Tarifa Social, 2-Boleto Estudiantil
		return true;
	}
}
