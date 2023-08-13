package com.rbank.rbank.service;

import com.rbank.rbank.dto.CustomerRequest;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<String> registerUser(CustomerRequest customerRequest);
}
