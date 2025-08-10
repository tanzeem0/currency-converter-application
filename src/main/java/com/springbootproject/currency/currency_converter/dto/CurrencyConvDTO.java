package com.springbootproject.currency.currency_converter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyConvDTO {
    private String baseCurrency;
    private String toCurrency;
    private BigDecimal baseCurrencyUnits;
    private BigDecimal toCurrencyUnits;
}
