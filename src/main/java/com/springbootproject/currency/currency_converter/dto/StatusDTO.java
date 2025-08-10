package com.springbootproject.currency.currency_converter.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatusDTO {
    private Quotas quotas;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Quotas {
        private MonthDTO month;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class MonthDTO {
        private Integer total;
        private Integer used;
        private Integer remaining;
    }
}
