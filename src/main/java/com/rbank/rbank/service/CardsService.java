package com.rbank.rbank.service;

import com.rbank.rbank.dto.CardResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CardsService {
    ResponseEntity<List<CardResponse>> getCardsDetails(Long customerId);
}
