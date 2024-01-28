package com.example.bankaccountservice.Web;

import com.example.bankaccountservice.BankAccountServiceApplication;
import com.example.bankaccountservice.DTO.BankAccountRequestDTO;
import com.example.bankaccountservice.DTO.BankAccountResponseDTO;
import com.example.bankaccountservice.Entities.BankAccount;
import com.example.bankaccountservice.Mappers.AccountMapper;
import com.example.bankaccountservice.Repositories.BanckAccountRepository;
import com.example.bankaccountservice.Service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BanckAccountRepository banckAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BanckAccountRepository banckAccountRepository,AccountService accountService, AccountMapper accountMapper) {
        this.banckAccountRepository = banckAccountRepository;
        this.accountService=accountService;
        this.accountMapper=accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccountList(){
        return banckAccountRepository.findAll();
    }

    @GetMapping("/bankAccount/{id}")
    public Optional<BankAccount> bankAccount(@PathVariable String id){
        return banckAccountRepository.findById(id);
    }

    /* Before using DTO
    @PostMapping("/bankAccount") //Pour ajouter en REST on utilise POST
    public BankAccount save(@RequestBody BankAccount bankAccount){//@RequestBody est utilisé pour reccupérer les données de la requete
        if(bankAccount.getId()== null) bankAccount.setId(UUID.randomUUID().toString());
        return banckAccountRepository.save(bankAccount);
    }
    */

    @PostMapping("/bankAccount") //Pour ajouter en REST on utilise POST
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }
    @PutMapping("/bankAccount/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount bankAccount1= banckAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account not found")));
        if(bankAccount.getBalance() !=null) bankAccount1.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreated_date()!=null)bankAccount1.setCreated_date(bankAccount.getCreated_date());
        if(bankAccount.getType()!=null)bankAccount1.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null)bankAccount1.setCurrency(bankAccount.getCurrency());
        return banckAccountRepository.save(bankAccount1);
    }

    @GetMapping("/deleteBankAccount/{id}")
    public void  deleteBankAccount(@PathVariable String id){
        banckAccountRepository.deleteById(id);
    }
}
