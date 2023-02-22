package com.example.OldButGold.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "IBAN", nullable = false)
    private String IBAN;
    private String address;
    @Column(name = "balance",nullable = false)
    private BigDecimal balance;

    @ManyToMany()
    @JoinTable(
            name = "client_statuses",
            joinColumns = {@JoinColumn (name = "client_id")},
            inverseJoinColumns = {@JoinColumn (name = "status_id")})
    private Set<Status> statuses;

    @OneToMany(mappedBy = "sender")
    @JsonBackReference
    private Set<Transaction> transactions;


}
