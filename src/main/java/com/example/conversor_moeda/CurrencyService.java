package com.example.conversor_moeda;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class CurrencyService {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public double obterTaxaCambio(String moedaOrigem, String moedaDestino) {
        try {
            // Constrói a URL com a moeda de origem
            String url = API_URL + moedaOrigem;
            RestTemplate restTemplate = new RestTemplate();
            String respostaJson = restTemplate.getForObject(url, String.class);

            if (respostaJson != null) {
                JSONObject json = new JSONObject(respostaJson);
                return json.getJSONObject("rates").getDouble(moedaDestino); // Pega a taxa de origem para destino
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Erro ao obter taxa de câmbio.");
    }

    public double converterMoeda(String moedaOrigem, String moedaDestino, double valor) {
        double taxa = obterTaxaCambio(moedaOrigem, moedaDestino);
        return valor * taxa;
    }
}