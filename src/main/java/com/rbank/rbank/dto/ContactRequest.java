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
public class ContactRequest {
    private String contactName;
    private String contactEmail;
    private String subject;
    private String message;
    private Date createDt;
}

