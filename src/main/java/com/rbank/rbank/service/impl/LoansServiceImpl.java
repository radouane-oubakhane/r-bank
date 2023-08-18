package com.rbank.rbank.service.impl;

import com.rbank.rbank.dto.LoanResponse;
import com.rbank.rbank.exception.CustomerNotFoundException;
import com.rbank.rbank.mapper.LoanMapper;
import com.rbank.rbank.model.Loan;
import com.rbank.rbank.repository.LoanRepository;
import com.rbank.rbank.service.CustomerService;
import com.rbank.rbank.service.LoansService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class LoansServiceImpl implements LoansService {

    private final LoanRepository loanRepository;
    private final CustomerService customerService;
    private final LoanMapper loanMapper;
    @Override
    public ResponseEntity<List<LoanResponse>> getLoansDetails(Long customerId) {
        log.info("Fetching loans details for customer id: {}", customerId);

        if (!customerService.isCustomerExists(customerId)) {
            log.error("Customer not found for id: {}", customerId);
            throw new CustomerNotFoundException("Customer not found");
        }

        List<Loan> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customerId);

        log.info("Fetched loans details for customer id: {}", customerId);

        return ResponseEntity.ok(loans.stream().map(loanMapper).toList());

    }
}
