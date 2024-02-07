package net.cisse.accountservice.repositories;

import net.cisse.accountservice.enteties.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
