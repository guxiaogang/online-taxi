
package com.online.taxi.api.resource;

import com.online.taxi.api.dto.SMSRequest;
import com.online.taxi.api.dto.SMSResponse;
import com.online.taxi.api.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/sms", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class SMSResource {

    @Autowired
    private SMSService smsService;

    /**
     * 根据用户名称获取用户详情
     */
    @PreAuthorize("#oauth2.hasAnyScope('ROLE_SMS','BROWSER')")
    @PostMapping("/verify-code")
    public SMSResponse getUser(@RequestBody @Validated SMSRequest shortMsgRequest) {
        return smsService.sentSMS(shortMsgRequest.getPhoneNumber());
    }

}
