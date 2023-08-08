package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.BalanceController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceControllerImpl implements BalanceController {


    @GetMapping
    public String getBalance() {
        return "Balance";
    }

}
