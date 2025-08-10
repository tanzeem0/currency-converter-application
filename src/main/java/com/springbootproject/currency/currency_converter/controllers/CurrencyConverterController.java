package com.springbootproject.currency.currency_converter.controllers;

import com.springbootproject.currency.currency_converter.dto.CurrencyConvDTO;
import com.springbootproject.currency.currency_converter.dto.CurrencyDTO;
import com.springbootproject.currency.currency_converter.dto.StatusDTO;
import com.springbootproject.currency.currency_converter.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "convertCurrency")
@RequiredArgsConstructor
public class CurrencyConverterController {

    private final CurrencyService currencyService;

    @GetMapping(path = "/status")
    public ResponseEntity<StatusDTO> getStatusOfRemainingCheck(){
        return ResponseEntity.ok(currencyService.getStatusOfUsage());
    }
    @GetMapping(path = "/currencies")
    public ResponseEntity<CurrencyDTO> getAllAvailableCurrencies(){
        return ResponseEntity.ok(currencyService.getAllCurrencyConversionsAvailable());
    }

    @GetMapping(path = "/latestConversionRate")
    public ResponseEntity<CurrencyConvDTO> getLatestConversionRate(@RequestParam String fromCurrency,
                                                                   @RequestParam String toCurrency,
                                                                   @RequestParam BigDecimal units)
    {
        return ResponseEntity.ok(currencyService.getLatestCurrencyConversion(fromCurrency, toCurrency, units));
    }

}
