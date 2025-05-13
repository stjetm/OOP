package Cajero;

import javax.swing.*;
import java.awt.*;

public class CajeroGUI extends JFrame {
    private SesionCajero sesion;

    public CajeroGUI() {
        CuentaBancaria cuenta = new CuentaBancaria();
        sesion = new SesionCajero(cuenta);

        setTitle("BANCOOP - Cajero Automático");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel bienvenida = new JLabel(
            "<html>Bienvenido al módulo de autoservicio de BANCOOP<br>Seleccione una operación:</html>",
            SwingConstants.CENTER
        );
        bienvenida.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnConsultar = new JButton("Consultar Saldo");
        JButton btnDepositar = new JButton("Depositar");
        JButton btnRetirar = new JButton("Retirar");

        btnConsultar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Su saldo actual es: $" + sesion.consultarSaldo(),
                "Consulta de Saldo",
                JOptionPane.INFORMATION_MESSAGE);
        });

        btnDepositar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Ingrese el monto a depositar:");
            if (input != null) {
                double monto = Double.parseDouble(input);
                sesion.depositar(monto);
                JOptionPane.showMessageDialog(this, "Depósito exitoso.");
            }
        });

        btnRetirar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Ingrese el monto a retirar:");
            if (input != null) {
                double monto = Double.parseDouble(input);
                if (sesion.retirar(monto)) {
                    JOptionPane.showMessageDialog(this, "Retiro exitoso.");
                } else {
                    JOptionPane.showMessageDialog(this, "Fondos insuficientes o monto inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(bienvenida);
        panel.add(btnConsultar);
        panel.add(btnDepositar);
        panel.add(btnRetirar);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panel);
        setVisible(true);
    }
}
