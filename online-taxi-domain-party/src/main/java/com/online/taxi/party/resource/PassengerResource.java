
package com.online.taxi.party.resource;

import com.online.taxi.constants.IdentityEnum;
import com.online.taxi.dto.GetTokenRequest;
import com.online.taxi.dto.PassengerRegisterResponse;
import com.online.taxi.party.application.PassengerApplicationService;
import com.online.taxi.party.domain.passenger.entity.Passenger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户资源
 * <p>
 * 对客户端以Restful形式暴露资源，提供对用户资源{@link com.online.taxi.party.domain.passenger.entity.Passenger}的管理入口
 **/
@Slf4j
@RestController
@RequestMapping(path = "/passenger", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@CacheConfig(cacheNames = "resource.passenger")
public class PassengerResource {

    @Autowired
    private PassengerApplicationService service;

    @GetMapping(path = "/phone/{phoneNum}")
    @Cacheable(key = "#phoneNum")
    @PreAuthorize("#oauth2.hasAnyScope('ROLE_API','BROWSER')")
    public Passenger getUser(@PathVariable("phoneNum") String phoneNum) {
        return service.findByPhone(phoneNum);
    }

    @PostMapping(value = "/register")
    public PassengerRegisterResponse getVerificationCode(@Validated @RequestBody GetTokenRequest request) {
        request.setIdentityStatus(IdentityEnum.PASSENGER.getCode());
        return service.register(request);
    }
}
