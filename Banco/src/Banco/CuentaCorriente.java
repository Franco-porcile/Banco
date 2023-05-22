package Banco;

public class CuentaCorriente extends MiCuenta{
	private double descubierto;
	public CuentaCorriente(String nombreCuenta, double descubierto) {
		super(nombreCuenta);
		this.descubierto = descubierto;
	}
	@Override
	protected void extraccion(double monto) {
		if(super.getSaldo() >= monto) 
			super.extraccion(monto);
		else if((super.getSaldo() + (super.getSaldo()*descubierto)/100) >= monto) {
			super.extraccion(getSaldo());
		}
		else 
			throw new IllegalArgumentException("No es capaz de retirar ese dinero ni con el extra");
	}

	@Override
	public String getNombreCuenta() {
		// TODO Auto-generated method stub
		return nombreCuenta;
	}
	
}
