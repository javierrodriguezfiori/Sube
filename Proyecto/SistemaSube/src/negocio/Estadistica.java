package negocio;

import java.util.ArrayList;
import java.util.List;

public class Estadistica {
	
	private List<Muestra> muestras;
	
	public Estadistica() {
		muestras = new ArrayList<Muestra>();
	}
	
	public boolean add(Muestra muestra) {
		return muestras.add(muestra);
	}
	
	public Muestra traerMuestra(int id) {
		Muestra muestra = null;
		boolean encontrado=false;
		int i=0;
		while(i<muestras.size() && encontrado==false) {
			if(muestras.get(i).getIdMuestra()==id) {
				muestra = muestras.get(i);
				encontrado=true;
			}
			i++;
		}
		return muestra;
	}
	
	public Muestra traerMuestra(int id1,int id2) {
		Muestra muestra = null;
		boolean encontrado=false;
		int i=0;
		while(i<muestras.size() && encontrado==false) {
			if(muestras.get(i).getIdMuestra()==id1 && muestras.get(i).getIdMuestra2()==id2) {
				muestra = muestras.get(i);
				encontrado=true;
			}
			i++;
		}
		return muestra;
	}

	public List<Muestra> getMuestras() {
		return muestras;
	}

	public void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}

	@Override
	public String toString() {
		return "Estadistica [muestras=" + muestras + "]";
	}
	
	
	

}
