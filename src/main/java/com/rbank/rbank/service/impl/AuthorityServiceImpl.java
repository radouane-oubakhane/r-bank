package com.rbank.rbank.service.impl;

import com.rbank.rbank.model.Authority;
import com.rbank.rbank.repository.AuthorityRepository;
import com.rbank.rbank.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository authorityRepository;

    @Override
    public Set<Authority> getAuthority(Long customerId) {
        log.info("Fetching Authority for customer id: {}", customerId);
        return authorityRepository.findByCustomerId(customerId);
    }
}
