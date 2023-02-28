package com.example.OldButGold.service;

import com.example.OldButGold.entity.Currency;
import com.example.OldButGold.entity.Transaction;
import com.example.OldButGold.exception.RecordNotFoundException;
import com.example.OldButGold.request.TransactionRequest;
import com.example.OldButGold.request.TransactionResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface TransactionService {

    TransactionResponse performTransaction(TransactionRequest trnRequest) throws RecordNotFoundException;

}
