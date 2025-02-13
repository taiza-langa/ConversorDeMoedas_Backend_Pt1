package com.example.conversor_moeda.dto;

public class ConversaoResponseDTO {
    private String moedaOrigem;
    private String moedaDestino;
    private double valorOriginal;
    private double valorConvertido;
    private double taxaCambio;

    public ConversaoResponseDTO(String moedaOrigem, String moedaDestino, double valorOriginal, double valorConvertido,
            double taxaCambio) {
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        this.valorOriginal = valorOriginal;
        this.valorConvertido = valorConvertido;
        this.taxaCambio = taxaCambio;
    }

    public String getMoedaOrigem() {
        return moedaOrigem;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public double getTaxaCambio() {
        return taxaCambio;
    }
}