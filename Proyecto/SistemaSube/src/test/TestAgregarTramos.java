package test;
import negocio.TramoABM;
public class TestAgregarTramos {

	public static void main(String[] args) {
		TramoABM.getInstance().agregar("0-5", 7);
		TramoABM.getInstance().agregar("5-10", 7);
		TramoABM.getInstance().agregar("10-15", 7);
		TramoABM.getInstance().agregar("15-20", 7);

	}

}
