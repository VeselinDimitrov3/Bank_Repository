package com.example.OldButGold.service;

import com.example.OldButGold.entity.Currency;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface CurrencyService {
    Currency addCurrency(Currency currency);
    void deleteCurrency(Long id);
    Currency findByName(String name);
    Currency findById(Long id);
    Set<Currency> findAll();
}
