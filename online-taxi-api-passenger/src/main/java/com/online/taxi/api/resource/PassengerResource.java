package com.online.taxi.api.resource;

import com.online.taxi.api.service.AuthService;
import com.online.taxi.api.service.PassengerService;
import com.online.taxi.dto.GetTokenRequest;
import com.online.taxi.dto.PassengerRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/passenger", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PassengerResource {

    @Autowired
    private AuthService authService;

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/login")
    @PreAuthorize("#oauth2.hasAnyScope('ROLE_SMS','BROWSER')")
    public PassengerRegisterResponse login(@RequestBody @Validated GetTokenRequest request) {
        return authService.login(request);
    }

    @GetMapping("/{phone}")
    @PreAuthorize("#oauth2.hasAnyScope('ROLE_SMS','BROWSER')")
    public Object getUser(@PathVariable("phone") String phone) {
        return passengerService.findByPhone(phone);
    }
}
