package test;

import negocio.ParadaABM;
import negocio.TramoABM;

public class TestAgregarParadas {

	public static void main(String[] args) {
		
		
		//Constitucion-Korno//
		ParadaABM.getInstance().agregar(1,"Constitucion");
		ParadaABM.getInstance().agregar(2,"Hipólito Yrigoyen");
		ParadaABM.getInstance().agregar(3,"D.Santillán Y M.Kosteki");
		ParadaABM.getInstance().agregar(4,"Gerli");
		ParadaABM.getInstance().agregar(5,"Lanús");
		ParadaABM.getInstance().agregar(6,"Remedios de Escalada");
		ParadaABM.getInstance().agregar(7,"Banfield");
		ParadaABM.getInstance().agregar(8,"Lomas de Zamora");
		ParadaABM.getInstance().agregar(9,"Termperey");
		ParadaABM.getInstance().agregar(10,"Adrogue");
		ParadaABM.getInstance().agregar(11,"Burzaco");
		ParadaABM.getInstance().agregar(12,"Longhcamps");
		ParadaABM.getInstance().agregar(13,"Glew");
		ParadaABM.getInstance().agregar(14,"Guernica");
		ParadaABM.getInstance().agregar(15,"Alejandro Korn");
		
		
		//Linea C//
		//Constitucion ya esta agregada//
		ParadaABM.getInstance().agregar(16,"San Juan");
		ParadaABM.getInstance().agregar(17,"Independencia");
		ParadaABM.getInstance().agregar(18,"Moreno");
		ParadaABM.getInstance().agregar(19,"Av. de Mayo");
		ParadaABM.getInstance().agregar(20,"Diagonal Norte");
		ParadaABM.getInstance().agregar(21,"Lavalle");
		ParadaABM.getInstance().agregar(22,"Gnral. San Martin");
		ParadaABM.getInstance().agregar(23,"Retiro");
		
		

	}

}
