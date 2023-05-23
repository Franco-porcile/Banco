package Banco;

import java.util.HashMap;
import java.util.Map;

public class TarjetaCredito extends Tarjeta {
	private double aAcreditar;
	public boolean terminaMes;
	public Map<Double, Double> compras = new HashMap<>();
	public double cargo = 0.03;

	public TarjetaCredito() {
		super();
		terminaMes = false;
		aAcreditar = 0;
		this.tipo = 0;
	}

	public double pagarConTarjeta(double monto, double cuotas){
		double total = (monto / cuotas) + (monto / cuotas) * this.cargo;
		compras.put(total, cuotas);
		for (Double valor : compras.values()) {
			aAcreditar += valor;
		}
		return aAcreditar;

	}

	public boolean esFinDeMes() {
		return terminaMes;
	}

	public void setTerminaMes(boolean terminaMes) {
		this.terminaMes = terminaMes;
	}

}
