package com.online.taxi.api.client;

import com.online.taxi.api.dto.SMSResponse;
import com.online.taxi.dto.SmsSendRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "message")
public interface SMSClient {

    @RequestMapping(value="/sms/send", method = RequestMethod.POST)
    SMSResponse sentSMS(SmsSendRequest request);
}
