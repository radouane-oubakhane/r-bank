package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.ContactController;
import com.rbank.rbank.dto.ContactRequest;
import com.rbank.rbank.dto.ContactResponse;
import com.rbank.rbank.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactControllerImpl implements ContactController {

    private final ContactService contactService;

    @Override
    @PostMapping
    public ResponseEntity<ContactResponse> saveContactInquiryDetails(@RequestBody ContactRequest contactRequest) {
        return ResponseEntity.ok(contactService.saveContactInquiryDetails(contactRequest));
    }
}
