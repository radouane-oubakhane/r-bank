package com.rbank.rbank.service;

import com.rbank.rbank.dto.ContactRequest;
import com.rbank.rbank.dto.ContactResponse;
import org.springframework.http.ResponseEntity;

public interface ContactService {
    ResponseEntity<ContactResponse> saveContactInquiryDetails(ContactRequest contactRequest);
}
