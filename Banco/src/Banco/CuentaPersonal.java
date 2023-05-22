package Banco;



public class CuentaPersonal extends MiCuenta{
	public CuentaPersonal(String nombreCuenta) {
		super(nombreCuenta);
	}

	@Override
	public String getNombreCuenta() {
		// TODO Auto-generated method stub
		return nombreCuenta;
	}
	
}
