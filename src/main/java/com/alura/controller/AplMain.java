package com.alura.controller;

import com.alura.model.CurrencyConverter;
import com.alura.view.View;

public class AplMain {
    public static void main(String[] args) {
        // Configura tu propia URL completa de API (que incluye la clave API)
        String apiUrl = "https://v6.exchangerate-api.com/v6/121e522b7a5c836bd5c6fe8a"; // Reemplaza con tu URL real de API
        
        View view = new View();
        CurrencyConverter model = new CurrencyConverter(apiUrl);
        new Controller(view, model);

        view.setVisible(true);
    }
}
