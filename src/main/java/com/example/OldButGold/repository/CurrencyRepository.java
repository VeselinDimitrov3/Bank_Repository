package com.example.OldButGold.repository;

import com.example.OldButGold.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findByCurrencyCode(String currency);
}
