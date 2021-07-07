package com.online.taxi.msg.domain.sms.repo;

import com.online.taxi.msg.domain.sms.entity.SmsTemplate;
import com.online.taxi.msg.domain.sms.mapper.SmsTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class SmsTemplateDao {

    @Autowired
    private SmsTemplateMapper smsTemplateMapper;

    public SmsTemplate findByTemplateId(String templateId) {
        return smsTemplateMapper.selectByTemplateId(templateId);
    }
}
