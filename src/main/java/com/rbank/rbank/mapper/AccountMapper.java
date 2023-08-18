package com.rbank.rbank.mapper;

import com.rbank.rbank.dto.AccountResponse;
import com.rbank.rbank.model.Account;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class AccountMapper implements Function<Account, AccountResponse> {
    @Override
    public AccountResponse apply(Account account) {
        return AccountResponse.builder()
                .customerId(account.getCustomerId())
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .branchAddress(account.getBranchAddress())
                .createDt(account.getCreateDt())
                .build();
    }
}
