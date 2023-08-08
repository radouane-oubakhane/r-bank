package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.LoansController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoansControllerImpl implements LoansController {
    @GetMapping
    public String getLoansDetails() {
        return "Loans";
    }
}
