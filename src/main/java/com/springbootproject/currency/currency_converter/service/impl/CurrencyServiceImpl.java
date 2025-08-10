package com.springbootproject.currency.currency_converter.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.springbootproject.currency.currency_converter.dto.CurrencyConvDTO;
import com.springbootproject.currency.currency_converter.dto.CurrencyDTO;
import com.springbootproject.currency.currency_converter.dto.StatusDTO;
import com.springbootproject.currency.currency_converter.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final RestClient restClient;

    @Override
    public StatusDTO getStatusOfUsage() {
        try {
            return restClient.get()
                    .uri("status")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CurrencyDTO getAllCurrencyConversionsAvailable() {
        try{
            CurrencyDTO currencyDTO = restClient.get()
                    .uri("currencies")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return currencyDTO;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CurrencyConvDTO getLatestCurrencyConversion(String fromCurrency, String toCurrency,BigDecimal units) {
        JsonNode rootNode = restClient.get()
                .uri(uriBuilder -> uriBuilder.path("latest")
                        .queryParam("base_currency",fromCurrency)
                        .queryParam("currencies",toCurrency).build())
                .retrieve()
                .body(JsonNode.class);
        BigDecimal toCurrencyExcRate = rootNode.path("data").path(toCurrency).decimalValue();
        return CurrencyConvDTO.builder()
                .baseCurrency(fromCurrency)
                .toCurrency(toCurrency)
                .baseCurrencyUnits(units)
                .toCurrencyUnits(toCurrencyExcRate.multiply(units))
                .build();
    }
}
