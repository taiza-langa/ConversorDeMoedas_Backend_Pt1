package com.example.conversor_moeda;

import com.example.conversor_moeda.dto.ConversaoResponseDTO;
import com.example.conversor_moeda.CurrencyService;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/cambio")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/converter")
    public ConversaoResponseDTO converter(@RequestParam String de, @RequestParam String para,
            @RequestParam double valor) {
        double taxa = currencyService.obterTaxaCambio(de.toUpperCase(), para.toUpperCase());
        double convertido = valor * taxa;

        return new ConversaoResponseDTO(de.toUpperCase(), para.toUpperCase(), valor, convertido, taxa);
    }
}