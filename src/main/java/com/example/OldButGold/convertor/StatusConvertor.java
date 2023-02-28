package com.example.OldButGold.convertor;

import com.example.OldButGold.entity.Status;
import com.example.OldButGold.request.StatusRequest;
import com.example.OldButGold.request.StatusResponse;
import org.springframework.stereotype.Component;

@Component
public class StatusConvertor {

    public Status convertStatus (StatusRequest statusRequest) {
        return Status.builder()
                .status(statusRequest.getStatus())
                .build();
    }
    public StatusResponse statusResponse (Status statusName) {
        return StatusResponse.builder()
                .status(statusName.getStatus())
                .build();
    }

}
