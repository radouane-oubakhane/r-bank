package com.rbank.rbank.service;

import com.rbank.rbank.model.Customer;

public interface CustomerService {
    boolean isCustomerExists(long customerId);
    Customer getCustomerByEmail(String email);

}
