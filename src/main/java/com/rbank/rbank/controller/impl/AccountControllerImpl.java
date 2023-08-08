package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.AccountController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountControllerImpl implements AccountController {

    @GetMapping
    public String getAccountDetails() {
        return "Account details";
    }
}
