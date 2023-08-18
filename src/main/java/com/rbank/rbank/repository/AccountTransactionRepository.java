package com.rbank.rbank.repository;

import com.rbank.rbank.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
    List<AccountTransaction> findByCustomerIdOrderByTransactionDtDesc(Long customerId);
}
