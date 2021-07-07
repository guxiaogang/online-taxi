
package com.online.taxi.msg.resource;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.SmsSendRequest;
import com.online.taxi.msg.application.SMSApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sms", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class SMSResource {

    @Autowired
    private SMSApplicationService smsApplicationService;

    @PostMapping(value = "/send")
    @PreAuthorize("#oauth2.hasAnyScope('ROLE_SMS','BROWSER')")
    public ResponseResult send(@RequestBody SmsSendRequest smsSendRequest) {
        smsApplicationService.sendSms(smsSendRequest);
        return ResponseResult.success("");
    }
}
