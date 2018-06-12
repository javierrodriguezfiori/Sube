package negocio;


import dao.TarjetaSubeDao;
import datos.TarjetaSube;
import datos.Usuario;
import java.util.GregorianCalendar;

public class TarjetaSubeABM {
	 
	// Singleton
    private static TarjetaSubeABM instancia = null;
	
	protected TarjetaSubeABM() {};
	
	public static TarjetaSubeABM getInstance() {
		if(noExiste(instancia)) {
			instancia = new TarjetaSubeABM();
		}
		return instancia;
	}
	
	public TarjetaSube traerTarjetaSube(Usuario usuario) throws Exception{
		TarjetaSube tarjetaSube = TarjetaSubeDao.getInstance().traerTarjetaSube(usuario);

		if(noExiste(tarjetaSube))
			throw new Exception("La tarjeta no existe");
		
		return tarjetaSube;
	}

	public TarjetaSube traerTarjetaSube(long nroTarjeta) throws Exception{
		TarjetaSube t= TarjetaSubeDao.getInstance().traerTarjetaSube(nroTarjeta);

		if(noExiste(t))
			throw new Exception("La tarjeta no existe");
		
		return t;
	}
	
	public long agregar(float saldo, int estado, Usuario usuario) throws Exception{
		TarjetaSube t= new TarjetaSube(saldo, estado, usuario);
		long id=TarjetaSubeDao.getInstance().agregar(t);
		RedSubeABM.getInstance().agregar(new GregorianCalendar(), 0, "", TarjetaSubeABM.getInstance().traerTarjetaSube(id));
		return id;
	}
	
	public void eliminar(long nroTarjeta) throws Exception{ 
			TarjetaSube t= TarjetaSubeDao.getInstance().traerTarjetaSube(nroTarjeta);
			if(noExiste(t))
				throw new Exception("La tarjeta no existe");  
			else
				TarjetaSubeDao.getInstance().eliminar(t);
	}
	
	public void asociar(long nroTarjeta, String documento) throws Exception{ 
		Usuario u= UsuarioABM.getInstance().traerUsuario(documento);
		TarjetaSube t= TarjetaSubeDao.getInstance().traerTarjetaSube(nroTarjeta);
		if(noExiste(t) || noExiste(u)) 
			throw new Exception("Tarjeta o Usuario no encontrado");  
		else
			if(t.getUsuario()!=null)
				throw new Exception("Tarjeta ya asociada a un usuario");  
			else {
				t.setUsuario(u);
				modificar(t);
			}
	}
	
	public void desasociar(long nroTarjeta) throws Exception{ 
		TarjetaSube t= TarjetaSubeDao.getInstance().traerTarjetaSube(nroTarjeta);
		if(noExiste(t))
			throw new Exception("La tarjeta no existe");  
		else
			t.setUsuario(null);
			modificar(t);
}
	
	public void modificar(TarjetaSube tarjetaSube) throws Exception{
		TarjetaSubeDao.getInstance().actualizar(tarjetaSube);
	}
	
	public double calcularDescuento(TarjetaSube tarjeta) {
		/* IMPORTANTE!: El metodo está pensado para utilizar su salida multiplicandola por el precio. 
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
	
	private static <T> boolean noExiste(T obj) {
		return (obj == null);
	}
}
