package com.example.OldButGold.controller;


import com.example.OldButGold.convertor.CurrencyConvertor;
import com.example.OldButGold.entity.Currency;
import com.example.OldButGold.request.CurrencyRequest;
import com.example.OldButGold.request.CurrencyResponse;
import com.example.OldButGold.service.CurrencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/currencies")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @Autowired
    CurrencyConvertor currencyConvertor;

    @PostMapping
    ResponseEntity<CurrencyResponse> save(@RequestBody @Valid CurrencyRequest currencyRequest) {
        Currency savedCurrency = currencyService.addCurrency(
                currencyConvertor.convertCurrency(currencyRequest));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(currencyConvertor.toCurrencyResponse(savedCurrency));
    }


    @GetMapping(path = "/all")
    ResponseEntity<Set<CurrencyResponse>> getAll() {
        Set<CurrencyResponse> currResp = new HashSet<>();
        Set<Currency> currencies = currencyService.findAll();

        for (Currency currency : currencies) {
            currResp.add(currencyConvertor.toCurrencyResponse(currency));
        }
        return ResponseEntity.status(HttpStatus.OK).body(currResp);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<CurrencyResponse> getCurrency(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(currencyConvertor.toCurrencyResponse(currencyService.findById(id)));
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        currencyService.deleteCurrency(id);
        return ResponseEntity.status(HttpStatus.OK).body("Currency deleted");
    }


}

