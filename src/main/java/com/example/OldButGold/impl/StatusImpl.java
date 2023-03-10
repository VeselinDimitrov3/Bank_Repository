package com.example.OldButGold.impl;

import com.example.OldButGold.entity.Status;
import com.example.OldButGold.repository.StatusRepository;
import com.example.OldButGold.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StatusImpl implements StatusService {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusImpl (StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status addStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }

    @Override
    public Status findById(Long id) {
        return statusRepository.findById(id).orElseThrow();
    }

    @Override
    public Set<Status> findAll() {
        return statusRepository.findAll().stream().collect(Collectors.toSet());
    }
}
