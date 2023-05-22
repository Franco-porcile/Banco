package Banco;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.FileWriter;
public abstract class MiCuenta {
	protected String nombreCuenta;
	private double saldo = 0;
	protected double retiros = 0;
	protected Tarjeta miTarjeta = new Tarjeta();
	
    public MiCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

	protected void depositar (double deposito) {
		if(deposito>0) 
			this.saldo += deposito;
			agregarTransaccion("Se realizo un deposito a la cuenta", deposito);
	}
	protected void extraccion (double monto) {
		if(monto >0) {
			if (monto <= this.saldo)
				this.saldo -= monto;
				agregarTransaccion("Se realizo una extraccion de la cuenta " + nombreCuenta, monto);

		}
		else
			throw new IllegalArgumentException("No se puede retirar 0 pesos");
	}
	protected void transferir(double monto, MiCuenta cuentaDestino) {
		if(this.saldo >= monto){
			this.saldo -= monto;
			cuentaDestino.depositar(monto);
			
		}
		else
			throw new IllegalArgumentException("No es posible transferir ese monto desde " + this.nombreCuenta);
	}
	protected void agregarTransaccion(String Asunto, double Monto) {
		try {
			PrintWriter Transacciones = new PrintWriter(new FileWriter(nombreCuenta+" Transacciones.txt",true));
			LocalDateTime ahora = LocalDateTime.now();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String fechaformateada = ahora.format(formato);
			Transacciones.println(fechaformateada+ " " + Asunto +": "+Monto);
			Transacciones.close();
					
		}catch(IOException e) {
			System.out.println("Error al escribir en el archivo de transacciones: " + e.getMessage());
		}
	}

	protected double getSaldo() {
		return this.saldo;
	}
	protected double getRetiros() {
		return this.retiros;
	}
	public abstract String getNombreCuenta();
}
