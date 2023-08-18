package com.rbank.rbank.mapper;

import com.rbank.rbank.dto.CardResponse;
import com.rbank.rbank.model.Card;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class CardMapper implements Function<Card, CardResponse> {

    @Override
    public CardResponse apply(Card card) {
        return CardResponse.builder()
                .cardId(card.getCardId())
                .customerId(card.getCustomerId())
                .cardNumber(card.getCardNumber())
                .cardType(card.getCardType())
                .totalLimit(card.getTotalLimit())
                .availableAmount(card.getAvailableAmount())
                .createDt(card.getCreateDt())
                .build();
    }

}
