package com.example.OldButGold.controller;

import com.example.OldButGold.convertor.CurrencyConvertor;
import com.example.OldButGold.entity.Status;
import com.example.OldButGold.impl.StatusImpl;
import com.example.OldButGold.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "statuses")
public class StatusController {
    @Autowired
    StatusImpl statusService;

    @GetMapping(path = "/{id}")
    public Status getStatus (@PathVariable Long id) {
        return statusService.findById(id);
    }

    @PostMapping
    Status create(@RequestBody Status status){
        return  statusService.addStatus(status);
    }

    @GetMapping
    Set<Status> getAll(){
        return statusService.findAll();
    }
    @DeleteMapping(path = "/{id}")
    String delete(@PathVariable Long id) {
        statusService.deleteStatus(id);
        return "Deleted";

    }
}
