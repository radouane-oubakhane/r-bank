package com.rbank.rbank.controller;

import com.rbank.rbank.dto.CardResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CardsController {
    ResponseEntity<List<CardResponse>> getCardsDetails(Long customerId);
}
