package com.example.bankaccountservice.DTO;

import com.example.bankaccountservice.Enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date created_date;
    private Double balance;
    private String currency;
    private AccountType type;
}
