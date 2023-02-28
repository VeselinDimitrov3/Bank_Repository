package com.example.OldButGold.controller;

import com.example.OldButGold.convertor.CurrencyConvertor;
import com.example.OldButGold.convertor.StatusConvertor;
import com.example.OldButGold.entity.Status;
import com.example.OldButGold.impl.StatusImpl;
import com.example.OldButGold.request.StatusRequest;
import com.example.OldButGold.request.StatusResponse;
import com.example.OldButGold.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(path = "statuses")
public class StatusController {
    @Autowired
    StatusImpl statusService;
    @Autowired
    StatusConvertor statusConvertor;

    @GetMapping(path = "/name/{status}")
    ResponseEntity<StatusResponse> findByName(@PathVariable String status){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(statusConvertor.statusResponse(statusService.findByName(status)));
    }

    @PostMapping
    ResponseEntity<StatusResponse> save (@RequestBody StatusRequest statusRequest) throws SQLIntegrityConstraintViolationException {
        Status status = statusConvertor.convertStatus(statusRequest);
        Status savedStatus = statusService.addStatus(status);
        StatusResponse statusResponse = statusConvertor.statusResponse(savedStatus);
        return ResponseEntity
                .ok()
                .body(statusResponse);
    }

    @GetMapping(path = "/all")
    ResponseEntity<Set<StatusResponse>> getAll() {
        Set<StatusResponse> statusResponses = statusService.findAll()
                .stream()
                .map(statusConvertor::statusResponse)
                .collect(Collectors.toSet());
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(statusResponses);
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<String> deleteById(@PathVariable Long id){
            statusService.deleteStatus(id);
            return ResponseEntity
                    .ok()
                    .body(String.format("%d deleted", id));
        }

        @GetMapping(path = "/{id}")
    ResponseEntity<StatusResponse> getById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                        .body(statusConvertor.statusResponse(statusService.findById(id)));

        }


    }

