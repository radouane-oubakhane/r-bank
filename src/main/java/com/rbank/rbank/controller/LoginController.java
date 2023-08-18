package com.rbank.rbank.controller;

import com.rbank.rbank.dto.CustomerRequest;
import org.springframework.http.ResponseEntity;

public interface LoginController {
    ResponseEntity<String> registerUser(CustomerRequest customerRequest);
}
