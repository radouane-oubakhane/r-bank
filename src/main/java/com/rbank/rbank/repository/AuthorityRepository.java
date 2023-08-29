package com.rbank.rbank.repository;

import com.rbank.rbank.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Set<Authority> findByCustomerId(Long customerId);
}
