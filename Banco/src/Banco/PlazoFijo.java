package Banco;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.util.Map.Entry;

public class PlazoFijo {

	private Map<Integer, miPlazoFijo> plazosFijos;
	private int count = 0 ;
	public PlazoFijo() {
		plazosFijos = new HashMap<>();
	}

	public void pedirPlazoFijo(double monto, double interes) {
		miPlazoFijo grupo = new miPlazoFijo(monto,interes);
		plazosFijos.put(count, grupo);
		count++;
	}
	public void mostrarPlazosFijos() {
		for(Entry<Integer,miPlazoFijo>entry : plazosFijos.entrySet()) {
			System.out.println(entry.getKey()+" "+ entry.getValue().now+" "+entry.getValue().monto+" "+entry.getValue().interes);
		}
	}
	public double retirarPlazoFijo(int num) {
		miPlazoFijo retiro =plazosFijos.get(num);
		LocalDate fecha = LocalDate.now();
		int cant = 0; 
		int años = fecha.getYear() - retiro.now.getYear();
		int meses = fecha.getMonthValue()-retiro.now.getMonthValue();
		int dias = fecha.getDayOfMonth() - retiro.now.getDayOfMonth();
		if(dias < 0) {
			meses--;
		}
		if(meses < 0) {
			años --;
			meses += 12;
		}
		cant = 12 * años + meses;
		plazosFijos.remove(num);
		return retiro.monto + (retiro.monto * ((retiro.interes)/100))*cant;
	}
	private static class miPlazoFijo {
		private LocalDate now;
		private double monto;
		private double interes;

		private miPlazoFijo(double monto, double interes) {
			this.now = LocalDate.now();
			this.monto = monto;
			this.interes = interes;
		}
	}
}