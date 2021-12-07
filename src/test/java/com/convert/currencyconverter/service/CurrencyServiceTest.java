package com.convert.currencyconverter.service;

import com.convert.currencyconverter.model.ConversionCurrency;
import com.convert.currencyconverter.model.Currency;
import com.convert.currencyconverter.repository.CurrencyRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CurrencyServiceTest {

    @Mock
    private CurrencyRepository mockCurrencyRepository;
    @InjectMocks
    private CurrencyService currencyService;




    @Test
    void getAllCurrencies() {
        //given
        Currency TRY = new Currency("TRY", 13.35);
        Currency USD = new Currency("USD", 1.12);
        Currency AED = new Currency("AED", 4.14);
        List<Currency> list=new ArrayList<>();
        list.add(AED);
        list.add(TRY);
        list.add(USD);

        Mockito.when(mockCurrencyRepository.findAllByOrderByNameAsc()).thenReturn(list);
        //when
        List<Currency> expected = currencyService.getAllCurrencies();

        //then
        assertEquals(expected.get(0).getName(), AED.getName());
        assertEquals(expected.get(1).getName(), TRY.getName());
        assertEquals(expected.get(2).getName(), USD.getName());


    }

    @Test
    void getAllCurrenciesEmpty() {
        //given

        Mockito.when(mockCurrencyRepository.findAllByOrderByNameAsc()).thenReturn(Arrays.asList());

        //when
        List<Currency> expected = currencyService.getAllCurrencies();

        //then
        assertTrue(expected.isEmpty());



    }

    @Test
    void convertShouldBeReturnEmptyWhenNegativeValue() {
        Currency TRY = new Currency("TRY", 13.35);
        Currency USD = new Currency("USD", 1.12);

        Mockito.when(mockCurrencyRepository.findById("TRY")).thenReturn(Optional.of(TRY));
        Mockito.when(mockCurrencyRepository.findById("USD")).thenReturn(Optional.of(USD));

        ConversionCurrency conversionCurrency = new ConversionCurrency("TRY", "USD", -1);

        Optional<Double> result = currencyService.convert(conversionCurrency);

        assertNotNull(result);
        assertFalse(result.isPresent());


    }

    @Test
    void convertShouldReturnEmptyWhenCurrencyDoesNotExist() {
        Currency TRY = new Currency("TRY", 13.35);
        Currency USD = new Currency("USD", 1.12);

        Mockito.when(mockCurrencyRepository.findById("TRY")).thenReturn(Optional.of(TRY));
        Mockito.when(mockCurrencyRepository.findById("USD")).thenReturn(Optional.empty());

        ConversionCurrency conversionCurrency = new ConversionCurrency("USD", "TRY",0 );

        Optional<Double> result = currencyService.convert(conversionCurrency);

        assertNotNull(result);
        assertFalse(result.isPresent());




    }

    @Test
    void convertShouldReturnValueWhenCurrencyDoesNotExist() {
        Currency TRY = new Currency("TRY", 13.35);
        Currency USD = new Currency("USD", 1.12);

        Mockito.when(mockCurrencyRepository.findById("TRY")).thenReturn(Optional.of(TRY));
        Mockito.when(mockCurrencyRepository.findById("USD")).thenReturn(Optional.of(USD));

        ConversionCurrency conversionCurrency = new ConversionCurrency("TRY", "USD", 1);

        Optional<Double> result = currencyService.convert(conversionCurrency);

        assertTrue(result.isPresent());
        assertEquals(11.92, result.get());

    }
}