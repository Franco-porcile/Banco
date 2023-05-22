package Banco;

public class Main {
    public static void main(String[] args) {
        // Crear cuentas
        CuentaAhorro cuentaAhorro = new CuentaAhorro("Cuenta de Ahorro");
        CuentaCorriente cuentaCorriente = new CuentaCorriente("Cuenta Corriente", 1000);
        CuentaPersonal cuentaPersonal = new CuentaPersonal("Cuenta Personal");

        // Realizar operaciones en la cuenta de ahorro
        cuentaAhorro.depositar(1000);
        cuentaAhorro.aAhorro(500);
        System.out.println("Saldo en cuenta de ahorro: " + cuentaAhorro.getSaldo());
        cuentaAhorro.reintegro(200);
        System.out.println("Saldo en cuenta de ahorro después del reintegro: " + cuentaAhorro.getSaldo());

        // Realizar operaciones en la cuenta corriente
        cuentaCorriente.depositar(2000);
        cuentaCorriente.extraccion(1500);
        System.out.println("Saldo en cuenta corriente: " + cuentaCorriente.getSaldo());

        // Realizar operaciones en la cuenta personal
        cuentaPersonal.depositar(3000);
        System.out.println("Saldo en cuenta personal: " + cuentaPersonal.getSaldo());

        // Transferencia entre cuentas
        cuentaAhorro.transferir(100, cuentaCorriente);
        System.out.println("Saldo en cuenta de ahorro después de la transferencia: " + cuentaAhorro.getSaldo());
        System.out.println("Saldo en cuenta corriente después de la transferencia: " + cuentaCorriente.getSaldo());
    }
}
