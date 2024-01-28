package com.example.bankaccountservice.Service;

import com.example.bankaccountservice.DTO.BankAccountRequestDTO;
import com.example.bankaccountservice.DTO.BankAccountResponseDTO;
import com.example.bankaccountservice.Entities.BankAccount;
import com.example.bankaccountservice.Repositories.BanckAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Toutes les methodes sans Trans

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BanckAccountRepository banckAccountRepository;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        //Mapping
        BankAccount bankAccount= BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .created_date(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount bankAccountsaved= banckAccountRepository.save(bankAccount);
        //BankAccountMapper
        BankAccountResponseDTO bankAccountResponseDTO = BankAccountResponseDTO.builder()
                .id(bankAccountsaved.getId())
                .created_date(bankAccountsaved.getCreated_date())
                .balance(bankAccountsaved.getBalance())
                .type(bankAccountsaved.getType())
                .currency(bankAccountsaved.getCurrency())
                .build();
        return bankAccountResponseDTO;
    }
}
