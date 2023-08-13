package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.LoginController;
import com.rbank.rbank.dto.CustomerRequest;
import com.rbank.rbank.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody CustomerRequest customer) {
        return loginService.registerUser(customer);
    }

}
