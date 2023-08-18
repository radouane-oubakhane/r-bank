package com.rbank.rbank.service;

import com.rbank.rbank.dto.AccountTransactionResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BalanceService {
    ResponseEntity<List<AccountTransactionResponse>> getBalanceDetails(Long customerId);
}
