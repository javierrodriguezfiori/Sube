package datos;

public class Contacto {
	private long idContacto;
	private String mail;
	private String movil;
	private String fijo;
	
	public Contacto() { }
	
	public Contacto(String mail, String movil, String fijo) {
		this.mail = mail;
		this.movil = movil;
		this.fijo = fijo;
	}

	public long getIdContacto() {
		return idContacto;
	}

	@SuppressWarnings("unused")
	private void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getFijo() {
		return fijo;
	}

	public void setFijo(String fijo) {
		this.fijo = fijo;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", mail=" + mail + ", movil=" + movil + ", fijo=" + fijo + "]";
	}
}
