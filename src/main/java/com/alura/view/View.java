package com.alura.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View extends JFrame {
    private JTextField fromCurrencyField = new JTextField(3);
    private JTextField toCurrencyField = new JTextField(3);
    private JTextField amountField = new JTextField(10);
    private JButton convertButton = new JButton("Convert");
    private JLabel resultLabel = new JLabel("Result:");

    public View() {
        this.setLayout(null); // Usar layout nulo para posicionar por coordenadas

        JLabel fromLabel = new JLabel("Convertir:");
        fromLabel.setBounds(20, 20, 80, 25);
        this.add(fromLabel);

        fromCurrencyField.setToolTipText("divisa requerida");
        fromCurrencyField.setBounds(100, 20, 100, 25);
        fromCurrencyField.addKeyListener(new UppercaseKeyAdapter());
        this.add(fromCurrencyField);

        JLabel toLabel = new JLabel("a:");
        toLabel.setBounds(20, 60, 80, 25);
        this.add(toLabel);

        toCurrencyField.setToolTipText("divisa requerida");
        toCurrencyField.setBounds(100, 60, 100, 25);
        toCurrencyField.addKeyListener(new UppercaseKeyAdapter());
        this.add(toCurrencyField);

        JLabel amountLabel = new JLabel("Cantidad:");
        amountLabel.setBounds(20, 100, 80, 25);
        this.add(amountLabel);

        amountField.setBounds(100, 100, 100, 25);
        amountField.addKeyListener(new UppercaseKeyAdapter());
        this.add(amountField);

        convertButton.setBounds(20, 140, 100, 25);
        this.add(convertButton);

        resultLabel.setBounds(20, 180, 200, 25);
        this.add(resultLabel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        this.setVisible(true);
    }

    public String getFromCurrency() {
        return fromCurrencyField.getText();
    }

    public String getToCurrency() {
        return toCurrencyField.getText();
    }

    public double getAmount() {
        return Double.parseDouble(amountField.getText());
    }

    public void setResult(String result) {
        resultLabel.setText("Result: " + result);
    }

    public void addConvertListener(ActionListener listener) {
        convertButton.addActionListener(listener);
    }

    private class UppercaseKeyAdapter extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (Character.isLowerCase(c)) {
                e.setKeyChar(Character.toUpperCase(c));
            }
        }
    }
}
