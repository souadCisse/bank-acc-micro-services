package net.cisse.accountservice;

import net.cisse.accountservice.clients.CustomerRestClient;
import net.cisse.accountservice.enteties.BankAccount;
import net.cisse.accountservice.enums.AccountType;
import net.cisse.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){
		return args -> {
			customerRestClient.allCustomers().forEach(c->{
				BankAccount bankAccount1=BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.balance(900000)
						.createdAt(LocalDate.now())
						.currency("MAD")
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(c.getId())
						.build();
				bankAccountRepository.save(bankAccount1);
				BankAccount bankAccount2=BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.balance(1000)
						.createdAt(LocalDate.now())
						.currency("EUR")
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(c.getId())
						.build();
				bankAccountRepository.save(bankAccount2);
			});

		};
	}

}
