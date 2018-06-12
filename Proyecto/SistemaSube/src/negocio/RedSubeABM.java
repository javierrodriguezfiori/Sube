package negocio;

import java.util.GregorianCalendar;

import dao.RedSubeDao;
import datos.RedSube;
import datos.TarjetaSube;
import datos.Viaje;

public class RedSubeABM {
	public static RedSubeABM instance = null;
	protected RedSubeABM() {}
	
	public static RedSubeABM getInstance() {
		if(instance==null) {
			instance = new RedSubeABM();
		}
		return instance;
	}
	
	public RedSube traerRedSube(long idRedSube) throws Exception{
		RedSube rs= RedSubeDao.getInstance().traerRedSube(idRedSube);
		return rs;
	}
	
	public long agregar(GregorianCalendar fechaHora, int contador, String linea, TarjetaSube tarjetasube) throws Exception{
		RedSube rs= new RedSube(fechaHora, contador, linea, tarjetasube);
		return RedSubeDao.getInstance().agregar(rs);
	}
	
	public void modificar(RedSube rs) throws Exception{
		RedSubeDao.getInstance().actualizar(rs);
	}

	public double calcularDescuento(Viaje viaje) throws Exception{
		/* IMPORTANTE!: El metodo está pensado para utilizar su salida multiplicandola por el precio. 
		En caso de no existir descuento devuelve 1. */		
		
		long nroTarjetaSube= viaje.getTarjetaSube().getNroTarjeta();
		String lineaTransporte= viaje.getTransporte().getLinea();
		GregorianCalendar fechaHora= viaje.getFechaHora();
		
		RedSube redSube = RedSubeDao.getInstance().traerRedSube(nroTarjetaSube);
	
		boolean sinDescuento=false;
		double descuento=1;
		
		// Si la diferencia entre la hora de RedSube y el viaje actual es mayor a 2hs no hay descuento y resetear RedSube
		if(redSube.getFechaHora()!=null) {
			if((fechaHora.getTimeInMillis()-redSube.getFechaHora().getTimeInMillis())/1000/60>120)
				sinDescuento=true;
			
			// Si el transporte es el mismo al de RedSube no hay descuento
			if(redSube.getLinea().equals(lineaTransporte)&&!sinDescuento) 
				sinDescuento=true;
				
			if(!sinDescuento) {
				int contador= redSube.getContador()+1;
				// Si el contador+1 está en 2: 50% de descuento
				if(contador==2) 
					descuento=0.5;
				else {
					// Si el contador+1 es mayor de 2 y menor o igual a 5 el descuento es 75%
					if(contador>=3&&contador<=5) {
						descuento=0.25;
					} 
				}
			}
		}
		return descuento;
	}
	
	public void resetearRedSube(Viaje viaje) {
		long nroTarjetaSube= viaje.getTarjetaSube().getNroTarjeta();
		String lineaTransporte= viaje.getTransporte().getLinea();
		GregorianCalendar fechaHora= viaje.getFechaHora();
		
		RedSube rs = RedSubeDao.getInstance().traerRedSube(nroTarjetaSube);
		
		rs.setFechaHora(fechaHora);
		rs.setContador(1);
		rs.setLinea(lineaTransporte);
		try {
			modificar(rs);
		} catch (Exception e) {
			System.out.println("Error al resetear la RedSube");
		}
	}
}
