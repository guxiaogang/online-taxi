package com.online.taxi.api.client;

import com.online.taxi.dto.GetTokenRequest;
import com.online.taxi.dto.PassengerRegisterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "party")
public interface PassengerClient {

    @RequestMapping(value = "/passenger/register", method = RequestMethod.POST)
    PassengerRegisterResponse register(GetTokenRequest request);

    @GetMapping(path = "/passenger/phone/{phone}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Object findByPhone(@PathVariable("phone") String phone);
}
