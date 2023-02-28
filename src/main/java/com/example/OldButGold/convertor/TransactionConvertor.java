package com.example.OldButGold.convertor;

import com.example.OldButGold.entity.Client;
import com.example.OldButGold.entity.Currency;
import com.example.OldButGold.entity.Transaction;
import com.example.OldButGold.impl.TransactionImpl;
import com.example.OldButGold.request.TransactionRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
@Component
public class TransactionConvertor {

    public Transaction toTransaction(Client sender, Client receiver, Currency currency, BigDecimal amount, String reason){
        return Transaction.builder()
                .sender(sender)
                .receiver(receiver)
                .currency(currency)
                .reason(reason)
                .date(Instant.now())
                .amount(amount)
                .build();
    }

}
