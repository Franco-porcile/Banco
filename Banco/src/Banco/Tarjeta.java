package Banco;

public class Tarjeta {
	public boolean tarjetaCredito;
	public boolean tarjetaDebito;
	private boolean realizarOperacion = false;
	public double cargo;
	public Tarjeta() {
		tarjetaCredito = false;
		tarjetaDebito = false;
	}
	private void altaTCredito() {
		tarjetaCredito = true;
		cargo = 0.3;
	}
	private void altaTDebito() {
		tarjetaDebito = true;
	}
	private double compraTCredito(double monto, double meses) {
		return (monto/meses) + monto*cargo;

	}
	private void compraTDebito() {
		
	}
}
