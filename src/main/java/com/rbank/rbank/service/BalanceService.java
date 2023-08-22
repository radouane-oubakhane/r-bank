package com.rbank.rbank.service;

import com.rbank.rbank.dto.AccountTransactionResponse;

import java.util.List;

public interface BalanceService {
    List<AccountTransactionResponse> getBalanceDetails(Long customerId);
}
