package com.example.bankaccountservice.Entities;


import com.example.bankaccountservice.Enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

//using SpringData-Rest on peut spécifier les champs
@Projection(types = BankAccount.class, name = "projection1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
