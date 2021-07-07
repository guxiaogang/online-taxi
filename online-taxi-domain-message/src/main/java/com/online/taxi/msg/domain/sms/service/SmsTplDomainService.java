package com.online.taxi.msg.domain.sms.service;

import com.online.taxi.msg.domain.sms.entity.SmsTemplate;
import com.online.taxi.msg.domain.sms.repo.SmsTemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsTplDomainService {

    @Autowired
    private SmsTemplateDao smsTemplateDao;

    public SmsTemplate findByTemplateId(String templateId) {
        return smsTemplateDao.findByTemplateId(templateId);
    }
}
