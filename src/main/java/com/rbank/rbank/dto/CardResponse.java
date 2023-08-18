package com.rbank.rbank.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    private Long cardId;
    private Long customerId;
    private String cardNumber;
    private String cardType;
    private int totalLimit;
    private int availableAmount;
    private Date createDt;
}
