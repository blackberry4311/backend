package com.platform.papafood.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Base64;

@Slf4j
@Service
@Transactional(value = "transactionManager", propagation = Propagation.SUPPORTS)
public class TokenServiceImpl implements TokenService {
    private SecureRandom secureRandom = new SecureRandom();

    @Override
    public String generateBase64Token() {
        byte[] nextBytes = new byte[48];
        secureRandom.nextBytes(nextBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(nextBytes);
    }
}
