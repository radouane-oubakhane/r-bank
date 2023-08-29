package com.rbank.rbank.service.impl;

import com.rbank.rbank.dto.CustomerRequest;
import com.rbank.rbank.exception.CustomerNotFoundException;
import com.rbank.rbank.mapper.CustomerRequestMapper;
import com.rbank.rbank.model.Customer;
import com.rbank.rbank.repository.CustomerRepository;
import com.rbank.rbank.service.LoginService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class LoginServiceImpl implements LoginService {

    private final CustomerRepository customerRepository;
    private final CustomerRequestMapper customerRequestMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public String registerUser(CustomerRequest customerRequest) {
        log.info("Registering user with email: {}", customerRequest.getEmail());
        if (customerRepository.existsByEmail(customerRequest.getEmail())) {
            log.error("Email already used: {}", customerRequest.getEmail());
            throw new IllegalArgumentException("Email already used");
        }
        if (customerRepository.existsByMobileNumber(customerRequest.getMobileNumber())) {
            log.error("Mobile number already used: {}", customerRequest.getMobileNumber());
            throw new IllegalArgumentException("Mobile number already used");
        }
        Customer customer = customerRequestMapper.apply(customerRequest);
        String hashPwd = passwordEncoder.encode(customer.getPwd());
        customer.setPwd(hashPwd);
        customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
        customerRepository.save(customer);
        log.info("User registered successfully with email: {}", customerRequest.getEmail());
        return"User registered successfully";
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
