package com.rbank.rbank.service;

import com.rbank.rbank.dto.AccountResponse;

public interface AccountService {
    AccountResponse getAccountDetails(Long customerId);
}
