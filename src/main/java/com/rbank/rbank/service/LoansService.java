package com.rbank.rbank.service;

import com.rbank.rbank.dto.LoanResponse;

import java.util.List;

public interface LoansService {
    List<LoanResponse> getLoansDetails(Long customerId);
}
