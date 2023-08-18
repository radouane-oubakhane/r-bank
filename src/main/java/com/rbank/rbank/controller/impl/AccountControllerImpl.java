package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.AccountController;
import com.rbank.rbank.dto.AccountResponse;
import com.rbank.rbank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountControllerImpl implements AccountController {
    private final AccountService accountService;


    @Override
    @GetMapping
    public ResponseEntity<AccountResponse> getAccountDetails(Long customerId) {
        return accountService.getAccountDetails(customerId);
    }
}


