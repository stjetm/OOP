package Cajero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CajeroGUI extends JFrame {
    private CuentaBancaria cuenta;

    public CajeroGUI() {
        cuenta = new CuentaBancaria();
        setTitle("BANCOOP - Cajero Automático");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

JLabel bienvenida = new JLabel("<html>Bienvenido al módulo de autoservicio de BANCOOP<br>Seleccione la operación que desea realizar:</html>", SwingConstants.CENTER);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnConsultar = new JButton("Consultar Saldo");
        JButton btnDepositar = new JButton("Depositar");
        JButton btnRetirar = new JButton("Retirar");

        btnConsultar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Su saldo actual es: $" + cuenta.getSaldo(),
                "Consulta de Saldo",
                JOptionPane.INFORMATION_MESSAGE);
        });

        btnDepositar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Ingrese el monto a depositar:");
            if (input != null) {
                double monto = Double.parseDouble(input);
                cuenta.depositar(monto);
                JOptionPane.showMessageDialog(this, "Depósito exitoso.");
            }
        });

        btnRetirar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Ingrese el monto a retirar:");
            if (input != null) {
                double monto = Double.parseDouble(input);
                if (cuenta.retirar(monto)) {
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
