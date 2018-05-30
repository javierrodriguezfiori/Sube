package datos;

public class TarjetaSube {
	private long nroTarjeta;
	private int idUsuario;
	private float saldo;
	private int estado;
	private RedSube redSube;
	
	public TarjetaSube() {
		super();
	}

	public TarjetaSube(int idUsuario, float saldo, int estado) {
		super();
		this.idUsuario = idUsuario;
		this.saldo = saldo;
		this.estado = estado;
	}

	public long getNroTarjeta() {
		return nroTarjeta;
	}

	protected void setNroTarjeta(long nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
		return "TarjetaSube [nroTarjeta=" + nroTarjeta + ", idUsuario=" + idUsuario + ", saldo=" + saldo
				+ ", estado=" + estado + "]";
	}
	
}
