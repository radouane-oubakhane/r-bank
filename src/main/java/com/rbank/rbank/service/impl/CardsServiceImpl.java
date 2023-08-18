package com.rbank.rbank.service.impl;

import com.rbank.rbank.dto.CardResponse;
import com.rbank.rbank.exception.CustomerNotFoundException;
import com.rbank.rbank.mapper.CardMapper;
import com.rbank.rbank.model.Card;
import com.rbank.rbank.repository.CardRepository;
import com.rbank.rbank.service.CardsService;
import com.rbank.rbank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CardsServiceImpl implements CardsService {

    private final CardRepository cardRepository;
    private final CustomerService customerService;
    private final CardMapper cardMapper;

    @Override
    public ResponseEntity<List<CardResponse>> getCardsDetails(Long customerId) {
    log.info("Fetching cards details for customer id: {}", customerId);
        if (!customerService.isCustomerExists(customerId)) {
            log.error("Customer not found for id: {}", customerId);
            throw new CustomerNotFoundException("Customer not found");
        }

        List<Card> cards = cardRepository.findByCustomerId(customerId);

        log.info("Fetched cards details for customer id: {}", customerId);
        return ResponseEntity.ok(cards.stream().map(cardMapper).toList());

    }
}
