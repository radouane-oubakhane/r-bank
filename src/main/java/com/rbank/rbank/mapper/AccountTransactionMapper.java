package com.rbank.rbank.mapper;

import com.rbank.rbank.dto.AccountTransactionResponse;
import com.rbank.rbank.model.AccountTransaction;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class AccountTransactionMapper implements Function<AccountTransaction, AccountTransactionResponse> {

    @Override
    public AccountTransactionResponse apply(AccountTransaction accountTransaction) {
        return AccountTransactionResponse.builder()
                .transactionId(accountTransaction.getTransactionId())
                .accountNumber(accountTransaction.getAccountNumber())
                .customerId(accountTransaction.getCustomerId())
                .transactionDt(accountTransaction.getTransactionDt())
                .transactionSummary(accountTransaction.getTransactionSummary())
                .transactionType(accountTransaction.getTransactionType())
                .transactionAmt(accountTransaction.getTransactionAmt())
                .closingBalance(accountTransaction.getClosingBalance())
                .createDt(accountTransaction.getCreateDt())
                .build();
    }
}
