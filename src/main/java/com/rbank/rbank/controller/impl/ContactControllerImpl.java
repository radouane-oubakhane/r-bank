package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.ContactController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/contact")
public class ContactControllerImpl implements ContactController {

    @GetMapping
    public String saveContactInquiryDetails() {
        return "Contact";
    }
}
