package com.rbank.rbank.service.impl;

import com.rbank.rbank.dto.AccountResponse;
import com.rbank.rbank.exception.CustomerNotFoundException;
import com.rbank.rbank.mapper.AccountMapper;
import com.rbank.rbank.model.Account;
import com.rbank.rbank.repository.AccountRepository;
import com.rbank.rbank.service.AccountService;
import com.rbank.rbank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountsRepository;
    private final CustomerService customerService;
    private final AccountMapper accountMapper;

    @Override
    public ResponseEntity<AccountResponse> getAccountDetails(Long customerId) {
        log.info("Fetching account details for customer id: {}", customerId);
        if (!customerService.isCustomerExists(customerId)) {
            log.error("Customer not found for id: {}", customerId);
            throw new CustomerNotFoundException("Customer not found");
        }
        Account account = accountsRepository.findByCustomerId(customerId).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found")
        );

        return ResponseEntity.ok(accountMapper.apply(account));
    }
}
