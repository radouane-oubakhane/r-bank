package com.rbank.rbank.controller;

import com.rbank.rbank.dto.LoanResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LoansController {
    ResponseEntity<List<LoanResponse>> getLoansDetails(@RequestParam Long customerId);
}
