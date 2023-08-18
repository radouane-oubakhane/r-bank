package com.rbank.rbank.service.impl;

import com.rbank.rbank.dto.ContactRequest;
import com.rbank.rbank.dto.ContactResponse;
import com.rbank.rbank.mapper.ContactMapper;
import com.rbank.rbank.mapper.ContactRequestMapper;
import com.rbank.rbank.model.Contact;
import com.rbank.rbank.repository.ContactRepository;
import com.rbank.rbank.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;
    private final ContactRequestMapper contactRequestMapper;
    @Override
    public ResponseEntity<ContactResponse> saveContactInquiryDetails(ContactRequest contactRequest) {
        log.info("Saving contact inquiry details");
        Contact contact = contactRequestMapper.apply(contactRequest);
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        contact = contactRepository.save(contact);
        return ResponseEntity.ok(contactMapper.apply(contact));
    }
}
