package com.rbank.rbank.mapper;

import com.rbank.rbank.dto.CustomerRequest;
import com.rbank.rbank.model.Customer;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class CustomerRequestMapper implements Function<CustomerRequest, Customer> {

    @Override
    public Customer apply(CustomerRequest customerRequest) {
        return Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .mobileNumber(customerRequest.getMobileNumber())
                .pwd(customerRequest.getPwd())
                .role(customerRequest.getRole())
                .build();
    }
}
