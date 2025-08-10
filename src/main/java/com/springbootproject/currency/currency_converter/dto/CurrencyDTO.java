package com.springbootproject.currency.currency_converter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyDTO {
    private Map<String,CurrencyDetail> data;
    @Data @NoArgsConstructor @AllArgsConstructor
        public static class CurrencyDetail {
            private String symbol;
            private String name;
            private String code;
        }

}


