package Cajero;
public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria() {
        this.saldo = 0.0;
    }

    // Getter para saldo
    public double getSaldo() {
        return saldo;
    }

    // Setter para saldo (aunque no se usará directamente)
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método para depositar dinero
    public void depositar(double monto) {
        if (monto > 0) {
            setSaldo(getSaldo() + monto); // Usamos getters y setters
        }
    }

    // Método para retirar dinero
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= getSaldo()) {
            setSaldo(getSaldo() - monto); // Usamos getters y setters
            return true;
        }
        return false;
    }
}
