package Banco;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CuentaPersonal cuentaPersonal = new CuentaPersonal("Juan Perez");
        CuentaCorriente cuentaCorriente = new CuentaCorriente("Maria Sanchez", 2000);
        CuentaAhorro cuentaAhorro = new CuentaAhorro("Carlos Gomez");
        PlazoFijo plazoFijo = new PlazoFijo();

        cuentaPersonal.depositar(500);
        cuentaPersonal.extraccion(200);

        cuentaCorriente.depositar(1000);
        cuentaCorriente.extraccion(500);

        cuentaAhorro.depositar(2000);
        cuentaAhorro.extraccion(1000);

        /*cuentaAhorro.pedirPlazoFijo("Ana Rodriguez", 5000, 3);
        plazoFijo.mostrarPlazosFijos();

        plazoFijo.retirarPlazoFijo("Ana Rodriguez");

        Tarjeta tarjeta = new Tarjeta();
        tarjeta.obtenerTarjeta("1234567890");
        tarjeta.pagarTarjeta();

        TarjetaCredito tarjetaCredito = new TarjetaCredito();
        tarjetaCredito.obtenerTarjeta("0987654321");
        tarjetaCredito.pagarTarjeta();

        cuentaPersonal.mostrarInformacion();
        cuentaCorriente.mostrarInformacion();
        cuentaAhorro.mostrarInformacion();
	*/
	}

}
