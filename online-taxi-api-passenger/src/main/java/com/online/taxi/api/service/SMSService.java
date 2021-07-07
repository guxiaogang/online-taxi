package com.online.taxi.api.service;

import com.online.taxi.api.client.SMSClient;
import com.online.taxi.api.dto.SMSResponse;
import com.online.taxi.dto.SmsSendRequest;
import com.online.taxi.dto.SmsTemplateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class SMSService {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @Autowired
    private SMSClient smsClient;

    public SMSResponse sentSMS(String phone) {
        String code = verificationCodeService.getCode(phone);
        SmsSendRequest smsSendRequest = new SmsSendRequest();
        String[] phoneNumbers = new String[]{phone};
        smsSendRequest.setReceivers(phoneNumbers);

        List<SmsTemplateDto> data = new ArrayList<>();
        SmsTemplateDto dto = new SmsTemplateDto();
        dto.setId("SMS_144145499");
        int templateSize = 1;
        HashMap<String, Object> templateMap = new HashMap<>(templateSize);
        templateMap.put("code", code);
        dto.setTemplateMap(templateMap);
        data.add(dto);
        smsSendRequest.setData(data);

        //feign调用
        SMSResponse result = null;
        try {
            result = smsClient.sentSMS(smsSendRequest);
        } catch (Exception e) {
            log.error("Sent SMS error.", e);
            throw new RuntimeException("Sent SMS error.");
        }
        return null;
    }
}
