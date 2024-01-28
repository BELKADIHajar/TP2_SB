package com.example.bankaccountservice.Entities;

import com.example.bankaccountservice.Enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date created_date;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

}
