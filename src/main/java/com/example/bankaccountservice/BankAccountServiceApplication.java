package com.example.bankaccountservice;

import com.example.bankaccountservice.Entities.BankAccount;
import com.example.bankaccountservice.Repositories.BanckAccountRepository;
import com.example.bankaccountservice.Enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.bankaccountservice.Repositories"})
@EntityScan(basePackages = {"com.example.bankaccountservice.Entities"})
public class BankAccountServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BanckAccountRepository bankAccountRepository){
		return args -> {
			for (int i =0;i<10;i++){
				BankAccount bankAccount= BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
						.created_date(new Date())
						.balance(Math.random()*90000)
						.currency("MAD")
						.build();
				bankAccountRepository.save(bankAccount);
			}
		};
	}


}
