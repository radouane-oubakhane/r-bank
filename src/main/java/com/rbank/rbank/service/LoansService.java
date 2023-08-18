package com.rbank.rbank.service;

import com.rbank.rbank.dto.LoanResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoansService {
    ResponseEntity<List<LoanResponse>> getLoansDetails(Long customerId);
}
