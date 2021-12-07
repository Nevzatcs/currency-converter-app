package com.convert.currencyconverter.controller;

import com.convert.currencyconverter.model.ConversionCurrency;
import com.convert.currencyconverter.model.Currency;
import com.convert.currencyconverter.repository.CurrencyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application.properties")

public class IntegrationTest {

    private RestTemplate restTemplate;

    @Mock
    private CurrencyRepository mockCurrencyRepository;


    private String basePath = "http://localhost:8080";

    @Before
    public void setup(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void convertShouldBeSuccessful(){
        Currency EUR = new Currency("EUR", 1);
        Currency USD = new Currency("USD", 1.12);

        Mockito.when(mockCurrencyRepository.findById("EUR")).thenReturn(Optional.of(EUR));
        Mockito.when(mockCurrencyRepository.findById("USD")).thenReturn(Optional.of(USD));

        ConversionCurrency conversionCurrency = new ConversionCurrency("USD","EUR",1);
        ResponseEntity<Double> responseEntity = restTemplate.postForEntity(basePath + "/currency-converter",
                conversionCurrency, Double.class);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);




    }


}
