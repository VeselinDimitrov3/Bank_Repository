package com.example.OldButGold.request;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TransactionResponse {

    private String transactionMessage;
}
