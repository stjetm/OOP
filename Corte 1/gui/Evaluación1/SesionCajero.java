package Cajero;
public class SesionCajero {
    private CuentaBancaria cuenta;

    public SesionCajero(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public double consultarSaldo() {
        return cuenta.getSaldo();
    }

    public void depositar(double monto) {
        if (monto > 0) {
            cuenta.setSaldo(cuenta.getSaldo() + monto);
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= cuenta.getSaldo()) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            return true;
        }
        return false;
    }
}
