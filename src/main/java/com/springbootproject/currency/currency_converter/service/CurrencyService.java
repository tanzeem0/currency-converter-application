package com.springbootproject.currency.currency_converter.service;

import com.springbootproject.currency.currency_converter.dto.CurrencyConvDTO;
import com.springbootproject.currency.currency_converter.dto.CurrencyDTO;
import com.springbootproject.currency.currency_converter.dto.StatusDTO;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyService {
    StatusDTO getStatusOfUsage();
    CurrencyDTO getAllCurrencyConversionsAvailable();
    CurrencyConvDTO getLatestCurrencyConversion(String fromCurrency, String toCurrency, BigDecimal units);

}
