package com.example.OldButGold.service;


import com.example.OldButGold.entity.Client;
import com.example.OldButGold.exception.RecordNotFoundException;
import com.example.OldButGold.request.ClientPasswordUpdate;
import com.example.OldButGold.request.ClientRequest;
import com.example.OldButGold.request.ClientResponse;
import com.example.OldButGold.request.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;


public interface ClientService  {

    ClientResponse saveClient(ClientRequest client) throws RecordNotFoundException;
    void updateClient(ClientPasswordUpdate client) throws RecordNotFoundException;
    ClientResponse getClient(Long id) throws RecordNotFoundException;
    void deleteClient(Long id);
    ClientResponse login(LoginRequest loginRequest) throws RecordNotFoundException;

    Client findByEmail(String email);


}
