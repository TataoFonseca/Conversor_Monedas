package com.alura.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {
    private String apiUrl;

    public CurrencyConverter(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            //Aqui va la URL con clave API y el monto a convertir
            String url = apiUrl + "/pair/" + fromCurrency + "/" + toCurrency + "/" + amount;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseResponse(response.body(), amount);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private double parseResponse(String responseBody, double amount) {
        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();

        // Verifica si la respuesta indica éxito
        if (jsonObject.has("result") && jsonObject.get("result").getAsString().equals("success")) {
            // Extrae la tasa de conversión
            if (jsonObject.has("conversion_rate")) {
                double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
                // Calcula el monto convertido
                double convertedAmount = amount * conversionRate;
                return convertedAmount;
            } else {
                System.err.println("Error: 'conversion_rate' no está presente en la respuesta JSON.");
                return 0.0; // Manejo de error o valor por defecto según tu lógica
            }
        } else {
            System.err.println("Error: La solicitud no fue exitosa según la respuesta JSON.");
            return 0.0; // Manejo de error o valor por defecto según tu lógica
        }
    }

}
