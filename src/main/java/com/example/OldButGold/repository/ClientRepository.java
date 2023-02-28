package com.example.OldButGold.repository;

import com.example.OldButGold.entity.Client;
import com.example.OldButGold.request.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
}
