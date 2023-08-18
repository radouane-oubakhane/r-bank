package com.rbank.rbank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {

    private long customerId;
    private long accountNumber;
    private String accountType;
    private String branchAddress;
    private String createDt;
}
