package negocio;
import org.hibernate.Hibernate;

import dao.TransportePublicoDao; 
import datos.Colectivo;
import datos.Subte;
import datos.TransportePublico;
import datos.Tren;
import datos.Viaje;
import datos.ViajeColectivo;
import datos.ViajeSubte;
import datos.ViajeTren;
public class TransportePublicoABM  {
	
	private static TransportePublicoABM instancia = null;
	
	protected TransportePublicoABM() {}
	
	public static TransportePublicoABM getInstance() {
		if(instancia==null) {
			instancia = new TransportePublicoABM();
		}
		return instancia;
	}
	
	public TransportePublico traer(long idTransporte) {
		return TransportePublicoDao.getInstance().traerTransportePublico(idTransporte);
	}
	
	public long agregarColectivo(long id,String linea)throws Exception {
		if(TransportePublicoDao.getInstance().traerTransportePublico(linea)!=null)throw new Exception("Linea existente");
		Colectivo c = new Colectivo(id,linea);
		return TransportePublicoDao.getInstance().agregar(c);
	}
	
    public long agregarTren(long id,String linea)throws Exception {
    	if(TransportePublicoDao.getInstance().traerTransportePublico(linea)!=null)throw new Exception("Linea existente");
		Tren c = new Tren(id,linea);
		return TransportePublicoDao.getInstance().agregar(c);
		
	}
    public long agregarSubte(long id,String linea)throws Exception {
    	if(TransportePublicoDao.getInstance().traerTransportePublico(linea)!=null)throw new Exception("Linea existente");
		Subte c = new Subte(id,linea);
		return TransportePublicoDao.getInstance().agregar(c);
		
	}
    
    public boolean eliminar(long idTransporte)throws Exception{
    	 TransportePublico t = TransportePublicoDao.getInstance().traerTransportePublico(idTransporte);
    	return TransportePublicoDao.getInstance().eliminar(t);
    }
    
    public void modificar(TransportePublico transporte) {
    	TransportePublicoDao.getInstance().actualizar(transporte);
    }
    
    public Subte traerSubteYParadas(long idSubte) {
		return TransportePublicoDao.getInstance().traerSubteYParadas(idSubte);
	}
    public Colectivo traerColectivoYTramos(long idColectivo) {
		return TransportePublicoDao.getInstance().traerColectivoYTramos(idColectivo);
	}
    
    public Tren traerTrenYParadas(long idTren) {
		return TransportePublicoDao.getInstance().traerTrenYParadas(idTren);
	}
    
    public double calcularCostoDeViaje(Viaje viaje) {
    	double costoViaje=0;
    	if(viaje instanceof ViajeColectivo) {
    		costoViaje = ((ViajeColectivo) viaje).getTramo().getCosto();
    	}
    	if(viaje instanceof ViajeTren) {
    		if(((ViajeTren) viaje).getDestino()==null) {
				costoViaje = SeccionABM.getInstance().traer((long)3).getCosto();
			}else {
				
				costoViaje = SeccionRecorridoABM.getInstance().traer(((ViajeTren) viaje).getOrigen(), ((ViajeTren) viaje).getDestino()).getSeccion().getCosto();
			}
    	}
    	if(viaje instanceof ViajeSubte) {
    		costoViaje = CostoSubte.getInstance().traerCostoSubte();
    	}
    	return costoViaje;
    }

}
