package com.rbank.rbank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    private String contactName;
    private String contactEmail;
    private String subject;
    private String message;
}

