package com.rbank.rbank.service;

import com.rbank.rbank.dto.CardResponse;

import java.util.List;

public interface CardsService {
    List<CardResponse> getCardsDetails(Long customerId);
}
