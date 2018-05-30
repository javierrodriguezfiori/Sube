package negocio;


import dao.TarjetaSubeDao;
import datos.TarjetaSube;

public class TarjetaSubeABM {
	 

		    private static TarjetaSubeABM instancia = null;
			
			protected TarjetaSubeABM() {};
			
			public static TarjetaSubeABM getInstance() {
				if(instancia==null) {
					instancia = new TarjetaSubeABM();
				}
				return instancia;
			}
	
	public TarjetaSube traerTarjetaSube(long nroTarjeta) throws Exception{
		TarjetaSube t= TarjetaSubeDao.getInstance().traerTarjetaSube(nroTarjeta);
		// Si la tarjeta no existe tirar error
		if(t==null)
			throw new Exception("La tarjeta no existe");
		return t;
	}
	
	public long agregar(int idUsuario, float saldo, int estado) throws Exception{
		TarjetaSube t= new TarjetaSube(idUsuario, saldo, estado);
		return TarjetaSubeDao.getInstance().agregar(t);
	}
	
	public void eliminar(long nroTarjeta) throws Exception{ 
			TarjetaSube t= TarjetaSubeDao.getInstance().traerTarjetaSube(nroTarjeta);
			if(t==null)
				throw new Exception("La tarjeta no existe");  
			else
				TarjetaSubeDao.getInstance().eliminar(t);
	}
	
	public void modificar(TarjetaSube tarjetaSube) throws Exception{
		TarjetaSubeDao.getInstance().actualizar(tarjetaSube);
	}
	
	public double calcularDescuento(TarjetaSube tarjeta) {
		/* IMPORTANTE!: El metodo est� pensado para utilizar su salida multiplicandola por el precio. 
		En caso de no existir descuento devuelve 1. */
		
		double descuento=1;
		int estado = tarjeta.getEstado();
		
		switch(estado) {
			// Estado 0: Sin Descuentos
			case 0:
				break;
			// Estado 1: Tarifa Social
			case 1:
				descuento=0.45;
				break;
			// Estado 2: Boleto Estudiantil
			case 2:
				descuento=0;
				break;
		}
	
		return descuento;
	}
}