package com.rbank.rbank.repository;

import com.rbank.rbank.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByCustomerIdOrderByStartDtDesc(Long customerId);
}
