package com.example.OldButGold.impl;

import com.example.OldButGold.entity.Currency;
import com.example.OldButGold.repository.CurrencyRepository;
import com.example.OldButGold.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CurrencyImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency addCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public void deleteCurrency(Long id) {
        currencyRepository.deleteById(id);
    }

    @Override
    public Currency findByName(String name) {
        return currencyRepository.findByCurrencyCode(name);
    }

    @Override
    public Currency findById(Long id) {
        return currencyRepository.findById(id).orElseThrow();
    }

    @Override
    public Set<Currency> findAll() {
        return currencyRepository.findAll().stream().collect(Collectors.toSet());
    }
}
