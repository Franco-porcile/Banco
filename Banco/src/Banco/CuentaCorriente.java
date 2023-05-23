package Banco;

import java.util.Map.Entry;

public class CuentaCorriente extends MiCuenta {
	private double descubierto;
	private double reservarSaldo = 0;
	protected TarjetaCredito miTarjetaC = new TarjetaCredito();
	public CuentaCorriente(String nombreCuenta, double descubierto) {
		super(nombreCuenta);
		this.descubierto = descubierto;
	}
	
	@Override
	protected void extraccion(double monto) {
		if (super.getSaldo() - reservarSaldo >= monto)
			super.extraccion(monto);
		else if ((super.getSaldo() - reservarSaldo
				+ ((super.getSaldo() - reservarSaldo) * descubierto) / 100) >= monto) {
			super.extraccion(getSaldo());
		} else
			throw new IllegalArgumentException("No es capaz de retirar ese dinero ni con el extra");
	}

	public void pagarConTarjeta(double monto, double cuotas) throws Exception {
		if (miTarjetaC.estado) {
			double aAcreditar = miTarjetaC.pagarConTarjeta(monto, cuotas);
			if (aAcreditar > super.getSaldo()) {
				throw new Exception(
						"No se permite pagar con tarjeta si el monto a acreditar es mayor al saldo disponible");
			}
			if (miTarjetaC.esFinDeMes()) {
				super.extraccion(aAcreditar);
				for (Entry<Double, Double> entry : miTarjetaC.compras.entrySet()) {
					Double precio = entry.getKey();
					Double cCuotas = entry.getValue();
					miTarjetaC.compras.put(precio, cCuotas - 1);
					if (cCuotas == 0)
						miTarjetaC.compras.remove(precio);
					miTarjetaC.setTerminaMes(false);
				}
			} else
				reservarSaldo = aAcreditar;

		}
	}

	@Override
	public String getNombreCuenta() {
		// TODO Auto-generated method stub
		return nombreCuenta;
	}

}
