package com.rbank.rbank.service;

import com.rbank.rbank.dto.CustomerRequest;
import com.rbank.rbank.model.Customer;

public interface LoginService {
    String registerUser(CustomerRequest customerRequest);

    Customer getCustomerByEmail(String email);


}
