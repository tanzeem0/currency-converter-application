package com.springbootproject.currency.currency_converter;

import com.springbootproject.currency.currency_converter.dto.StatusDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

@SpringBootTest
class CurrencyConverterApplicationTests {

	@Autowired
	private RestClient restClient;

	@Test
	void contextLoads() {
	}
	@Test
	void checkForRestConfig(){
		StatusDTO statusDTO = restClient.get()
				.uri("status")
				.retrieve()
				.body(new ParameterizedTypeReference<>() {
				});
        System.out.println(statusDTO);
	}
}
