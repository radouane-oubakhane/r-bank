package com.rbank.rbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
) // Enable method level security
public class RBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(RBankApplication.class, args);
    }

}
