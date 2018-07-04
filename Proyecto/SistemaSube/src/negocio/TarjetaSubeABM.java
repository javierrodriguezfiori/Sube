package negocio;


import dao.RolDao;
import dao.TarjetaSubeDao;
import datos.Sesion;
import datos.TarjetaSube;
import datos.Usuario;
import utils.TarjetaSubeInexistenteException;
import utils.UsuarioInvalidoException;

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
		
		// No valido si existe. Me sirve null.
		return tarjetaSube;
	}

	public TarjetaSube traerTarjetaSube(long nroTarjeta) {
		TarjetaSube t= TarjetaSubeDao.getInstance().traerTarjetaSube(nroTarjeta);

		// Si la tarjeta no existe devuelve null
		
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
	
	public void asociarAUsuario(long nroTarjeta, String documento) throws Exception{ 
		TarjetaSube tarjetaSube = TarjetaSubeDao.getInstance().traerTarjetaSube(nroTarjeta);
		Usuario usuario = UsuarioABM.getInstance().traerUsuario(documento);

		validarAsociacion(usuario, tarjetaSube);
		
		tarjetaSube.setUsuario(usuario);
		modificar(tarjetaSube);
		usuario.setRol(new RolDao().traerRol());
		new RolDao().actualizar(usuario);
	}
	
	public void desasociarDeUsuario(long nroTarjeta) throws Exception{ 
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
	
	public TarjetaSube validarTarjetaSube(String nroTarjeta) {
		TarjetaSube tarjetaSube = null;
		
		try {
			if (Sesion.obtenerSesionActual().getUsuarioLogeado() != null)
				tarjetaSube = Sesion.obtenerSesionActual().getTarjetaSubeDelUsuario();
			else if (nroTarjeta != null)
				tarjetaSube = traerTarjetaSube(Long.parseLong(nroTarjeta));
		} catch (NumberFormatException e) {	
			
		} catch (Exception e) {	}
		
		return tarjetaSube;
	}
	
	private static <T> boolean noExiste(T obj) {
		return (obj == null);
	}
	
	private void validarAsociacion(Usuario usuario, TarjetaSube tarjetaSube) throws Exception {
		
		if (noExiste(usuario))
			throw new UsuarioInvalidoException("No existe un usuario dado de alta con ese documento.");
		
		if(noExiste(tarjetaSube)) 
			throw new TarjetaSubeInexistenteException("No existe una tarjeta sube asociada a ese numero.");  
		
		if(tarjetaSube.getUsuario()!=null)
			throw new Exception("Tarjeta ya asociada a un usuario");  

		if(TarjetaSubeDao.getInstance().traerTarjetaSube(usuario) != null) 
			throw new Exception("El usuario ya tiene una tarjeta asociada"); 
	}
}
