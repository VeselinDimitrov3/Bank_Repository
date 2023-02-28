package com.example.OldButGold.impl;

import com.example.OldButGold.trnutil.TrnUtil;
import com.example.OldButGold.convertor.TransactionConvertor;
import com.example.OldButGold.entity.Client;
import com.example.OldButGold.entity.Currency;
import com.example.OldButGold.entity.Transaction;
import com.example.OldButGold.exception.RecordNotFoundException;
import com.example.OldButGold.repository.TransactionRepository;
import com.example.OldButGold.request.TransactionRequest;
import com.example.OldButGold.request.TransactionResponse;
import com.example.OldButGold.service.ClientService;
import com.example.OldButGold.service.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class TransactionImpl implements TransactionService {

    private final ClientService clientService;
    private final TransactionConvertor convertor;
    private final CurrencyImpl currencyService;
    private final TransactionRepository transactionRepository;

    public TransactionImpl (ClientService clientService, TransactionConvertor convertor, CurrencyImpl currencyService, TransactionRepository transactionRepository ) {
        this.clientService = clientService;
        this.convertor = convertor;
        this.currencyService = currencyService;
        this.transactionRepository = transactionRepository;
    }


    @Transactional
    @Override
    public TransactionResponse performTransaction(TransactionRequest trnRequest) throws RecordNotFoundException {
        Client sender = clientService.findByEmail(trnRequest.getSourceEmail());
        Client receiver = clientService.findByEmail(trnRequest.getDestinationEmail());

        if (TrnUtil.compareAmounts(sender.getBalance(), trnRequest.getAmount())) {
            sender.setBalance(BigDecimal.valueOf(sender.getBalance().doubleValue() - trnRequest.getAmount()));
            receiver.setBalance(BigDecimal.valueOf(receiver.getBalance().doubleValue() + trnRequest.getAmount()));
        }
        Currency trnCurrency = currencyService.findByName(trnRequest.getCurrency().getCurrencyName());
        Transaction trn = convertor.toTransaction(sender, receiver, trnCurrency, new BigDecimal(trnRequest.getAmount()), trnRequest.getReason());
        transactionRepository.save(trn);
        return new TransactionResponse(String.format("Transaction to %s was executed successfully", receiver.getEmail()));

    }
}
