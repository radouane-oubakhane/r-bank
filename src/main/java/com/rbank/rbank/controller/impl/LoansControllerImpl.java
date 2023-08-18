package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.LoansController;
import com.rbank.rbank.dto.LoanResponse;
import com.rbank.rbank.service.LoansService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
public class LoansControllerImpl implements LoansController {

    private final LoansService loansService;


    @Override
    @GetMapping
    public ResponseEntity<List<LoanResponse>> getLoansDetails(@RequestParam Long customerId) {
        return loansService.getLoansDetails(customerId);
    }
}
