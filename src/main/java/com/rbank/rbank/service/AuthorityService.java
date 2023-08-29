package com.rbank.rbank.service;

import com.rbank.rbank.model.Authority;

import java.util.Set;

public interface AuthorityService {
    public Set<Authority> getAuthority(Long customerId);
}
