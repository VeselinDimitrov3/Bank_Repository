package com.example.OldButGold.impl;

import com.example.OldButGold.entity.Currency;
import com.example.OldButGold.exception.RecordNotFoundException;
import com.example.OldButGold.repository.CurrencyRepository;
import com.example.OldButGold.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
    public Currency findByName(String currency) {
        return currencyRepository.findByCurrencyCode(currency)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Currency with id %s not found", id)));
    }

    @Override
    public Currency findById(Long id) {
        return currencyRepository.findById(id).orElseThrow(()
                -> new RecordNotFoundException(String.format("Currency with id %s not found" + id)));
    }

    @Override
    public Set<Currency> findAll() {
        return new HashSet<>(currencyRepository.findAll());
    }
}
