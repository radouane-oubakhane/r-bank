package com.rbank.rbank.controller;

import com.rbank.rbank.dto.ContactRequest;
import com.rbank.rbank.dto.ContactResponse;
import org.springframework.http.ResponseEntity;

public interface ContactController {
    ResponseEntity<ContactResponse> saveContactInquiryDetails(ContactRequest contactRequest);
}
