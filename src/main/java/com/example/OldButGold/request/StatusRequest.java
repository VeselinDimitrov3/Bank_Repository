package com.example.OldButGold.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StatusRequest {
    @Size(min = 4, message = "Status name should contain at least 4 letters")
    private String status;
}
