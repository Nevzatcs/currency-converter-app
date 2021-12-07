package com.convert.currencyconverter.controller;

import com.convert.currencyconverter.repository.CurrencyRepository;
import com.convert.currencyconverter.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CurrencyConverterWebController {

    private final CurrencyRepository repository;
    private final CurrencyService currencyService;

    @GetMapping("/")
    public String serveWebPage() {
        return "index";
    }

// @GetMapping("/index")
// public String serveWebPage(Model theModel){
//     ConversionCurrency conversionCurrency = new ConversionCurrency("AUD","TRY",10);
//     theModel.addAttribute("currencies",repository.findAllByOrderByNameAsc());
//     theModel.addAttribute("value", conversionCurrency);
//
//     return "index";
// }




}
