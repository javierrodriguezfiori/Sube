package utils;

public class UsuarioInvalido extends Exception {
	
	public UsuarioInvalido() {
		super();
	}
	
	public UsuarioInvalido(String message) {
		super(message);
	}
}
