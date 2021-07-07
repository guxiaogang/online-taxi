package com.online.taxi.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VerificationCodeService {

    public String getCode(String phoneNumber) {
        log.info("Generate code for phone: {}", phoneNumber);
        return "123456";
    }
}
