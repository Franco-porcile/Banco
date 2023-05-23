package Banco;



public class CuentaPersonal extends MiCuenta{
	public CuentaPersonal(String nombreCuenta) {
		super(nombreCuenta);
	}
	public void pagarConTarjetaD(double monto) {
		if(miTarjetaD.estado)
			this.extraccion(monto);
	}
	@Override
	public String getNombreCuenta() {
		// TODO Auto-generated method stub
		return nombreCuenta;
	}
	
}
