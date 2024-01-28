package com.example.bankaccountservice.Mappers;

import com.example.bankaccountservice.DTO.BankAccountResponseDTO;
import com.example.bankaccountservice.Entities.BankAccount;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);

        return bankAccountResponseDTO;
    }
}
