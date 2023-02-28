package com.example.OldButGold.controller;

import com.example.OldButGold.entity.Transaction;
import com.example.OldButGold.exception.RecordNotFoundException;
import com.example.OldButGold.request.TransactionRequest;
import com.example.OldButGold.request.TransactionResponse;
import com.example.OldButGold.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping(path = "run")
    ResponseEntity<TransactionResponse> runTransaction (@RequestBody TransactionRequest transactionRequest) throws RecordNotFoundException {
        TransactionResponse transactionResponse = transactionService.performTransaction(transactionRequest);

        return ResponseEntity.ok(transactionResponse);

    }


}
