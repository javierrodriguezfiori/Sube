package datos;

public class TarjetaSube {
	private long nroTarjeta;
	private float saldo;
	private int estado;
	private RedSube redSube;
	private Usuario usuario;
	
	public TarjetaSube() {
	}

	public TarjetaSube(float saldo, int estado, Usuario usuario) {
		this.saldo = saldo;
		this.estado = estado;
		this.usuario = usuario;
	}

	public long getNroTarjeta() {
		return nroTarjeta;
	}

	protected void setNroTarjeta(long nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public RedSube getRedSube() {
		return redSube;
	}

	public void setRedSube(RedSube redSube) {
		this.redSube = redSube;
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "TarjetaSube [nroTarjeta=" + nroTarjeta + ", saldo=" + saldo + ", estado=" + estado + ", redSube="
				+ redSube + ", usuario=" + usuario + "]";
	}

	
	
}
