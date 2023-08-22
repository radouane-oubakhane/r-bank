package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.BalanceController;
import com.rbank.rbank.dto.AccountTransactionResponse;
import com.rbank.rbank.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/balance")
public class BalanceControllerImpl implements BalanceController {

    private final BalanceService balanceService;


    @Override
    @RequestMapping
    public ResponseEntity<List<AccountTransactionResponse>> getBalance(@RequestParam Long customerId) {
        return ResponseEntity.ok(balanceService.getBalanceDetails(customerId));
    }
}
