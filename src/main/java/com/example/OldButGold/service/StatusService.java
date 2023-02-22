package com.example.OldButGold.service;

import com.example.OldButGold.entity.Status;

import java.util.Set;

public interface StatusService {
    Status addStatus(Status status);
    void deleteStatus(Long id);
    Status findById (Long id);
    Set<Status> findAll();
}
