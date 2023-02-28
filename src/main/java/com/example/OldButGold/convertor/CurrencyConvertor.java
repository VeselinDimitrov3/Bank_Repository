package com.example.OldButGold.convertor;

import com.example.OldButGold.entity.Currency;
import com.example.OldButGold.request.CurrencyRequest;
import com.example.OldButGold.request.CurrencyResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class CurrencyConvertor {

    public Currency convertCurrency (CurrencyRequest currencyRequest) {
        return Currency.builder()
                .currencyCode(currencyRequest.getCurrencyName())
                .build();
    }

    public CurrencyResponse toCurrencyResponse (Currency currencyCoder) {
        return CurrencyResponse.builder()
                .currencyName(currencyCoder.getCurrencyCode())
                .build();
    }
}
