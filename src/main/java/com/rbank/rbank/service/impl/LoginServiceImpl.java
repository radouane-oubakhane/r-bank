package com.rbank.rbank.service.impl;

import com.rbank.rbank.dto.CustomerRequest;
import com.rbank.rbank.mapper.CustomerRequestMapper;
import com.rbank.rbank.model.Customer;
import com.rbank.rbank.repository.CustomerRepository;
import com.rbank.rbank.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final CustomerRepository customerRepository;
    private final CustomerRequestMapper customerRequestMapper;


    @Override
    public ResponseEntity<String> registerUser(CustomerRequest customerRequest) {
        if (customerRepository.existsByEmail(customerRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Email already used");
        }
        Customer customer = customerRequestMapper.apply(customerRequest);
        customerRepository.save(customer);
        return ResponseEntity.ok("User registered successfully");
    }
}
