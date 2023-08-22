package com.rbank.rbank.service.impl;

import com.rbank.rbank.exception.CustomerNotFoundException;
import com.rbank.rbank.model.Customer;
import com.rbank.rbank.repository.CustomerRepository;
import com.rbank.rbank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public boolean isCustomerExists(long customerId) {
        log.info("Checking if customer exists for id: {}", customerId);
        return customerRepository.existsById(customerId);
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
