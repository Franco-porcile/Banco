package Banco;


public class CuentaAhorro extends MiCuenta{
	private double Ahorro = 0;

	public CuentaAhorro(String nombreCuenta) {
		super(nombreCuenta);
	}

	protected void aAhorro(double monto) {
		if (super.getSaldo() >= monto) {
			super.extraccion(monto);
			Ahorro += monto;
		} else
			throw new IllegalArgumentException("No posee esa cantidad para poner en caja de ahorro");
	}

	protected void reintegro(double monto) {
		if (Ahorro >= monto) {
			Ahorro -= monto;
			super.depositar(monto);
		} else
			throw new IllegalArgumentException("No posee esa cantidad para reintegrar");
	}

	@Override
	public String getNombreCuenta() {
		// TODO Auto-generated method stub
		return this.nombreCuenta;
	}

}
