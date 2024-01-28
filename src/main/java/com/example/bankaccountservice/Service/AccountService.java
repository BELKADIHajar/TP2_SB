package com.example.bankaccountservice.Service;

import com.example.bankaccountservice.DTO.BankAccountRequestDTO;
import com.example.bankaccountservice.DTO.BankAccountResponseDTO;
import com.example.bankaccountservice.Entities.BankAccount;
import com.example.bankaccountservice.Enums.AccountType;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
