package com.rbank.rbank.mapper;

import com.rbank.rbank.dto.ContactRequest;
import com.rbank.rbank.model.Contact;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class ContactRequestMapper implements Function<ContactRequest, Contact> {
    @Override
    public Contact apply(ContactRequest contactRequest) {
        return Contact.builder()
                .contactName(contactRequest.getContactName())
                .contactEmail(contactRequest.getContactEmail())
                .subject(contactRequest.getSubject())
                .message(contactRequest.getMessage())
                .build();
    }
}
