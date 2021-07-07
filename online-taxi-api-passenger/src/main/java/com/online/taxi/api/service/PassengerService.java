package com.online.taxi.api.service;

import com.online.taxi.api.client.PassengerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    @Autowired
    private PassengerClient passengerClient;

    public Object findByPhone(String phone) {
        return passengerClient.findByPhone(phone);
    }
}
