package com.rbank.rbank.controller;

import com.rbank.rbank.dto.AccountTransactionResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BalanceController {
    ResponseEntity<List<AccountTransactionResponse>> getBalance(Long customerId);
}
