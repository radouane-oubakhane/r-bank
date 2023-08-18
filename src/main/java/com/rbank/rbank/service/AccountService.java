package com.rbank.rbank.service;

import com.rbank.rbank.dto.AccountResponse;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<AccountResponse> getAccountDetails(Long customerId);
}
