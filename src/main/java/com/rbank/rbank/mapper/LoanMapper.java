package com.rbank.rbank.mapper;

import com.rbank.rbank.dto.LoanResponse;
import com.rbank.rbank.model.Loan;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class LoanMapper implements Function<Loan, LoanResponse> {
    @Override
    public LoanResponse apply(Loan loan) {
        return LoanResponse.builder()
                .loanNumber(loan.getLoanNumber())
                .customerId(loan.getCustomerId())
                .startDt(loan.getStartDt())
                .loanType(loan.getLoanType())
                .totalLoan(loan.getTotalLoan())
                .amountPaid(loan.getAmountPaid())
                .outstandingAmount(loan.getOutstandingAmount())
                .createDt(loan.getCreateDt())
                .build();
    }
}
