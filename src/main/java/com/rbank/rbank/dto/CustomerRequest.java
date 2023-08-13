package com.rbank.rbank.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String email;
    private String pwd;
    private String role;
}