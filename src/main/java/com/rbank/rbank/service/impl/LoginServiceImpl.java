package com.rbank.rbank.service.impl;

import com.rbank.rbank.dto.CustomerRequest;
import com.rbank.rbank.exception.CustomerNotFoundException;
import com.rbank.rbank.mapper.CustomerRequestMapper;
import com.rbank.rbank.model.Customer;
import com.rbank.rbank.repository.CustomerRepository;
import com.rbank.rbank.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final CustomerRepository customerRepository;
    private final CustomerRequestMapper customerRequestMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public ResponseEntity<String> registerUser(CustomerRequest customerRequest) {
        log.info("Registering user with email: {}", customerRequest.getEmail());
        if (customerRepository.existsByEmail(customerRequest.getEmail())) {
            log.error("Email already used: {}", customerRequest.getEmail());
            return ResponseEntity.badRequest().body("Email already used");
        }
        Customer customer = customerRequestMapper.apply(customerRequest);
        String hashPwd = passwordEncoder.encode(customer.getPwd());
        customer.setPwd(hashPwd);
        customerRepository.save(customer);
        log.info("User registered successfully with email: {}", customerRequest.getEmail());
        return ResponseEntity.ok("User registered successfully");
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            log.error("Customer not found for email: {}", email);
            throw new CustomerNotFoundException("Customer not found");
        }
        return customer;
    }
}
