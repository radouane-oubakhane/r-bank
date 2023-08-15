package com.rbank.rbank.service;

import com.rbank.rbank.dto.CustomerRequest;
import com.rbank.rbank.model.Customer;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<String> registerUser(CustomerRequest customerRequest);

    Customer getCustomerByEmail(String email);

}
