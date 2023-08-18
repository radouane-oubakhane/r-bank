package com.rbank.rbank.repository;

import com.rbank.rbank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByCustomerId(long customerId);
}
