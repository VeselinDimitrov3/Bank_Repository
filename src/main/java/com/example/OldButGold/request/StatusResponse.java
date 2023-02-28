package com.example.OldButGold.request;


import com.example.OldButGold.entity.Status;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class StatusResponse {

    private String status;
}
