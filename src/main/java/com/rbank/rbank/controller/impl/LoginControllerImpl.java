package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.LoginController;
import com.rbank.rbank.dto.CustomerRequest;
import com.rbank.rbank.dto.CustomerResponse;
import com.rbank.rbank.mapper.CustomerMapper;
import com.rbank.rbank.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;
    private final CustomerMapper customerMapper;


    @Override
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok(loginService.registerUser(customerRequest));
    }

    @GetMapping("/user")
    public ResponseEntity<CustomerResponse> getUserDetailsAfterLogin(Authentication authentication) {
        return ResponseEntity.ok(
                customerMapper.apply(
                        loginService.getCustomerByEmail(authentication.getName()))
                );
    }

}
