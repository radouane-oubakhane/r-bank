package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.CardsController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardsControllerImpl implements CardsController {

    @GetMapping
    public String getCardsDetails() {
        return "Cards";
    }
}
