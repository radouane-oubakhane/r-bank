package com.rbank.rbank.controller;

import com.rbank.rbank.dto.AccountResponse;
import org.springframework.http.ResponseEntity;

public interface AccountController {
    ResponseEntity<AccountResponse> getAccountDetails(Long customerId);
}
