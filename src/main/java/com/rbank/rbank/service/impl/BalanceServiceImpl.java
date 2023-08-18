package com.rbank.rbank.service.impl;

import com.rbank.rbank.dto.AccountTransactionResponse;
import com.rbank.rbank.exception.CustomerNotFoundException;
import com.rbank.rbank.mapper.AccountTransactionMapper;
import com.rbank.rbank.model.AccountTransaction;
import com.rbank.rbank.repository.AccountTransactionRepository;
import com.rbank.rbank.service.BalanceService;
import com.rbank.rbank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class BalanceServiceImpl implements BalanceService {

    private final AccountTransactionRepository accountTransactionRepository;
    private final CustomerService customerService;
    private final AccountTransactionMapper accountTransactionMapper;
    @Override
    public ResponseEntity<List<AccountTransactionResponse>> getBalanceDetails(Long customerId) {
        log.info("Fetching balance details for customer id: {}", customerId);
        if (!customerService.isCustomerExists(customerId)) {
            log.error("Customer not found for id: {}", customerId);
            throw new CustomerNotFoundException("Customer not found");
        }

        List<AccountTransaction> accountTransactions = accountTransactionRepository.findByCustomerIdOrderByTransactionDtDesc(customerId);

        log.info("Fetched balance details for customer id: {}", customerId);
        return ResponseEntity.ok(accountTransactions.stream().map(accountTransactionMapper).toList());
    }
}
