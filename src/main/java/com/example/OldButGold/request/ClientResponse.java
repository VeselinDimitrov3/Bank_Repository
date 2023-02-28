package com.example.OldButGold.request;

import com.example.OldButGold.entity.Client;
import com.example.OldButGold.entity.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class ClientResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Set<Status> statuses;
    private BigDecimal balance;

}
