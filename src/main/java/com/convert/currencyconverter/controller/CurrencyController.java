package com.convert.currencyconverter.controller;

import com.convert.currencyconverter.model.ConversionCurrency;
import com.convert.currencyconverter.service.CurrencyService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Currency;
import java.util.Optional;


@RestController
@RequestMapping()
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currencies")
    public ResponseEntity<Currency> convertCurrency(){
        return new ResponseEntity(this.currencyService.getAllCurrencies(), HttpStatus.OK);

    }


// @PostMapping(path = "/currency-converter", consumes = "application/json")
// //@RequestMapping(value = "/currency-converter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
// public ResponseEntity<Double> convertCurrency(@RequestBody @JsonProperty ConversionCurrency conversionCurrency){
//     Optional<Double> result = currencyService.convert(conversionCurrency);
//     if (result.isPresent()) {
//         return new ResponseEntity<>(result.get(), HttpStatus.OK);
//     }
//     return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
// }

    @PostMapping(path = "/currency-converter", consumes = "application/json")
    //@RequestMapping(value = "/currency-converter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Double> convertCurrency( @JsonProperty @RequestBody ConversionCurrency conversionCurrency){
        Optional<Double> result = currencyService.convert(conversionCurrency);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }


}
