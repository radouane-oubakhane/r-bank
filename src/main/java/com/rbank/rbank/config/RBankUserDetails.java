package com.rbank.rbank.config;

import com.rbank.rbank.model.Customer;
import com.rbank.rbank.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class RBankUserDetails implements UserDetailsService {

    private final LoginService loginService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer = loginService.getCustomerByEmail(username);

        return new User(
                customer.getEmail(),
                customer.getPwd(),
                List.of(customer::getRole)
        );
    }
}
