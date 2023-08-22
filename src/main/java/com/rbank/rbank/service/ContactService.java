package com.rbank.rbank.service;

import com.rbank.rbank.dto.ContactRequest;
import com.rbank.rbank.dto.ContactResponse;

public interface ContactService {
    ContactResponse saveContactInquiryDetails(ContactRequest contactRequest);
}
