package com.online.taxi.api.service;

import com.online.taxi.api.client.PassengerClient;
import com.online.taxi.api.client.WalletClient;
import com.online.taxi.dto.GetTokenRequest;
import com.online.taxi.dto.PassengerRegisterResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthService {

    @Autowired
    private PassengerClient passengerClient;

    @Autowired
    private WalletClient walletClient;

    @Autowired
    private VerificationCodeService verificationCodeService;

    public PassengerRegisterResponse login(GetTokenRequest request) {
        String code = verificationCodeService.getCode(request.getPhone());
        if (!StringUtils.equalsIgnoreCase(code, request.getVerifyCode())) {
            throw new IllegalArgumentException("Invalid verify code");
        }
        PassengerRegisterResponse response = passengerClient.register(request);
        if (response.isNewer()) {
            walletClient.init(response.getId());
        }
        return response;
    }
}
