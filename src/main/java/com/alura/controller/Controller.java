package com.alura.controller;

import com.alura.model.CurrencyConverter;
import com.alura.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private CurrencyConverter model;

    public Controller(View view, CurrencyConverter model) { //Constructor, inicializa clases view, model y boton 
        this.view = view;
        this.model = model;

        this.view.addConvertListener(new ConvertListener());
    }

    class ConvertListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String fromCurrency = view.getFromCurrency();
            String toCurrency = view.getToCurrency();
            double amount = view.getAmount();

            double result = model.convert(fromCurrency, toCurrency, amount);
            view.setResult(String.valueOf(result));
        }
    }
}
