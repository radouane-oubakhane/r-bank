package com.rbank.rbank.mapper;

import com.rbank.rbank.dto.CustomerResponse;
import com.rbank.rbank.model.Customer;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class CustomerMapper implements Function<Customer, CustomerResponse> {

    @Override
    public CustomerResponse apply(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .mobileNumber(customer.getMobileNumber())
                .build();
    }
}
