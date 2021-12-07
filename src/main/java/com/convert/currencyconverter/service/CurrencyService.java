package com.convert.currencyconverter.service;

import com.convert.currencyconverter.model.ConversionCurrency;
import com.convert.currencyconverter.model.Currency;
import com.convert.currencyconverter.repository.CurrencyRepository;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

     private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAllByOrderByNameAsc();
    }

    public Optional<Double> convert(ConversionCurrency conversionCurrency) {
       Optional<Currency> toOptional = currencyRepository.findById(conversionCurrency.getTo().toUpperCase());
       Optional<Currency> fromOptional =currencyRepository.findById(conversionCurrency.getFrom().toUpperCase());

       if(toOptional.isPresent() && fromOptional.isPresent()){
           if(conversionCurrency.getValue() < 0){
               return Optional.empty();
           }
           Currency to = toOptional.get();
           Currency from = fromOptional.get();
           Double toValue = to.getValueInEuros();
           Double fromValue = from.getValueInEuros();

           Double result = toValue * (conversionCurrency.getValue() / fromValue);

           return Optional.of(Precision.round(result,2));
       }
       return Optional.empty();
    }
}
