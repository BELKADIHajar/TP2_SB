package com.example.bankaccountservice.Repositories;
import com.example.bankaccountservice.Entities.BankAccount;
import com.example.bankaccountservice.Enums.AccountType;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
// Lors du demarrage , lance un web service Restfull qui permet de gerer les entités (sans créer les controleurs)
public interface BanckAccountRepository extends JpaRepository<BankAccount, String> {
List<BankAccount> findBankAccountByType(AccountType type);
//N.B : 
    //Si on utilise le RestController il faut créer la methode findBankAccountByType
    //par contre avec SpringDataRest on peut y accéeder direcrtement

}
