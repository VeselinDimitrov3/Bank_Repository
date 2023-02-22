package com.example.OldButGold.repository;

import com.example.OldButGold.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByCurrencyCode(String currencyCode);
}
