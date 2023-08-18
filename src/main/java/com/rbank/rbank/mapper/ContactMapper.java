package com.rbank.rbank.mapper;

import com.rbank.rbank.dto.ContactResponse;
import com.rbank.rbank.model.Contact;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class ContactMapper implements Function<Contact, ContactResponse> {
    @Override
    public ContactResponse apply(Contact contact) {
        return ContactResponse.builder()
                .contactId(contact.getContactId())
                .contactName(contact.getContactName())
                .contactEmail(contact.getContactEmail())
                .subject(contact.getSubject())
                .message(contact.getMessage())
                .createDt(contact.getCreateDt())
                .build();
    }
}
