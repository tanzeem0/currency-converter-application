package com.springbootproject.currency.currency_converter.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import java.util.Objects;

@Configuration
public class RestConfig {

    Logger log = LoggerFactory.getLogger(RestConfig.class);

    @Value("${freecurrencyservice.base.url}")
    private String BASE_URL;

    @Value("${freecurrency.api.key}")
    private String API_KEY;
    @Bean
    RestClient getInstanceOfRestClient(){
        return RestClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader("apikey",API_KEY)
                .build();
    }

    @PostConstruct
    void checkForApiKey(){
        log.info("Key present: {}", Objects.nonNull(API_KEY));
    }
}
