package com.example.OldButGold.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TransactionRequest {
    private String sourceEmail;
    private String destinationEmail;
    private Double amount;
    private CurrencyRequest currency;
    private String reason;
}
