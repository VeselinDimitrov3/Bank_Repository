package com.example.OldButGold.request;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CurrencyResponse {

    private String currencyName;


}
