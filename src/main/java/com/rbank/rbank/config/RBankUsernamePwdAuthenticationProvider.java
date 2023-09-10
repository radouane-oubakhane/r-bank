package com.rbank.rbank.config;

import com.rbank.rbank.model.Authority;
import com.rbank.rbank.model.Customer;
import com.rbank.rbank.service.AuthorityService;
import com.rbank.rbank.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class RBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private final LoginService loginService;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Customer customer = loginService.getCustomerByEmail(userName);
        Set<Authority> authorities = authorityService.getAuthority(customer.getId());


        if (passwordEncoder.matches(pwd, customer.getPwd())) {
            return new UsernamePasswordAuthenticationToken(userName, pwd, getGrantedAuthorities(authorities));
        }
        throw new BadCredentialsException("Invalid credentials");
    }


    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        authorities.forEach(authority -> grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName())));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
