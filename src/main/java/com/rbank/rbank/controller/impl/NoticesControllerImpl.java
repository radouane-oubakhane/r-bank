package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.NoticesController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/notices")
public class NoticesControllerImpl implements NoticesController {

    @GetMapping
    public String getNoticesDetails() {
        return "Notices";
    }

}

