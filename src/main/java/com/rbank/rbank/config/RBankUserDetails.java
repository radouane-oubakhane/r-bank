package com.rbank.rbank.config;

import com.rbank.rbank.model.Customer;
import com.rbank.rbank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class RBankUserDetails implements UserDetailsService {

    private final CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password;
        List<GrantedAuthority> authorities;
        Customer customer = customerRepository.findByEmail(username);
        if (customer != null) {
            userName = customer.getEmail();
            password = customer.getPwd();
            authorities = List.of(customer::getRole);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new User(userName, password, authorities);
    }
}
