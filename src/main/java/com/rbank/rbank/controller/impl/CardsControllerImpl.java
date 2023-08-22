package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.CardsController;
import com.rbank.rbank.dto.CardResponse;
import com.rbank.rbank.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardsControllerImpl implements CardsController {

    private final CardsService cardsService;


    @Override
    @GetMapping
    public ResponseEntity<List<CardResponse>> getCardsDetails(@RequestParam Long customerId) {
        return ResponseEntity.ok(cardsService.getCardsDetails(customerId));
    }
}
