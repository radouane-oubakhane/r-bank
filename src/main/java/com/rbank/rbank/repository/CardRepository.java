package com.rbank.rbank.repository;

import com.rbank.rbank.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByCustomerId(Long customerId);
}
