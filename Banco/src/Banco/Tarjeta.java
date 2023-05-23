package Banco;

abstract class Tarjeta {
	public boolean estado;

	protected int tipo;
	public Tarjeta() {
		this.estado = false;	
	}
	public void darAlta() {
		this.estado = true;
	}

}